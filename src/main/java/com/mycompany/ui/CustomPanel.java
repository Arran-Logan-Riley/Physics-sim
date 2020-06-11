/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *Custom panel is where all the lists of everything that is on the panel is stored.
 * this is so they are in an easy to access place.
 * @author jnesis
 */
public class CustomPanel extends JPanel
{
    private static int i = 0;
    private static List<Ball> balls=new ArrayList<>(); //list of balls
    private static List<PolyGon> polyGons=new ArrayList<>();  //list of polygons
    private static List<Scanner> scanners=new ArrayList<>();
    private static List<Convayor> convayors=new ArrayList<>();
    private static List<Square> squares = new ArrayList<>();
    private static List<Crusher> crushers = new ArrayList<>();
    private static List<TrapDoorScanner> trapDoorScanners = new ArrayList<>();
    private static List<TrapDoor> trapDoors = new ArrayList<>();
    private static List<DisposalArea> disposalAreas = new ArrayList<>();

    /**
     * This method paints all the objects that are in the lists.
     * @param g Graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball: balls){
            ball.paintBall(g);
        }
        for (Square square:squares){
            square.paintSquare(g);
        }
        for (PolyGon polyGon: polyGons){
            polyGon.paintPolygon(g);
        }
        for (Scanner scanner: scanners){
            scanner.paintPolygon(g);
        }
        for (TrapDoorScanner trapDoorScanner:trapDoorScanners){
            trapDoorScanner.paintPolygon(g);
        }
        for (TrapDoor trapDoor: trapDoors){
            trapDoor.paintPolygon(g);
        }
        for (Crusher crusher: crushers){
            crusher.paintPolygon(g);
        }
        for (Convayor convayor:convayors){
            convayor.paintPolygon(g);
        }
        for(DisposalArea disposalArea:disposalAreas){
            disposalArea.paintPolygon(g);
        }
    }

    //------ADD METHODS---------//
    /*the methods below are all the add methods to add objects to their lists.
    These will be called in firstwindow */
    public void addBall(Ball ball) {
       balls.add(ball);
    }

    public void addPolyGon(PolyGon polyGon){ //adding the polygon to the list of polygons
        polyGons.add(polyGon);
    }

    public void addScanner(Scanner scanner){
        scanners.add(scanner);
    }

    public void addConvayor(Convayor convayor){
        convayors.add(convayor);
    }

    public void addSquare(Square square){
        squares.add(square);
    }

    public void addCrusher(Crusher crusher){
        crushers.add(crusher);
    }
    public void addTrapScanner(TrapDoorScanner trapDoorScanner){
        trapDoorScanners.add(trapDoorScanner);
    }
    public void addTrapDoor(TrapDoor trapDoor){
        trapDoors.add(trapDoor);
    }
    public void addDisposalArea(DisposalArea disposalArea){
        disposalAreas.add(disposalArea);
    }
//------------------------------------------------------//

    /**
     * This method removes any shape that is passed into it. currently there is an error and it does not work.
     * This method is called in the disposal area class to remove the object that is passes in.
     * depending on if its a square or a ball it will behave differently.
     * @param shape passed in shape
     */
    public static void removeShape(MovingObject shape){
        if(shape instanceof Square){
            for (Square squaresA: squares
                 ) {
                if(squaresA == shape){
                    if(FirstWindow.threads.containsKey(shape.getiD())) {
                        FirstWindow.threads.get(shape.getiD()).interrupt();
                        FirstWindow.threads.remove(shape.getiD());
                        CollisionManager.removeCollidable((Collidable) shape);
                        squares.remove(shape);
                    }
                }
            }
        }else if(shape instanceof Ball){
            for (Ball ballsA: balls
                 ) {
                if(ballsA == shape){
                    if(FirstWindow.threads.containsKey(shape.getiD())) {
                        FirstWindow.threads.get(shape.getiD()).interrupt();
                        FirstWindow.threads.remove(shape.getiD());
                        CollisionManager.removeCollidable((Collidable) shape);
                        System.out.println(shape.getiD());
                        balls.remove(shape);
                    }
                }
            }
        }
    }

    public static List<Ball> getBalls() {
        return balls;
    }

    public static void setBalls(List<Ball> balls) {
        CustomPanel.balls = balls;
    }

    public static List<Square> getSquares() {
        return squares;
    }

    public static void setSquares(List<Square> squares) {
        CustomPanel.squares = squares;
    }
}
