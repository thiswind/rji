/**rji.sensors.AbstractSonars
 * created on 2009-4-22	上午12:58:36
 */
package rji.sensors;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public abstract class AbstractSonars implements Sonars {
	
	protected double[] ranges;
	
	public AbstractSonars(int num, double hitRange) {
		this.ranges = new double[num];
	}
	
	/* (non-Javadoc)
	 * @see rji.sensors.Sonars#getRange(int)
	 */
	public double getMeasurement(int num) {
		return this.ranges[num];
	}
	
	/* (non-Javadoc)
	 * @see rji.sensors.Sonars#oneHasHit()
	 */
	public boolean oneHasHit(double hitDist) {
		int size = this.ranges.length;
		for (int i=0; i<size; i++) {
			if (this.getMeasurement(i) < hitDist) {
				return true;
			}
		}
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see rji.sensors.Sonars#getNumSonars()
	 */
	public int getNumSonars() {
		return this.ranges.length;
	}
	
	/* (non-Javadoc)
	 * @see rji.sensors.Sonars#getAngle(int)
	 */
	public abstract double getAngle(int num);
}
