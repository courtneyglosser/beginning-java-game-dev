/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import javafx.scene.image.Image;


/**
 *
 * @author courtney
 */
public class Deity extends MovingActor {
    protected Visitor iVisitor;
    private boolean isLanding, isAscending;
    private double descendRate = 6;
    private double ascendRate = 3;

    public Deity(Visitor iVisitor, String SVGData, double xLocation, double yLocation, Image... spriteCels) {
        super (SVGData, xLocation, yLocation, spriteCels);
        this.iVisitor = iVisitor;
        isLanding = isAscending = false;
    }

    @Override
    public void update() {
        if (!iVisitor.isInHeaven()) {
            setXYLocation();
            setBoundaries();
            setImageState();
            moveSprite(iX, iY);
        }
    }

    private void setXYLocation() {
        if (isLanding) {
            if (iY <= CENTER_Y) {
                iY += vY;
            }
            else {
                isLanding = false;
                vY = vY / descendRate;
                // animate explosion:
                System.out.println("Explosion moment!");
            }
        }
        else {
            if (iVisitor.isRight()) { iX += vX; }
            if (iVisitor.isLeft())  { iX -= vX; }
            if (iVisitor.isDown())  { iY += vY; }
            if (iVisitor.isUp())    { iY -= vY; }
        }
    }

    private void setBoundaries() {
        if (iX >= RIGHT_BOUNDARY) { iX = RIGHT_BOUNDARY; }
        if (iX <= LEFT_BOUNDARY) { iX = LEFT_BOUNDARY; }
        if (iY >= TOP_BOUNDARY) { iY = TOP_BOUNDARY; }
        if (iY <= BOTTOM_BOUNDARY) { iY = BOTTOM_BOUNDARY; }
    }

    private void setImageState() {
        int imageState = 0;
        if (!isMoving()) {
            framecount = 0;
            walkstate = 0;
        }
        if (iVisitor.isRight()) {
            imageState = calcImageState(3);
            this.spriteFrame.setImage(imageStates.get(imageState));
            this.spriteFrame.setScaleX(-1);
        }
        if (iVisitor.isLeft()) {
            imageState = calcImageState(3);
            this.spriteFrame.setImage(imageStates.get(imageState));
            this.spriteFrame.setScaleX(1);
        }
        if (iVisitor.isDown()) {
            imageState = calcImageState(0);
            this.spriteFrame.setImage(imageStates.get(imageState));
        }
        if (iVisitor.isUp()) {
            imageState = calcImageState(6);
            this.spriteFrame.setImage(imageStates.get(imageState));
        }
    }

    private void moveSprite(double x, double y) {
        spriteFrame.setTranslateX(x);
        spriteFrame.setTranslateY(y);
    }

    public void moveCenter() {
        iX = CENTER_X;
        iY = CENTER_Y;
        this.spriteFrame.setImage(imageStates.get(0));
        moveSprite(iX, iY);
    }

    private boolean isMoving() {
        return (iVisitor.isRight() ||
            iVisitor.isLeft() ||
            iVisitor.isUp() ||
            iVisitor.isDown());
    }

    private int calcImageState(int base_int) {
        int rtn = base_int;
        framecount += 1;
        if (framecount >= walkspeed) {
            framecount = 0;
            walkstate += 1;
            if (walkstate >= max_walk) {
                walkstate = 0;
            }
        }
        rtn += walkstate;
        return rtn;
    }

    @Override
    public boolean collide(Actor obj){
        return false;
    }

    public void animateLanding() {
        // animate the sprite moving from top center to actual middle.
        iX = CENTER_X;
        iY = BOTTOM_BOUNDARY;
        this.spriteFrame.setImage(imageStates.get(0));
        moveSprite(iX, iY);
        vY = vY * descendRate;
        isLanding = true;
    }
}