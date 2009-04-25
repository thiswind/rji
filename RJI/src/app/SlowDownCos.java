/**RJI.SlowDownCos
 * created on : 2009-4-24	下午04:37:32
 */
package app;

import rji.math.MoreMath;
import rji.robot.Status;
import rji.sensors.Sensors;
import rji.sensors.Sonars;
import rji.subsumption.Behavior;
import rji.subsumption.Velocities;

/**
 * @author <a href="mailto:thiswind@vip.qq.com>Hukuang</a>
 *
 */
public class SlowDownCos implements Behavior {
	
	private double slowDownDist;
	
	public SlowDownCos(double slowDownDist) {
		this.slowDownDist = slowDownDist;
	}

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
	
	
	protected boolean isTouchInVelly(double vallyLength, double velocity, Sonars sonars) {
		
		if (velocity > 0) {
			// TODO 前方
		} else if (velocity < 0) {
			// TODO 后方
		} else {
			// TODO 前面和后面
		}
		
		return false;
	}
	
	protected double getVelly(double distance, double angle, double swingRadius) {
		double dist = this.getVellyDist(angle, distance);
		double distMax = this.getVellyDistMax(angle, swingRadius);
		
		if (dist > distMax) {
			return dist;
		} else {
			return dist;
		}
	}
	protected double getVellyDistMax(double angle, double swingRadius) {
		return swingRadius / Math.sin(MoreMath.degToRad(angle));
	}
	protected double getVellyDist(double angle, double distance) {
		return distance / Math.cos(MoreMath.degToRad(angle));
	}
}


