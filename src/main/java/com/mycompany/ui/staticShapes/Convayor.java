package com.mycompany.ui.staticShapes;

import com.mycompany.ui.*;
import com.mycompany.ui.movingShapes.Ball;
import com.mycompany.ui.movingShapes.Square;

import java.awt.*;

/**
 * The conveyor moves objects that hit it depending on what is set by in firstwindow determines what direction the conveyor
 * will go.
 */
public class Convayor extends PolyGon implements Collidable {
    private String direction;

    public Convayor(int x, int y, int[] xPoints, int[] yPoints, Color color, String direction) {
        super(x, y, xPoints, yPoints,color);
        this.direction = direction;
    }


    /**
     * this method sets the direction of any item that hits it to a direction that is specified in firstwindow
     * @param collisionEvent eventsource
     */
    @Override
    public void handleCollision(CollisionEvent collisionEvent) {
        Collidable eventSource = (Collidable) collisionEvent.getSource();
        if(eventSource instanceof Ball || eventSource instanceof Square){
            if(getDirection().equals("Right")){               //convay left
                ((MovingObject) eventSource).setYDirection(0);
                ((MovingObject) eventSource).setXDirection(1);
            }else if(getDirection().equals("Left")){   //convay right
                ((MovingObject) eventSource).setXDirection(-1);
                ((MovingObject) eventSource).setYDirection(0);
                //move the ball to the right
            }else if(getDirection().equals("Up")){     //convay down
                ((MovingObject) eventSource).setXDirection(0);
                ((MovingObject) eventSource).setYDirection(-1);
            }else if(getDirection().equals("Down")){        //convay down
                ((MovingObject) eventSource).setXDirection(0);
                ((MovingObject) eventSource).setYDirection(1);
            }
        }
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


}
