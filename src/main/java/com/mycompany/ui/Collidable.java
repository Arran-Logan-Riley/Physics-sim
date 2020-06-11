/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ui;

import java.awt.Rectangle;

/**
 *
 * @author jnesis
 */
public interface Collidable {
    
    Rectangle getBounds();
    void handleCollision(CollisionEvent collisionEvent);
    
}
