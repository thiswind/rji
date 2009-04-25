/**rji.p3dx.P3DXStatus
 * created on 2009-4-23	上午01:59:07
 */
package rji.p3dx;

import rji.math.Point2D;
import rji.robot.Status;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public class P3DXStatus implements Status {

	private double heading;
	private double odometer;
	private double x;
	private double y;
	private double rotationalVelocity;
	private double translationalVelocity;

	/*
	 * (non-Javadoc)
	 * 
	 * @see rji.Agent#getHeading()
	 */
	public double getHeading() {
		return this.heading;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rji.Agent#getOdometer()
	 */
	public double getOdometer() {
		return this.odometer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rji.Agent#getPosition()
	 */
	public Point2D getPosition() {
		return new Point2D(this.x, this.y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rji.Agent#getRotationalVelocity()
	 */
	public double getRotationalVelocity() {
		return this.rotationalVelocity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rji.Agent#getTranslationalVelocity()
	 */
	public double getTranslationalVelocity() {
		return this.translationalVelocity;
	}

	
	public void setHeading(double heading) {
		this.heading = heading;
	}

	public void setOdometer(double odometer) {
		this.odometer = odometer;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setRotationalVelocity(double rotationalVelocity) {
		this.rotationalVelocity = rotationalVelocity;
	}

	public void setTranslationalVelocity(double translationalVelocity) {
		this.translationalVelocity = translationalVelocity;
	}
}
