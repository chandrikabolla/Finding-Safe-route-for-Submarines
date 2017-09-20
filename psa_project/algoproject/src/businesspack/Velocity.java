/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesspack;

/**
 *
 * @author chand
 */
public class Velocity {
    
    private double velocityX;
    private double velocityY;
    
    
    public Velocity(double x,double y)
    {
        this.velocityX=x;
        this.velocityY=y;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
    
    
}
