package com.mycompany.ui.staticShapes;

import com.mycompany.ui.Collidable;
import com.mycompany.ui.CollisionEvent;

import java.awt.*;
import java.util.Arrays;

/**
 * The polygon class is what all static objects in my simulation are made of The special functionality of this class
 * is that it can dynamically draw a boundary box just from the coordinates specified from FirstWindow.
 */
public class PolyGon implements Collidable {

    public Color color;

     private int[] xPoints;
     private int[] yPoints;
     private int nPoints;
    private Color colorOfObj;

     private Rectangle bounds;

    /**
     * This method paints the debugging boundary
     * @param g the graphics variable
     */
    public void paintPolygon(Graphics g){
        g.setColor(color);
        g.fillPolygon(getxPoints(),getyPoints(),getnPoints());
        //this code below colours in the bounding box v
        //g.setColor(new Color(1, 0, 0, 0.2f));
        g.fillRect(getBounds().x,getBounds().y, getBounds().width, getBounds().height);
    }

    //int x and y are internal values that are defined here
    /**
     * This constructor deals with the boundary box needing to be set relative to the x and y cords set in firstwindow
     *
     * @param x coordinates
     * @param y coordinates
     * @param xPoints array
     * @param yPoints array
     * @param colorOfObj color
     */
    public PolyGon(int x, int y, int[] xPoints, int[] yPoints, Color colorOfObj) {
        //when the points are moved relavtivly this also moves the bounds box so we have to save it as its own rectangle before
        //this takes the max value and takes the minimum value away so it can calculate the bounding box correctly.
        int width = Arrays.stream(xPoints).max().getAsInt()-Arrays.stream(xPoints).min().getAsInt();
        int height = Arrays.stream(yPoints).max().getAsInt()-Arrays.stream(yPoints).min().getAsInt();
        //these for loops change it so the xPoints are now relative to the x and y point that is set.
        for (int i = 0; i < xPoints.length; i++) {
            xPoints[i] = xPoints[i] + x;
        }
        for (int i = 0; i < yPoints.length; i++) {
            yPoints[i] = yPoints[i] + y;
        }
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = xPoints.length;

        //create a boundary rectangle to return below.
        this.bounds = new Rectangle(
                Arrays.stream(xPoints).min().getAsInt(),
                Arrays.stream(yPoints).min().getAsInt(),
                width,
                height);

        this.colorOfObj = colorOfObj;
        paintColor();
    }

    /**
     * paints the polygon a specified color
     */
    public void paintColor(){
        this.color = colorOfObj;
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * This method handles collisions from Collision handler
     * @param collisionEvent
     */
    @Override
    public void handleCollision(CollisionEvent collisionEvent) {

    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int[] getxPoints() {
        return xPoints;
    }

    public void setxPoints(int[] xPoints) {
        this.xPoints = xPoints;
    }

    public int[] getyPoints() {
        return yPoints;
    }

    public void setyPoints(int[] yPoints) {
        this.yPoints = yPoints;
    }


    public int getnPoints() {
        return nPoints;
    }

    public void setnPoints(int nPoints) {
        this.nPoints = nPoints;
    }
}
