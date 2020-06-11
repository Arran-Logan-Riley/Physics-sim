package com.mycompany.ui;

import java.awt.*;

/**
 * The scanner is a polygon with special properties. It is Collidable and will set crushable to true if a blue square hits it.
 * It will require two lists of ints to create its outline.
 */
public class Scanner extends PolyGon implements Collidable{


    /**
     * These two methods are used for debugging
     */
    private Color eventSourceColor;
    private String colorStoreage;

    /**
     * this constructor constructs the scanner so these variables can be defined in Firstwindow
     * @param x coordinate
     * @param y coordinate
     * @param xPoints array for the drawing of the polygon
     * @param yPoints array for the drawing of the polygon
     * @param color for the color of the polygon
     */
    public Scanner(int x, int y, int[] xPoints, int[] yPoints, Color color) {
        super(x, y, xPoints, yPoints, color);
    }


    /**
     * If it is an instance of ball it will just teleport the ball to the other side with no major interaction.
     * this is the same for the square, unless it is a blue square then it changes the blue
     * square property of crushable to true. This will be checked by the scanner.
     * @param collisionEvent is the parameter used to identify what the eventsource is.
     */
    @Override
    public void handleCollision(CollisionEvent collisionEvent) {
        Collidable eventSource = (Collidable) collisionEvent.getSource();
            if (eventSource instanceof Ball) {
                this.color = ((Ball) eventSource).getColor(); //what the scanner does when it gets hit
                eventSourceColor = ((Ball) eventSource).getColor();
                ((Ball) eventSource).setX(400);

                /*colorStoreage = idenTifyColor(eventSourceColor);
                System.out.println(colorStoreage);*/

                //if square and blue then set the crushable to true in the square call. This will be checked by the crusher.
            }else if(eventSource instanceof Square){
                ((Square) eventSource).setX(400);
                this.color = ((Square) eventSource).getColor();
                if(((Square) eventSource).getColor() == Color.BLUE){
                    ((Square) eventSource).setCrushable(true);
                }
            }
        }

    /**
     * This method is used for debugging, but is currently not in use.
     * @param color of shape
     * @return color of shape
     */
    public String idenTifyColor(Color color){
        if(color == Color.BLUE){
            return "B";
        }else if(color == Color.CYAN){
            return "C";
        }else if(color == Color.GREEN){
            return "G";
        }
        return null;
    }

}
