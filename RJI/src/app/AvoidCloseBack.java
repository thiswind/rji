/**app.AvoidCloseBack
 * created on 2009-4-23	上午03:21:36
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
public class AvoidCloseBack implements Behavior {
	
	private double avoidDist;
	
	public AvoidCloseBack(double avoidDist) {
		this.avoidDist = avoidDist;
	}

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#act(rji.sensors.Sensors, rji.robot.Status, rji.subsumption.Velocities)
	 */
	public Velocities act(Sensors sensors, Status agent,
			Velocities currentVelocities) {
		currentVelocities.setTranslationalVelocity(Math.abs(currentVelocities.getTranslationalVelocity()));
		return currentVelocities;
	}

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#isActive(rji.sensors.Sensors, rji.robot.Status)
	 */
	public boolean isActive(Sensors sensors, Status agent) {
		Sonars sonars = sensors.getSonars();
		
		double dist;
		for (int i=8; i<=15; i++) {
			dist = sonars.getMeasurement(i);
			if (dist < this.avoidDist) {
				return true;
			}
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
