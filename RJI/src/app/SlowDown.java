/**app.SlowDown
 * created on 2009-4-23	上午03:30:47
 */
package app;

import rji.robot.Status;
import rji.sensors.Sensors;
import rji.sensors.Sonars;
import rji.subsumption.Behavior;
import rji.subsumption.Velocities;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public class SlowDown implements Behavior {
	
	private double slowDownDist;
	private double currentMinDist;
	
	public SlowDown(double slowDownDist) {
		this.slowDownDist = slowDownDist;
	}

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#act(rji.sensors.Sensors, rji.robot.Status, rji.subsumption.Velocities)
	 */
	public Velocities act(Sensors sensors, Status agent,
			Velocities currentVelocities) {
		
		double k = 0.5;
		double translationalVelocity = Math.min(this.currentMinDist * k, currentVelocities.getTranslationalVelocity());
		currentVelocities.setTranslationalVelocity(translationalVelocity);
		
		return currentVelocities;
	}

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#isActive(rji.sensors.Sensors, rji.robot.Status)
	 */
	public boolean isActive(Sensors sensors, Status agent) {
		Sonars sonars = sensors.getSonars();
		
		this.currentMinDist = Double.MAX_VALUE;
		double dist;
		for (int i=0; i<=15; i++) {
			dist = sonars.getMeasurement(i);
			if (dist < this.currentMinDist) {
				this.currentMinDist = dist;
			}
		}
		
		if (this.currentMinDist < this.slowDownDist) {
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#suppress(rji.sensors.Sensors, rji.robot.Status)
	 */
	public Velocities suppress(Sensors sensors, Status agent) {
		// TODO Auto-generated method stub
		return null;
	}

}
