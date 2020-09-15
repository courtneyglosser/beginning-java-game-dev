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
public class PropV extends Actor {

    public PropV(String SVGData, double xLoc, double yLoc, double xPivot, double yPivot, Image... spriteCels) {
        super(SVGData, xLoc, yLoc, xPivot, yPivot, spriteCels);
        this.setIsFlipV(true);
        spriteFrame.setScaleY(-1);
        spriteFrame.setTranslateX(xLoc);
        spriteFrame.setTranslateY(yLoc);
    }

    @Override
    public void update() {
    }
    
}
