/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invincibagel;

import javafx.scene.image.Image;

/**
 *
 * @author courtney
 */
public class PropH extends Actor {

    public PropH(String SVGData, double xLoc, double yLoc, double xPivot, double yPivot, Image... spriteCels) {
        super(SVGData, xLoc, yLoc, xPivot, yPivot, spriteCels);
        spriteFrame.setTranslateX(xLoc);
        spriteFrame.setTranslateY(yLoc);
        this.setIsFlipH(true);
        spriteFrame.setScaleX(-1);
    }

    @Override
    public void update() {
    }
    
}
