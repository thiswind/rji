/**rji.p3dx.P3DXStallBumpers
 * created on 2009-4-22	上午01:16:37
 */
package rji.p3dx;

import rji.sensors.Bumpers;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public class P3DXStallBumpers implements Bumpers {
	
	private boolean leftStalled;
	private boolean rightStalled;
	
	public P3DXStallBumpers() {
		this.leftStalled = false;
		this.rightStalled = false;
	}

	/* (non-Javadoc)
	 * @see rji.sensors.Bumpers#hasHit()
	 */
	public boolean hasHit() {
		return this.leftStalled || this.rightStalled;
	}
	
	public void setLeftStalled(boolean leftStalled) {
		this.leftStalled = leftStalled;
	}
	public void setRightStalled(boolean rightStalled) {
		this.rightStalled = rightStalled;
	}
}
