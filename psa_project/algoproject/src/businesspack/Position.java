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
public class Position {
    
    private double x;
    private double y;
    
    public Position(double x,double y){
     this.x=x;
     this.y=y;
    }

    public Position(){
        
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString(){
        
        return "("+this.x+" , "+this.y+")";
    }
    
    
}
