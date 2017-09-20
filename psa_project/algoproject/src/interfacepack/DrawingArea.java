/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacepack;

import businesspack.FitnessFunction;
import businesspack.MyTimerTask;
import businesspack.Particle;
import businesspack.Position;
import businesspack.Swarm;
import businesspack.Velocity;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author chand
 */
public class DrawingArea {
    
    static MyFrame myFrame;
    JPanel myPanel;
    public DrawingArea(){
        myFrame=new MyFrame();
        JFrame fr=new JFrame();
        fr.pack();
        Insets insets=fr.getInsets();
        fr=null;
        myFrame.setSize(new Dimension(insets.left+insets.right+1800,insets.top+insets.bottom+1000));
        myFrame.setResizable(false);
        //myFrame.setPreferredSize(new Dimension(1000,1000));
        myPanel=myFrame.getMyPanel();
    }
    static FitnessFunction ff;
    static Swarm swarm;
    static double[] initValuesX;
    static double[] initValuesY;

	/** Run a swarm */
	protected void runSwarm() throws InterruptedException {
            ff=new FitnessFunction(new Particle(new Position(800,800),new Velocity(20.0,20.0)));
                swarm=new Swarm(30);
                int swarmSize=swarm.getNumberOfParticles();
                initValuesX=new double[swarm.getNumberOfParticles()];
                initValuesY=new double[swarm.getNumberOfParticles()];
                swarm.initSwarm(ff);
                swarm.evaluateSwarmFitness();
                System.out.println("Swarm fitness - GBest: "+swarm.getgBest()+" And the best position is: "+swarm.getgBestLocation());
                ff.getMineParticle().showMineParticle(myFrame.getGraphics(),ff.getMineParticle().getPosition().getX(),ff.getMineParticle().getPosition().getY());
               
                    
              int count=0;
              System.out.println("---------------> Initialization START <-------------------------------------");
              for(Particle particle:swarm.getParticles())
              {
                  swarm.printparticles(count,Math.round((int)particle.getPosition().getX()),Math.round((int)particle.getPosition().getY()),particle.getFitness(),particle.getBestFitness());
                 initValuesX[count]=particle.getPosition().getX();
                    initValuesY[count]=particle.getPosition().getY();
                    count++;
                    particle.showinitalizedParticle(myFrame.getGraphics(),particle.getPosition().getX(),particle.getPosition().getY());
                
              }
              System.out.println("---------------> END INITIALIZATION <-------------------------------------");
        System.out.println("Updating: ");
        int max_i=2;
        Timer timer=new Timer(true);
        List<MyTimerTask> tasks=new ArrayList<MyTimerTask>();
        for(int i=0;i<swarmSize;i++)
        {
            MyTimerTask task=new MyTimerTask(myFrame.getGraphics(),i,swarm, ff, max_i);
            tasks.add(task);
            
        }       
        for(MyTimerTask task:tasks)
        {
           
            timer.scheduleAtFixedRate(task,0,1000);
        }
        System.out.println("Timer before sleep :"+new Date());
      
        Thread.sleep(40000);
         System.out.println("Timer after sleep:"+new Date());
        /*for(int i=0;i<max_i;i++)
        {
            System.out.println("Iteration : "+i+"");
            double w=0.9-(i/max_i)*0.5;
                         
             swarm.evaluateSwarmFitness();
             System.out.println(i +" : Swarm fitness - GBest: "+swarm.getgBest()+" And the best position is: "+swarm.getgBestLocation());
        }*/
         System.out.println("Timer task cancelling after:"+new Date());
       timer.cancel();
	}

	public static void clearscreen(){
            
            
            myFrame.getGraphics().setColor(Color.CYAN);
            myFrame.getGraphics().fillRect(0, 0,myFrame.getWidth(), myFrame.getHeight());
            ff.getMineParticle().showMineParticle(myFrame.getGraphics(),ff.getMineParticle().getPosition().getX(),ff.getMineParticle().getPosition().getY());
                for(int i=0;i<swarm.getNumberOfParticles();i++)
                    
                {
                    Particle particle=swarm.getParticles().get(i);
                     particle.showinitalizedParticle(myFrame.getGraphics(),initValuesX[i],initValuesY[i]);
                }
        }
}
