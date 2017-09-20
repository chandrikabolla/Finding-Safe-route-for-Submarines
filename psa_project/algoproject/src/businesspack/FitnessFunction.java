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
public class FitnessFunction {
    
    private Particle mineParticle;
  
    
    public FitnessFunction(Particle mineParticle){
      
        this.mineParticle=mineParticle;
        
    }
    
    public double getFitness(Particle particle)
    {
        double fitness=0.0;

        double diffX=particle.getPosition().getX()-mineParticle.getPosition().getX();
        double diffY=particle.getPosition().getY()-mineParticle.getPosition().getY();
        
        double squareDiffX=Math.pow(diffX,2.0);
        double squareDiffY=Math.pow(diffY,2.0);
        
        fitness=Math.sqrt(squareDiffX+squareDiffY);
//       if(fitness>severityRange)
//               {
//                   mineParticle.setPosition(new Position(mineParticle.getPosition().getX()+20,mineParticle.getPosition().getY()+20));
//               }

        return fitness;
    }

    public Particle getMineParticle() {
        return mineParticle;
    }

    public void setMineParticle(Particle mineParticle) {
        this.mineParticle = mineParticle;
    }
   
    
    
    
}
