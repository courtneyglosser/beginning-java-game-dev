/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invincibagel;

import javafx.scene.image.Image;

import static invincibagel.InvinciBagel.WIDTH;
import static invincibagel.InvinciBagel.HEIGHT;

/**
 *
 * @author courtney
 */
public class Bagel extends Hero {
    protected InvinciBagel invinciBagel;

    private static final double SPRITE_PIXELS_X = 81;
    private static final double SPRITE_PIXELS_Y = 81;

    private static final double RIGHT_BOUNDARY = WIDTH/2 - SPRITE_PIXELS_X/2;
    private static final double LEFT_BOUNDARY = -(WIDTH/2 - SPRITE_PIXELS_X/2);
    private static final double BOTTOM_BOUNDARY = HEIGHT/2 - SPRITE_PIXELS_Y/2;
    private static final double TOP_BOUNDARY = -(HEIGHT/2 - SPRITE_PIXELS_Y/2);

    boolean animator = false;
    int framecounter = 0;
    int runningspeed = 6;

    public Bagel(InvinciBagel iBagel, String SVGData, double xLocation, double yLocation, Image... spriteCels) {
        super (SVGData, xLocation, yLocation, spriteCels);
        this.invinciBagel = iBagel;
    }

    @Override
    public void update() {
        setXYLocation();
        setBoundaries();
        setImageState();
        moveInvinciBagel(iX, iY);
        playAudioClip();
    }

    private void setXYLocation() {
        if (invinciBagel.isRight()) { iX += vX; }
        if (invinciBagel.isLeft()) { iX -= vX; }
        if (invinciBagel.isDown()) { iY += vY; }
        if (invinciBagel.isUp()) { iY -= vY; }
    }

    private void setBoundaries() {
        if (iX >= RIGHT_BOUNDARY) { iX = RIGHT_BOUNDARY; }
        if (iX <= LEFT_BOUNDARY) { iX = LEFT_BOUNDARY; }
        if (iY >= BOTTOM_BOUNDARY) { iY = BOTTOM_BOUNDARY; }
        if (iY <= TOP_BOUNDARY) { iY = TOP_BOUNDARY; }
    }

    private void setImageState() {
        if (isWaiting()) {
            spriteFrame.setImage(imageStates.get(0));
            animator=false;
            framecounter=0;
        }
        if (invinciBagel.isRight()) {
            if (!animator) {
                spriteFrame.setImage(imageStates.get(1));
                if (framecounter >= runningspeed) {
                    framecounter=0;
                    animator=true;
                }
                else {
                    framecounter += 1;
                }
            }
            else if (animator) {
                spriteFrame.setImage(imageStates.get(2));
                if (framecounter >= runningspeed) {
                    framecounter=0;
                    animator=false;
                }
                else {
                    framecounter += 1;
                }
            }
            spriteFrame.setScaleX(1);
            this.setIsFlipH(false);
        }
        if (invinciBagel.isLeft()) {
            if (!animator) {
                spriteFrame.setImage(imageStates.get(1));
                if (framecounter >= runningspeed) {
                    framecounter=0;
                    animator=true;
                }
                else {
                    framecounter += 1;
                }
            }
            else if (animator) {
                spriteFrame.setImage(imageStates.get(2));
                if (framecounter >= runningspeed) {
                    framecounter=0;
                    animator=false;
                }
                else {
                    framecounter += 1;
                }
            }
            spriteFrame.setScaleX(-1);
            this.setIsFlipH(true);
        }
        if (invinciBagel.isDown()) {
            spriteFrame.setImage(imageStates.get(6));
        }
        if (invinciBagel.isUp()) {
            spriteFrame.setImage(imageStates.get(4));
        }
        if (invinciBagel.iswKey()) {
            spriteFrame.setImage(imageStates.get(5));
        }
        if (invinciBagel.issKey()) {
            spriteFrame.setImage(imageStates.get(8));
        }
    }

    private void moveInvinciBagel(double x, double y) {
        spriteFrame.setTranslateX(x);
        spriteFrame.setTranslateY(y);
    }

    private void playAudioClip() {
        if(invinciBagel.isLeft())   { invinciBagel.playiSound0(); }
        if(invinciBagel.isRight())  { invinciBagel.playiSound1(); }
        if(invinciBagel.isUp())     { invinciBagel.playiSound2(); }
        if(invinciBagel.isDown())   { invinciBagel.playiSound3(); }
        if(invinciBagel.iswKey())   { invinciBagel.playiSound4(); }
        if(invinciBagel.issKey())   { invinciBagel.playiSound5(); }
    }

    @Override
    public boolean collide(Actor obj){
        return false;
    }

    private boolean isWaiting() {
        boolean rtn = false;
        if (!invinciBagel.isRight() &&
            !invinciBagel.isLeft() &&
            !invinciBagel.isUp() &&
            !invinciBagel.isDown()) {
            rtn = true;
        }
        return rtn;
    }
}
