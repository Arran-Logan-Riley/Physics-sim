package com.mycompany.ui.staticShapes;

import com.mycompany.ui.*;

import java.awt.*;

/**
 * The disposal extends of polygon so it behaves as a polygon The difference is if that any moving object hits it
 * it will destroy it.
 */
public class DisposalArea extends PolyGon implements Collidable {

    /**
     * @param x coordinates
     * @param y coordinates
     * @param xPoints array
     * @param yPoints array
     * @param color color of polygon
     */
    public DisposalArea(int x, int y, int[] xPoints, int[] yPoints, Color color) {
        super(x, y, xPoints, yPoints, color);
    }


    /**
     * This method handles removing objects by calling the removeShape from moving objects
     * @param collisionEvent The passed in eventsouce
     */
    @Override
    public void handleCollision(CollisionEvent collisionEvent) {
        Collidable eventSource = (Collidable) collisionEvent.getSource();
        if(eventSource instanceof MovingObject){
            //CustomPanel.removeShape((MovingObject) eventSource); //cast it to movable so it can be used in custom panel
            //this method was super cool, but it didn't work :(
        }
    }
}
