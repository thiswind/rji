/**rji.subsumption.Behavior
 * created on 2009-4-22	下午11:39:20
 */
package rji.subsumption;

import rji.robot.Status;
import rji.sensors.Sensors;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 * 
 */
public interface Behavior {

	boolean isActive(Sensors sensors, Status agent);

	Velocities act(Sensors sensors, Status agent, Velocities currentVelocities);

	Velocities suppress(Sensors sensors, Status agent);
}
