package com.mycompany.ui;

import java.awt.*;

/**
 * The square is a class that is a moving and collidable object. This class is similar to the ball class
 * although it has extra properties like crushable and trapdoorStatus
 */
public class Square extends MovingObject implements Collidable{

    private int w= 10;
    private int h =10;
    private boolean crushable;      //if this is true it can be crushed
    private boolean trapDoorStatus; //if this is true it will be let through the trap door

    public Color color;

    public void paintSquare(Graphics g) {
        g.setColor(color);
        g.fillRect(getX(), getY(), w, h);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), w, h);
    }

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
            if (eventSource instanceof MovingObject) {
                //it is a moving object
                //MovingObject movingObject=(MovingObject)eventSource;
                //movingObject specifics
                if (eventSource instanceof Ball) {
                    //it is a Ball
                    //Ball ball=(Ball)eventSource;
                    //Ball specifics
                    if(!this.getCrushable()){
                        this.color = Color.blue; //((Ball) eventSource).getColor() (in order to acess the other balls properties
                    }

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

    public boolean getCrushable() {
        return crushable;
    }

    public void setCrushable(boolean crushable) {
        this.crushable = crushable;
    }

    public boolean getTrapDoorStatus() {
        return trapDoorStatus;
    }

    public void setTrapDoorStatus(boolean trapDoorStatus) {
        this.trapDoorStatus = trapDoorStatus;
    }
}

