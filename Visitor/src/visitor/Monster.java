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
public abstract class Monster extends MovingActor{
    
    public Monster(String SVGData, double xLoc, double yLoc, Image... spriteCels) {
        super(SVGData, xLoc, yLoc, spriteCels);
    }
    
}
