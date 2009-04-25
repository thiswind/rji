/**app.GoStraight
 * created on 2009-4-23	上午01:24:41
 */
package app;

import rji.robot.Status;
import rji.sensors.Sensors;
import rji.subsumption.Behavior;
import rji.subsumption.Velocities;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public class GoStraight implements Behavior {
	
	private double translationalVelocity;
	
	public GoStraight(double translationalVelocity) {
		this.translationalVelocity = translationalVelocity;
	}

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#act(rji.sensors.Sensors, rji.robot.Status, rji.subsumption.Velocities)
	 */
	public Velocities act(Sensors sensors, Status agent,
			Velocities currentVelocities) {
		
		currentVelocities.setRotationalVelocity(0);
		currentVelocities.setTranslationalVelocity(this.translationalVelocity);
		
		return currentVelocities;
	}

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#isActive(rji.sensors.Sensors, rji.robot.Status)
	 */
	public boolean isActive(Sensors sensors, Status agent) {
		return true;
	}

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#suppress(rji.sensors.Sensors, rji.robot.Status)
	 */
	public Velocities suppress(Sensors sensors, Status agent) {
		return null;
	}

}
