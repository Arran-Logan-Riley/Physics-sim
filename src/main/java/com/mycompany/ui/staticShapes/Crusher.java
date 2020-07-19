package com.mycompany.ui.staticShapes;

import com.mycompany.ui.*;
import com.mycompany.ui.movingShapes.Ball;
import com.mycompany.ui.movingShapes.Square;

import java.awt.*;

/**
 * The crusher will turn any object with the property crushable==true to the color magenta
 * This crusable status is set by scanner1.
 */
public class Crusher extends PolyGon implements Collidable {

    public Crusher(int x, int y, int[] xPoints, int[] yPoints, Color color) {
        super(x, y, xPoints, yPoints, color);
    }

    /**
     * This method will turn the object color that has hit it to magenta if it is crushable
     * @param collisionEvent eventsouce passed in
     */
    @Override
    public void handleCollision(CollisionEvent collisionEvent) {
        Collidable eventSource = (Collidable) collisionEvent.getSource();
        if(eventSource instanceof Square ||eventSource instanceof Ball){
            ((MovingObject) eventSource).setX(530);

            if(eventSource instanceof Square){
               // if(eventSource.get)
                if(((Square) eventSource).getCrushable() == true){
                    ((Square) eventSource).setColor(Color.MAGENTA);
                    this.color = ((Square) eventSource).getColor();
            }
            }else if(eventSource instanceof Ball){
                this.color = ((Ball) eventSource).getColor();
            }
        }
    }
}
