/**rji.math.Point2D
 * created on 2009-4-22	下午01:12:56
 */
package rji.math;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public class Point2D {
	private double x;
	private double y;
	
	public Point2D() {
		this(0, 0);
	}
	public Point2D(Point2D p) {
		this(p.x, p.y);
	}
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distanceTo(Point2D p) {
		double dx = p.x - this.x;
		double dy = p.y - this.y;
		
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	public double angleTo(Point2D p) {
		double dy = p.y - this.y;
		double radius = this.distanceTo(p);
		
		return Math.asin(dy / radius);
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
}
