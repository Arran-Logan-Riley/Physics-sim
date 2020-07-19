/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ui;

import com.mycompany.ui.movingShapes.Ball;
import com.mycompany.ui.movingShapes.Square;
import com.mycompany.ui.staticShapes.*;
import com.mycompany.ui.staticShapes.Scanner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 *This is main where the everything get initialized. This is where the UI is created and its properties are set.
 * @author jnesis
 */
public class FirstWindow {

    /**
     * This is a HasMap for storing all the threads in, this is so i can delete them later on
     * I dont think this should be done in FirstWindow.
     */
    //public static Map<String, Thread > threads = new HashMap<>();

        public final static int CANVAS_WIDTH=800;
        public final static int CANVAS_HEIGHT=800;
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame();

		window.setTitle("First Window");
                //Don't give a size to the window but to the content pane (see further)
		//window.setSize(400, 400);
		// Locate window content in the center
		window.setLocationRelativeTo(null);
		// Kill the Java process on click on the close (X) icon
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CustomPanel panel = new CustomPanel();
		window.setContentPane(panel);
                //------BUTTONS-------
		        //Inint button
                JButton buttonAddBall=new JButton("ADD BALL");
                JButton buttonAddSquare=new JButton("ADD SQUARE");
                JButton buttonExit= new JButton("EXIT");
                //setting the bounds of the buttons
                buttonAddBall.setBounds(680,10,115,30);
                buttonAddSquare.setBounds(680,45,115,30);
                buttonExit.setBounds(680,80,115,30);
                //changing the color to white
                buttonAddBall.setBackground(Color.WHITE);
                buttonAddSquare.setBackground(Color.WHITE);
                buttonExit.setBackground(Color.WHITE);
                //getting rid of the jButton text highlight
                buttonAddSquare.setFocusPainted(false);
                buttonAddBall.setFocusPainted(false);
                buttonExit.setFocusPainted(false);
                //adding the buttons to the windows
                window.add(buttonAddBall);
                window.add(buttonAddSquare);
                window.add(buttonExit);
                //setting the window properties
                window.setSize(400,400);
                window.setLayout(null);
                window.setVisible(true);

                //---------------ADD A BALL-----------------------
                buttonAddBall.addActionListener(new ActionListener() {
                    /**
                     * when the actionPerformed method is called it will create a new instance of a ball
                     * @param e action
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Ball ball=new Ball();
                        ball.setColor(Color.CYAN);
                        ball.setX(50);
                        ball.setY(100);
                        ball.setXDirection(ball.getRandX());
                        ball.setYDirection(ball.getRandY());
                        ball.setH(ball.getShapeSize());
                        ball.setW(ball.getShapeSize());

                        panel.addBall(ball);
                        CollisionManager.addCollidable(ball);
                        MovingObjectAnimator mBall=new MovingObjectAnimator(ball);
                        mBall.setMovePerSec(ball.randomSpeed());
                        Thread thread=new Thread(mBall);
                        ball.setiD(CustomPanel.getBalls().size() + "-ball");
                        thread.start();
                        //threads.put(ball.getiD(),thread);
                    }
                });
                //---------------ADD A SQUARE-----------------------
                buttonAddSquare.addActionListener(new ActionListener(){
                    /**
                     * when the add square action listiner is called it will run the actionPerferformed method that will add
                     * a new instance of square to the simulation.
                     * @param e action
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Square square=new Square();
                        square.setColor(Color.GREEN);
                        square.setX(50);
                        square.setY(150);
                        square.setXDirection(square.getRandX());
                        square.setYDirection(square.getRandY());
                        square.setH(square.getShapeSize());
                        square.setW(square.getShapeSize());


                        panel.addSquare(square);
                        CollisionManager.addCollidable(square);
                        MovingObjectAnimator mSquare=new MovingObjectAnimator(square);
                        mSquare.setMovePerSec(square.randomSpeed());
                        Thread thread=new Thread(mSquare);
                        thread.start();
                        square.setiD(CustomPanel.getSquares().size() + "-square");
                        //threads.put(square.getiD(),thread);
                    }
                });

                //-----------EXIT THE APPLICATION BUTTON-------------
                buttonExit.addActionListener(new ActionListener() {
                    /**
                     * when this method is called it will close the application
                     * @param e action
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       window.dispose();
                    }
                });

                //---------MOVING OBJECTS-------
                Ball blueBall=new Ball();
                blueBall.setColor(Color.CYAN);
                blueBall.setX(50);
                blueBall.setY(100);
                blueBall.setXDirection(blueBall.getRandX());
                blueBall.setYDirection(blueBall.getRandY());
                blueBall.setH(40);
                blueBall.setW(40);

                
                Square square2=new Square();
                square2.setColor(Color.GREEN);
                square2.setX(50);
                square2.setY(150);
                square2.setXDirection(square2.getRandX());
                square2.setYDirection(square2.getRandY());
                square2.setH(50);
                square2.setW(50);


                //------------------SCANNER-----------------
                //X comes first in the array>
                PolyGon scannerTop1= new PolyGon(350, 201,new int[]{0,-30,80,50},new int[]{20,50,50,20},Color.white);
                PolyGon scannerBottom1 = new PolyGon(350, 301,new int[]{0,-30,80,50},new int[]{50,20,20,50},Color.white);
                Scanner scannerMiddle1 = new com.mycompany.ui.staticShapes.Scanner( 350, 241,new int[]{0,0,50,50},new int[]{10,80,80,10},Color.white);


               PolyGon trapScannterTop2=new PolyGon(480, 400,new int[]{0,-30,80,50},new int[]{20,50,50,20},Color.white);
               PolyGon trapScannterBottom2=new PolyGon(480, 500,new int[]{0,-30,80,50},new int[]{50,20,20,50},Color.white);
               TrapDoorScanner trapScanner2 = new TrapDoorScanner(480, 439,new int[]{0,0,50,50},new int[]{10,82,82,10},Color.white);

                //------------------CONVEYOR----------------- Left/Right/Up/Down
                Convayor convayor1 = new Convayor(0, 300,new int[]{-30,-30,300,300},new int[]{20,40,40,20},Color.white,"Right");
                Convayor convayor2 = new Convayor(450, 200,new int[]{280,280,300,300},new int[]{20,320,320,20},Color.white,"Down");
                Convayor convayor3 = new Convayor(650, 500,new int[]{-30,-30,100,100},new int[]{20,40,40,20},Color.white,"Left");

                //------------------CRUSHER-----------------
                PolyGon crusherTop = new PolyGon(480, 202,new int[]{0,-30,80,50},new int[]{20,50,50,20},Color.white);
                PolyGon crusherBottom = new PolyGon(480, 304,new int[]{0,-30,80,50},new int[]{50,20,20,50},Color.white);
                Crusher crusherMiddle = new Crusher(480, 242,new int[]{0,0,50,50},new int[]{10,82,82,10},Color.white);

                //------------------TRAPDOOR-----------------
                TrapDoor trapDoor1 = new TrapDoor(70, 480,new int[]{280,280,300,300},new int[]{0,100,100,0},Color.white,"Down");

                //------------------DISPOSALAREA-----------------
                DisposalArea disposalArea1= new DisposalArea(-150, 480,new int[]{280,280,300,300},new int[]{0,100,100,0},Color.white);
                DisposalArea disposalArea2= new DisposalArea(170, 700,new int[]{100,100,300,300},new int[]{0,30,30,0},Color.white);

                //------------------BOUNDRY----------------- this is put above the first scanner to stop the moving objects going where they are not supposed to
                PolyGon boundry = new PolyGon(70, -100,new int[]{280,280,300,300},new int[]{-30,321,321,-30},Color.white);


                panel.setBackground(Color.GRAY);
                //adding the objects to the panel
                panel.addBall(blueBall);
                panel.addSquare(square2);

                panel.addPolyGon(scannerTop1);
                panel.addPolyGon(scannerBottom1);
                panel.addScanner(scannerMiddle1);

                panel.addPolyGon(trapScannterTop2);
                panel.addPolyGon(trapScannterBottom2);
                panel.addTrapScanner(trapScanner2);

                panel.addPolyGon(crusherTop);
                panel.addPolyGon(crusherBottom);
                panel.addCrusher(crusherMiddle);

                panel.addConvayor(convayor1);
                panel.addConvayor(convayor2);
                panel.addConvayor(convayor3);

                panel.addTrapDoor(trapDoor1);

                panel.addDisposalArea(disposalArea1);
                panel.addDisposalArea(disposalArea2);

                panel.addPolyGon(boundry);


                //A window has insets (borders and title bar). To give a size to the panel
                //where we draw (so we can make sure we know the size) use setPreferedSize.
                panel.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

                //adding the objects to the collision manager
                CollisionManager.height=CANVAS_HEIGHT;
                CollisionManager.width=CANVAS_WIDTH;
                CollisionManager.addCollidable(blueBall);
                CollisionManager.addCollidable(square2);

                CollisionManager.addCollidable(scannerTop1);
                CollisionManager.addCollidable(scannerBottom1);
                CollisionManager.addCollidable(scannerMiddle1);

                CollisionManager.addCollidable(trapScannterTop2);
                CollisionManager.addCollidable(trapScannterBottom2);
                CollisionManager.addCollidable(trapScanner2);

                CollisionManager.addCollidable(convayor1);
                CollisionManager.addCollidable(convayor2);
                CollisionManager.addCollidable(convayor3);

                CollisionManager.addCollidable(crusherTop);
                CollisionManager.addCollidable(crusherBottom);
                CollisionManager.addCollidable(crusherMiddle);

                CollisionManager.addCollidable(trapDoor1);

                CollisionManager.addCollidable(disposalArea1);
                CollisionManager.addCollidable(disposalArea2);

                CollisionManager.addCollidable(boundry);


                //calculate the window size base on its content
                window.pack();
                //Show the window
		        window.setVisible(true);
		        window.setResizable(false);
                //only mOVABLE OBJECTS NEED THEIR OWN THREADS
                MovingObjectAnimator mBall1=new MovingObjectAnimator(blueBall);
                mBall1.setMovePerSec(blueBall.randomSpeed());
                MovingObjectAnimator mSquar2=new MovingObjectAnimator(square2);
                mSquar2.setMovePerSec(square2.randomSpeed());
                Thread thread1=new Thread(mBall1);
                thread1.start();
                Thread thread4=new Thread(mSquar2);
                thread4.start();


        while (true){
                    
                    panel.repaint();
                    try {
                        //frame rate, refresh screen every 35ms
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        System.out.println("Something interrupted me while sleeping...");
                    }
                }
                
	}

}

