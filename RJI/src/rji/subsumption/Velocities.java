/**rji.subsumption.Velocities
 * created on 2009-4-23	上午02:14:32
 */
package rji.subsumption;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 * 
 */
public class Velocities {
	private double translationalVelocity;
	private double rotationalVelocity;
	
	public void reset() {
		this.setTranslationalVelocity(0);
		this.setRotationalVelocity(0);
	}

	public Velocities(double translationalVelocity, double rotationalVelocity) {
		this.translationalVelocity = translationalVelocity;
		this.rotationalVelocity = rotationalVelocity;
	}

	public double getTranslationalVelocity() {
		return translationalVelocity;
	}

	public double getRotationalVelocity() {
		return rotationalVelocity;
	}

	public void setTranslationalVelocity(double translationalVelocity) {
		this.translationalVelocity = translationalVelocity;
	}

	public void setRotationalVelocity(double rotationalVelocity) {
		this.rotationalVelocity = rotationalVelocity;
	}

}
