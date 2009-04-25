/**cn.edu.ynu.hukuang.p3dx.subsumption.Arbitrator
 * created on 2009-4-3	下午07:03:37
 */
package rji.subsumption;

import rji.Agent;
import rji.robot.Movement;
import rji.sensors.Sensors;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 * 
 */
public class Arbitrator extends Thread {

	private Behavior[] behaviors;

	private Sensors sensors;
	private Agent agent;

	private static final int NONE = -1;

	public Arbitrator(Behavior[] behaviors, Sensors sensors, Agent agent) {
		this.behaviors = behaviors;

		this.sensors = sensors;
		this.agent = agent;
	}

	public void run() {

		int highest = NONE;
		int current = NONE;
		int maxPriority = this.behaviors.length - 1;

		Velocities currentVelocities = new Velocities(0, 0);
		Velocities tempVelocities = null;

		while (true) {
			// find highest
			// reset highest
			highest = NONE;
			for (int i = maxPriority; i >= 0; i--) {
				if (this.behaviors[i].isActive(this.sensors, this.agent
						.getStatus())) {
					highest = i;
					break;
				}
			}

			// if no highest fond
			if (highest == NONE) {
				// pass
			} else {
				// supress
				if (highest > current && current != NONE) {
					tempVelocities = this.behaviors[current].suppress(this.sensors, this.agent
							.getStatus());
					
					if (tempVelocities != null) {
						Movement movement = this.agent.getMovement();
						movement.setVelocities(tempVelocities);
					}
				}

				// action current
				current = highest;
				tempVelocities = this.behaviors[current].act(this.sensors,
						this.agent.getStatus(), currentVelocities);
				
				if (tempVelocities != null) {
					currentVelocities = tempVelocities;
				}
				
				Movement movement = this.agent.getMovement();
				movement.setVelocities(currentVelocities);
			}

			// sleep for a while
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
