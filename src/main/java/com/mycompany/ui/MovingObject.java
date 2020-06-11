/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ui;


import java.util.Random;

/**
 *
 * @author jnesis
 */
public abstract class MovingObject {
    
    private int x = 20;
    private int y = 20;
    private int shapeSize = randShapeSize(); //I don't think i should do this :/
    private String iD;


    /**
     * This method generates a random x value between 1-5. Noted that if it picks a 0 it will set it to a 1.
     * @return int of a random X value
     */
    public int getRandX(){
        Random rand = new Random();
        int upperBound = 5;
        int intXDirect = rand.nextInt(upperBound);
        if(intXDirect == 0){ //0 is bad.
            intXDirect =1;
        }
        return intXDirect;
    }

    public int getRandY(){
        Random rand = new Random();
        int upperBound = 5;
        int intYDirect = rand.nextInt(upperBound);
        if(intYDirect == 0){ //if the random number is 0, it will change it to 1 as zero would not allow it to move
            intYDirect =1;
        }
        return intYDirect;
    }

    public int randomSpeed(){
        Random rand = new Random();
        int upperBound = 150;
        int intSpeed = rand.nextInt(upperBound);
        if(intSpeed <= 25){ //if the random number is <25 it will change it to 26 so its not too slow
            intSpeed =26;
        }
        return intSpeed;
    }

    public int randShapeSize(){
        Random rand = new Random();
        int upperBound = 50;
        int intShape = rand.nextInt(upperBound);
        if(intShape <= 20){ //if the random number is <20 it will change it to 20 so its not too small
            intShape =21;
        }
        return shapeSize = intShape;
    }


    private int xDirection = 1;
    private int yDirection = 1;
    
    public void move(){
        x+=xDirection;
        y+=yDirection;
    }

    public int getXDirection() {
        return xDirection;
    }

    public void setXDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getYDirection() {
        return yDirection;
    }

    public void setYDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getShapeSize() {
        return shapeSize;
    }

    public void setShapeSize(int shapeSize) {
        this.shapeSize = shapeSize;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }
}
