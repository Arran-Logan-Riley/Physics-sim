/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ui.movingShapes;

import com.mycompany.ui.Collidable;
import com.mycompany.ui.CollisionEvent;
import com.mycompany.ui.CollisionManager;
import com.mycompany.ui.MovingObject;
import com.mycompany.ui.staticShapes.DisposalArea;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *This is the ball class THe ball is a moving object and it is collidable.
 * @author jnesis
 */
public class Ball extends MovingObject implements Collidable {

    /**
     * The width of the shape
     */
    private int w = 10;
    /**
     * The height of the shape
     */
    private int h = 10;


    public Color color;

    public void paintBall(Graphics g) {
        g.setColor(color);
        g.fillOval(getX(), getY(), w, h);
    }

    /**
     * @return returns a rectangle with a X and A Y that comes from moving object it also comes with a height and width
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), w, h);
    }

    /**
     * Move method that comes from the movable class
     */
    @Override
    public void move() {
        super.move();
        CollisionManager.handleCollisions(this);
    }

    @Override
    public void handleCollision(CollisionEvent collisionEvent) {
        if (collisionEvent.getSource().equals(CollisionEvent.WALLSEVENTSOURCE)) {
            //it the the wall
            //wall specifics
        } else {
            //the collisionEvent source is the other object
            Collidable eventSource = (Collidable) collisionEvent.getSource();
            //Collifable specifics
            //and possibly a movingobject
            if(eventSource instanceof DisposalArea){
                this.w = 0;
                this.h = 0;
                Thread.currentThread().interrupt();
            }
            if (eventSource instanceof MovingObject) {
                //it is a moving object
                //MovingObject movingObject=(MovingObject)eventSource;
                //movingObject specifics
                if (eventSource instanceof Ball) {
                    //it is a Ball
                    //Ball ball=(Ball)eventSource;
                    //Ball specifics
                    this.color = Color.blue; //((Ball) eventSource).getColor() (in order to acess the other balls properties
                }
            }
        }
        //bounce affect 
        switch (collisionEvent.getImpact()) {
            case "left":
                if (getXDirection()<0) setXDirection(-getXDirection());
                break;
            case "right":
                if (getXDirection()>0) setXDirection(-getXDirection());
                break;
            case "top":
                if (getYDirection()<0) setYDirection(-getYDirection());
                break;
            case "bottom":
                if (getYDirection()>0) setYDirection(-getYDirection());
        }

    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
