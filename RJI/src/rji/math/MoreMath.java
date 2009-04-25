/**rji.math.MoreMath
 * created on 2009-4-22	下午01:58:09
 */
package rji.math;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public abstract class MoreMath {
	public static double degToRad(double deg) {
		return (deg / 360d) * (2 * Math.PI);
	}
	
	public static double radToDeg(double rad) {
		return (rad / (2 * Math.PI)) * 360d;
	}
}
