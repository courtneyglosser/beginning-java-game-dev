/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invincibagel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author courtney
 */
public abstract class Actor {
    protected List<Image> imageStates = new ArrayList<>();
    protected ImageView spriteFrame;
    protected SVGPath spriteBound;
    protected double iX;
    protected double iY;
    protected double pX;
    protected double pY;

    protected boolean isAlive;
    protected boolean isFixed;
    protected boolean isBonus;
    protected boolean hasValu;
    protected boolean isFlipV;
    protected boolean isFlipH;


    public Actor(String SVGData, double xLocation, double yLocation, Image... spriteCels) {
        spriteBound = new SVGPath();
        spriteBound.setContent(SVGData);
        spriteFrame = new ImageView(spriteCels[0]);
        imageStates.addAll(Arrays.asList(spriteCels));
        iX = xLocation;
        iY = yLocation;
        pX = 0;
        pY = 0;

        isAlive = false;
        isFixed = true;
        isBonus = false;
        hasValu = false;
        isFlipV = false;
        isFlipH = false;
    }

    public Actor(String SVGData, double xLoc, double yLoc, double xPivot, double yPivot, Image... spriteCels) {
        spriteBound = new SVGPath();
        spriteBound.setContent(SVGData);
        spriteFrame = new ImageView(spriteCels[0]);
        imageStates.addAll(Arrays.asList(spriteCels));
        iX = xLoc;
        iY = yLoc;
        pX = xPivot;
        pY = yPivot;

        isAlive = false;
        isFixed = true;
        isBonus = false;
        hasValu = false;
        isFlipV = false;
        isFlipH = false;
    }

    public abstract void update();


    public List<Image> getImageStates() {
        return imageStates;
    }

    public void setImageStates(List<Image> imageStates) {
        this.imageStates = imageStates;
    }

    public ImageView getSpriteFrame() {
        return spriteFrame;
    }

    public void setSpriteFrame(ImageView spriteFrame) {
        this.spriteFrame = spriteFrame;
    }

    public SVGPath getSpriteBound() {
        return spriteBound;
    }

    public void setSpriteBound(SVGPath spriteBound) {
        this.spriteBound = spriteBound;
    }

    public double getiX() {
        return iX;
    }

    public void setiX(double iX) {
        this.iX = iX;
    }

    public double getiY() {
        return iY;
    }

    public void setiY(double iY) {
        this.iY = iY;
    }

    public double getpX() {
        return pX;
    }

    public void setpX(double pX) {
        this.pX = pX;
    }

    public double getpY() {
        return pY;
    }

    public void setpY(double pY) {
        this.pY = pY;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setIsFixed(boolean isFixed) {
        this.isFixed = isFixed;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public void setIsBonus(boolean isBonus) {
        this.isBonus = isBonus;
    }

    public boolean hasValu() {
        return hasValu;
    }

    public void setHasValu(boolean hasValu) {
        this.hasValu = hasValu;
    }

    public boolean isFlipV() {
        return isFlipV;
    }

    public void setIsFlipV(boolean isFlipV) {
        this.isFlipV = isFlipV;
    }

    public boolean isFlipH() {
        return isFlipH;
    }

    public void setIsFlipH(boolean isFlipH) {
        this.isFlipH = isFlipH;
    }
}
