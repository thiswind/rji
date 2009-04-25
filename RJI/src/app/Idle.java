/**app.Idle
 * created on 2009-4-23	上午01:22:26
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
public class Idle implements Behavior {

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#act(rji.sensors.Sensors, rji.robot.Status, rji.subsumption.Velocities)
	 */
	public Velocities act(Sensors sensors, Status agent,
			Velocities currentVelocities) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see rji.subsumption.Behavior#isActive(rji.sensors.Sensors, rji.robot.Status)
	 */
	public boolean isActive(Sensors sensors, Status agent) {
		// TODO Auto-generated method stub
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
