package com.mycompany.ui.staticShapes;

import com.mycompany.ui.*;
import com.mycompany.ui.movingShapes.Ball;
import com.mycompany.ui.movingShapes.Square;

import java.awt.*;

/**
 * The trap door scanner scans for magenta squares and if it finds one it will set its trapdoor status to true
 * The trap door will read this status This class extends polygon as it is a static shape and it is also a collidable
 */
public class TrapDoorScanner extends PolyGon implements Collidable {

    public TrapDoorScanner(int x, int y, int[] xPoints, int[] yPoints, Color color) {
        super(x, y, xPoints, yPoints, color);
    }

    /**
     * This method detects the instance of either ball or square
     * depending on its properties(color and instance)
     * it will behave differently
     * @param collisionEvent eventsource
     */
    @Override
    public void handleCollision(CollisionEvent collisionEvent) {
        Collidable eventSource = (Collidable) collisionEvent.getSource();
        if(eventSource instanceof Square || eventSource instanceof Ball){
            //teleport shape through the boundary
            ((MovingObject) eventSource).setX(430);
            if(eventSource instanceof Square && ((Square) eventSource).getColor() == Color.MAGENTA){ //
                ((Square) eventSource).setTrapDoorStatus(true);
                /*this makes it so the trap door ignores this object. This is because trap door will be set to ignore if-
                trap door status is false*/
                this.color = ((Square) eventSource).getColor();
            }else if(eventSource instanceof Ball){
                this.color = ((Ball) eventSource).getColor();
            }else if(eventSource instanceof Square){
                this.color = ((Square) eventSource).getColor();
            }
        }
    }
}
