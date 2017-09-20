/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesspack;

import static interfacepack.DrawingArea.clearscreen;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author chand
 */
public class Swarm {
    
    private ArrayList<Particle> particles;
    private int numberOfParticles;
    
    private double[] fitnessValues;
    private double[] previousXValues;
    private double[] previousYValues;
    private double gBest;

    double longRangeMin=87.05;
        double longRangeMax=128.45;
        double latRangeMin=94.23;
        double latRangeMax=125.34;
        double QuarterPI=Math.PI/4.0;
        
        double velocityRangeMax=4.92;
        double velocityRangeMin=1.91;
        double depthRangeMax=50;
        double depthRangeMin=5;
    
    int i=1;
    int j=1;
    private Position gBestLocation;
    
    public Swarm(int numberOfParticles){
        this.numberOfParticles=numberOfParticles;
        fitnessValues=new double[numberOfParticles];
        previousXValues=new double[numberOfParticles];
        previousYValues=new double[numberOfParticles];
        particles=new ArrayList<Particle>();
        gBestLocation=new Position();
    }
    public Swarm(){
        particles=new ArrayList<Particle>();
        
    }
    
    //---------------------------------------------------------------------------------------//
        /* Evauluate the  the gbest for an iteration from the array of fitness values of all the 
        particles in the swarm, retrieved during that iteration */
    //---------------------------------------------------------------------------------------//
    public void  evaluateSwarmFitness()
    {
        int index=0;
       
        for(int i=0;i<fitnessValues.length;i++)
        {
            if(gBest<fitnessValues[i])
            {
                gBest=fitnessValues[i];
                index=i;
            }
        }
        gBestLocation.setX(particles.get(index).getBestPosition().getX());
        gBestLocation.setY(particles.get(index).getBestPosition().getY());
             
        
    }
    public int getRandom(int max,int min)
    {
        Random rand=new Random();
        int result=Math.abs(rand.nextInt(max + 1 - min) + min);
        return result;
        
        
    }
    public void initSwarm(FitnessFunction ff){
        
        Particle particle;
        Random rand=new Random();
        fitnessValues=new double[numberOfParticles];
        for(int i=0;i<numberOfParticles;i++)
        {
            
            Random r=new Random();
            double longitude=longRangeMin+(getRandom((int)longRangeMax, (int)longRangeMin))*r.nextDouble();
            double latitude=latRangeMin+(getRandom((int)latRangeMax, (int)latRangeMin))*r.nextDouble();
            particle=new Particle();
            double posX=longitude;
            double posY=latitude;
            
            particle.setPosition(new Position(posX,posY));
            
            double velocity=velocityRangeMin+(getRandom((int)velocityRangeMax, (int)velocityRangeMin))*r.nextDouble();
            double depth=depthRangeMin+(getRandom((int)depthRangeMax, (int)depthRangeMin))*r.nextDouble();
            double velocityX=velocity;
            double velocityY=depth;
            
            particle.setVelocity(new Velocity(velocityX,velocityY));
            
            //evaluate fitness
            particle.setFitness(ff.getFitness(particle));
            
            //set pbest value as current fitness 
            particle.setBestFitness(particle.getFitness());
            fitnessValues[i]=particle.getBestFitness();
            particle.setBestPosition(particle.getPosition());
            particles.add(particle);
        }
        
        
    }
    public void printparticles(int particleNum,int posX,int posY,double fitness,double bestfitness)
    {
        System.out.println("-------------------------------------------------------------------------");
        System.out.print(particleNum);
        System.out.print("                    ||            ");
        System.out.print("("+posX+","+posY+")");
        System.out.print(" ||  current fitness: "+fitness+"  pbest: "+bestfitness);
        System.out.println("-------------------------------------------------------------------------");
    }
    public void updateSwarm(Graphics g,int particlenum,double w,FitnessFunction ff)
    {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&   i value is : "+i);
      
        if(i<=numberOfParticles)
        {        
            
                i++;
            
        }
        else if(i>numberOfParticles){
                System.out.println("All particles went through one iteration");
          
                evaluateSwarmFitness();
            
            
                System.out.println("Total number of iterations completed:"+j);
                i=1;
                clearscreen();
              int count=0;
              System.out.println("---------------> START Iteartion : "+j+" <-------------------------------------");
              for(Particle particle:particles)
              {
                  printparticles(count,Math.round((int)particle.getPosition().getX()),Math.round((int)particle.getPosition().getY()),particle.getFitness(),particle.getBestFitness());
                  Color color=java.awt.Color.BLUE;              
                  particle.showUpdatedParticle(g,color,Math.abs(previousXValues[count]), Math.abs(previousYValues[count]),Math.abs(particle.getPosition().getX()),Math.abs(particle.getPosition().getY()));
                  count++;
              }
              System.out.println("---------------> END Iteartion : "+j+" <-------------------------------------");
              //call fitness - gbest
              System.out.println( j+" : Swarm fitness - GBest: "+gBest+" And the best position is: ("+getgBestLocation().getX()+","+getgBestLocation().getY()+")");
              j++;
        }
        
        previousXValues[particlenum]=particles.get(particlenum).getPosition().getX();
        previousYValues[particlenum]=particles.get(particlenum).getPosition().getY();
       
        Random rand=new Random();
        fitnessValues=new double[numberOfParticles];
            int i=particlenum;
            w=1.0;
            double C1=1.0;
            double C2=1.0;
            double r1=rand.nextDouble();
            double r2=rand.nextDouble();
            double lastX=particles.get(i).getPosition().getX();
            double lastY=particles.get(i).getPosition().getY();
            double lastVelocityX=particles.get(i).getVelocity().getVelocityX();
            double lastVelocityY=particles.get(i).getVelocity().getVelocityY();
            
          //  double pBest=particles.get(i).getBestFitness();
            
            double pBestX=particles.get(i).getBestPosition().getX();
            double pBestY=particles.get(i).getBestPosition().getY();
            
            double gBestX=gBestLocation.getX();            
            double gBestY=gBestLocation.getY();
            
            double newVelocityX=((w*lastVelocityX)+(r1*C1)*(pBestX-lastX)+(r2*C2)*(gBestX-lastX));
            double newVelocityY=((w*lastVelocityY)+(r1*C1)*(pBestY-lastY)+(r2*C2)*(gBestY-lastY));
            
            particles.get(i).setVelocity(new Velocity(newVelocityX,newVelocityY));
            
           
            
            double newPosX=lastX+newVelocityX;
            double newPosY=lastY+newVelocityY;
            
//            System.out.println("*****************************Particle: "+i+"**********************");
//            System.out.println("X: "+newPosX+" Y: "+newPosY+" velocity: "+newVelocityX+" Depth: "+newVelocityY);
//            System.out.println("****************************************************************");
            
            particles.get(i).setPosition(new Position(newPosX,newPosY));
            
            
            particles.get(i).setFitness(ff.getFitness(particles.get(i)));
            
            
            particles.get(i).setBestFitnessValue();
            
            fitnessValues[i]=particles.get(i).getBestFitness();
            
        
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }

    public void setParticles(ArrayList<Particle> particles) {
        this.particles = particles;
    }
    
    public void addParticle(Particle p)
    {
        this.particles.add(p);
    }
    
    public int getNumberOfParticles() {
        return numberOfParticles;
    }

    public void setNumberOfParticles(int numberOfParticles) {
        this.numberOfParticles = numberOfParticles;
    }

    public double[] getFitnessValues() {
        return fitnessValues;
    }

    public void setFitnessValues(double[] fitnessValues) {
        this.fitnessValues = fitnessValues;
    }

    public double getgBest() {
        return gBest;
    }

    public void setgBest(double gBest) {
        this.gBest = gBest;
    }

    public Position getgBestLocation() {
        return gBestLocation;
    }

    public void setgBestLocation(Position gBestLocation) {
        this.gBestLocation = gBestLocation;
    }
    
}
