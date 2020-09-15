
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import javafx.scene.image.Image;

import static visitor.Visitor.GAME_RIGHT_BOUNDARY;
import static visitor.Visitor.GAME_LEFT_BOUNDARY;
import static visitor.Visitor.GAME_TOP_BOUNDARY;
import static visitor.Visitor.GAME_BOTTOM_BOUNDARY;

/**
 *
 * @author courtney
 */
public abstract class MovingActor extends Actor {
    protected static final double SPRITE_PIXELS_X = 32;
    protected static final double SPRITE_PIXELS_Y = 32;

    protected static final double RIGHT_BOUNDARY = GAME_RIGHT_BOUNDARY - SPRITE_PIXELS_X/2;
    protected static final double LEFT_BOUNDARY = GAME_LEFT_BOUNDARY + SPRITE_PIXELS_X/2;
    protected static final double TOP_BOUNDARY = GAME_TOP_BOUNDARY - SPRITE_PIXELS_Y/2;
    protected static final double BOTTOM_BOUNDARY = GAME_BOTTOM_BOUNDARY + SPRITE_PIXELS_Y/2;

    protected static final double CENTER_X = (RIGHT_BOUNDARY + LEFT_BOUNDARY) / 2;
    protected static final double CENTER_Y = (TOP_BOUNDARY + BOTTOM_BOUNDARY) / 2;

    protected int framecount = 0;
    protected int walkstate = 0;
    protected int walkspeed = 8;
    protected int max_walk = 3;

    protected double vX;
    protected double vY;
    protected double lifeSpan;
    protected double damage;
    protected double offsetX;
    protected double offsetY;
    protected float boundScale;
    protected float boundRot;
    protected float friction;
    protected float gravity;
    protected float bounce;
    
    public MovingActor(String SVGData, double xLoc, double yLoc, Image... spriteCels){
        super (SVGData, xLoc, yLoc, spriteCels);
        
        lifeSpan = 1000;
        vX = vY = 1;
        damage = offsetX = offsetY = 0;
        boundScale = boundRot = friction = gravity = bounce = 0;
    }

    @Override
    public abstract void update();

    public boolean collide(Actor obj){
        return false;
    }



    public double getvX() {
        return vX;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public double getvY() {
        return vY;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }

    public double getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(double lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    public float getBoundScale() {
        return boundScale;
    }

    public void setBoundScale(float boundScale) {
        this.boundScale = boundScale;
    }

    public float getBoundRot() {
        return boundRot;
    }

    public void setBoundRot(float boundRot) {
        this.boundRot = boundRot;
    }

    public float getFriction() {
        return friction;
    }

    public void setFriction(float friction) {
        this.friction = friction;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getBounce() {
        return bounce;
    }

    public void setBounce(float bounce) {
        this.bounce = bounce;
    }
}