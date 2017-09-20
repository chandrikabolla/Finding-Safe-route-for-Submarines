/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacepack;

import businesspack.Swarm;
import java.awt.Dimension;

/**
 *
 * @author chand
 */
public class Example {
    
    public static void main(String[] args) throws InterruptedException {
		System.out.println("Example of Particle Swarm Optimization: Optimizing Rastrijin's funtion");

                
		// Create a swarm (using 'MyParticle' as sample particle and 'MyFitnessFunction' as finess function)
		DrawingArea dd=new DrawingArea();
                dd.runSwarm();
		
		
	}
    
}
