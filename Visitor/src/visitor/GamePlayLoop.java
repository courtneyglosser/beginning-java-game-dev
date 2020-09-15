/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;

/**
 *
 * @author courtney
 */
public class GamePlayLoop extends AnimationTimer{
    private int gametime = 0;
    private Pos location;
    protected Visitor visitor;

    public GamePlayLoop(Visitor visitor){
        this.visitor = visitor;
    }

    @Override
    public void handle(long now) {
        gametime++;
        visitor.iDeity.update();
        //Unsupported, yet.
    }

    @Override
    public void start() {
        System.out.println("Game Time (Starting):  ");
        System.out.println(this.getGametime());
        super.start();
    }
    
    @Override
    public void stop() {
        System.out.println("Game Time (Stopping):  ");
        System.out.println(this.getGametime());
        super.stop();
    }

    public int getGametime() {
        return gametime;
    }
    
}