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

	boolean oneHasHit(double hitDist);

	int getNumSonars();

	double getAngle(int num);
	
	double getSwingOffset(int num);
	
	double getDistFrontCenter(int num);

}