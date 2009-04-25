/**rji.p3dx.P3DXMovement
 * created on 2009-4-23	上午02:06:00
 */
package rji.p3dx;

import rji.robot.Movement;
import rji.subsumption.Velocities;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public class P3DXMovement implements Movement {
	
	private double rotationalVelocity;
	private double translationalVelocity;

	/* (non-Javadoc)
	 * @see rji.robot.Movement#setRotationalVelocity(double)
	 */
	public void setRotationalVelocity(double rotationalVelocity) {
		this.rotationalVelocity = rotationalVelocity;
	}

	/* (non-Javadoc)
	 * @see rji.robot.Movement#setTranslationalVelocity(double)
	 */
	public void setTranslationalVelocity(double translationalVelocity) {
		this.translationalVelocity = translationalVelocity;
	}

	public double getRotationalVelocity() {
		return rotationalVelocity;
	}

	public double getTranslationalVelocity() {
		return translationalVelocity;
	}

	/* (non-Javadoc)
	 * @see rji.robot.Movement#setVelocities(rji.subsumption.Velocities)
	 */
	public void setVelocities(Velocities velocities) {
		synchronized (this) {
			this.setTranslationalVelocity(velocities.getTranslationalVelocity());
			this.setRotationalVelocity(velocities.getRotationalVelocity());
		}
	}
	
	
}
