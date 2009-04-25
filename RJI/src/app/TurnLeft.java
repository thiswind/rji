/**app.TurnLeft
 * created on 2009-4-23	上午03:15:13
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
public class TurnLeft implements Behavior {

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#act(rji.sensors.Sensors, rji.robot.Status, rji.subsumption.Velocities)
	 */
	public Velocities act(Sensors sensors, Status agent,
			Velocities currentVelocities) {
		
		Sonars sonars = sensors.getSonars();
		for (int i=4; i<=7; i++) {
			if (sonars.hasHit(i)) {
				currentVelocities.setRotationalVelocity(-sonars.getAngle(i)/3);
			}
		}
		return currentVelocities;
	}

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#isActive(rji.sensors.Sensors, rji.robot.Status)
	 */
	public boolean isActive(Sensors sensors, Status agent) {
		Sonars sonars = sensors.getSonars();
		
		for (int i=4; i<=7; i++) {
			if (sonars.hasHit(i)) {
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
