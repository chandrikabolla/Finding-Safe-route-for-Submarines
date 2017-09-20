/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesspack;

import java.awt.Graphics;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chand
 */
public class MyTimerTask extends TimerTask {

    Swarm swarm;
    FitnessFunction ff;
    int max_i;
    int i;
    int particleNum;
    Graphics g;
    public MyTimerTask(Graphics g,int particlenum,Swarm swarm,FitnessFunction ff,int max_i)
    {
        this.g=g;
     this.particleNum=particlenum;
     this.swarm=swarm; 
     this.ff=ff;
     this.max_i=max_i;
    }
    @Override
    public void run() {
//       double previousX=swarm.getParticles().get(i).getPosition().getX();
//       double previousY=swarm.getParticles().get(i).getPosition().getY();
       double w=0.9-(swarm.j/max_i)*0.5;
        swarm.updateSwarm(g,particleNum,w, ff);   
//        double latestX=swarm.getParticles().get(i).getPosition().getX();
//        double latestY=swarm.getParticles().get(i).getPosition().getY();
    
       
    }
    
    
}
