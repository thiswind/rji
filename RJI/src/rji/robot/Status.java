/**rji.robot.Status
 * created on 2009-4-23	上午01:58:27
 */
package rji.robot;

import rji.math.Point2D;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public interface Status {
	double getTranslationalVelocity();
	
	double getRotationalVelocity();
	
	double getHeading();
	
	double getOdometer();
	
	Point2D getPosition();
}
