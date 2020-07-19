package com.mycompany.ui.staticShapes;

import com.mycompany.ui.Collidable;
import com.mycompany.ui.CollisionEvent;
import com.mycompany.ui.MovingObject;
import com.mycompany.ui.movingShapes.Square;

import java.awt.*;


/**
 * The trapdoor class extends polygon as it is a static shape and it is a collidable
 * When scanned square (scanned by the trapdoor scanner) has a trapdoor status of true it will allow the
 * square to pass through, instead of going down the conveyor as it is technically a conveyor.
 */
public class TrapDoor extends Convayor implements Collidable {

    public TrapDoor(int x, int y, int[] xPoints, int[] yPoints,Color color, String direction ) {
        super(x, y, xPoints, yPoints,color, direction);
    }

    /**
     * This method detects the instance of the evensource and will behave differently depending on what is passed into it
     *
     * @param collisionEvent eventsource
     */
    @Override
    public void handleCollision(CollisionEvent collisionEvent) {
        Collidable eventSource = (Collidable) collisionEvent.getSource();
        if(eventSource instanceof Square && ((Square) eventSource).getTrapDoorStatus()){
            ((Square) eventSource).setX(300);
        }else if(eventSource instanceof MovingObject){ //if not a magenta square it is send downwards
            ((MovingObject) eventSource).setYDirection(1);
            ((MovingObject) eventSource).setXDirection(0);
        }
    }
}
