/**rji.robot.Movement
 * created on 2009-4-23	上午02:00:55
 */
package rji.robot;

import rji.subsumption.Velocities;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 * 
 */
public interface Movement {
	void setRotationalVelocity(double rotationVelocity);

	void setTranslationalVelocity(double translationalVelocity);
	
	void setVelocities(Velocities velocities);
}
