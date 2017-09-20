/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesspack;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author chand
 */
public class Particle {
    
    private Position position;
    private Velocity velocity;
    
    private Position bestPosition;
    
    private double fitness;
    
    private double bestFitness;
    
    
    public Particle(Position position,Velocity velocity){
        this.position=position;
        this.velocity=velocity;
        bestPosition=new Position();
    }
    
    public Particle(){
        
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }

    public Position getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(Position bestPosition) {
        this.bestPosition = bestPosition;
    }
    
    
    
    public void setBestFitnessValue()
    {
        if(fitness>bestFitness)
        {
            bestFitness=fitness;
            bestPosition=position;
        }
        
        
    }
    
   public void showUpdatedParticle(Graphics g,Color color,double previousX,double previousY,double latestX,double latestY){
    //   System.out.println("Changing graphics");
       
            g.setColor(color);
            g.fillOval(Math.round((int) latestX)/2, (int) Math.round(latestY)/2,15,15);
    //      System.out.println("("+latestX+","+latestY+")");
        //    g.setColor(Color.GREEN);
        //    g.drawLine(Math.round((int) latestX)*10, (int) Math.round(latestY)*10,Math.round((int) previousX)*10, (int) Math.round(previousY)*10);
   }
   
   public void showinitalizedParticle(Graphics g,double latestX,double latestY){
     //  System.out.println("Showing graphics");
       
       g.setColor(Color.YELLOW);
            g.fillOval(Math.round((int)latestX)/2,Math.round((int)latestY)/2,15,15);
            
            
   }
   public void showMineParticle(Graphics g,double latestX,double latestY){
     //  System.out.println("Showing Mine");
       System.out.println("Mine at : ("+latestX+","+latestY+")");
            g.setColor(Color.RED);
            g.fillOval(Math.round((int)latestX)/2,Math.round((int)latestY)/2,15,15);
            int radius=100;
            for(int i=400;i>10;i-=50)
            {
                g.setColor(Color.ORANGE);
                g.drawOval(i/2,i/2,radius,radius);
                radius=radius+100;
            }
            
            
            
   }
    
}
