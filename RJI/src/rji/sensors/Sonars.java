/**rji.sensors.Sonars
 * created on 2009-4-22	上午03:11:35
 */
package rji.sensors;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public interface Sonars {

	double getMeasurement(int num);

	boolean hasHit(int num);

	double getHitRange(int num);

	boolean oneHasHit();

	int getNumSonars();

	double getAngle(int num);

}