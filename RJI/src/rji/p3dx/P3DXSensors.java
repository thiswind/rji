/**rji.p3dx.P3DXSensors
 * created on 2009-4-22	上午01:23:17
 */
package rji.p3dx;

import rji.sensors.Bumpers;
import rji.sensors.Sensors;
import rji.sensors.Sonars;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public class P3DXSensors extends Sensors {
	
	private P3DXSonars sonars;
	private P3DXStallBumpers bumpers;
	
	public P3DXSensors(P3DXSonars sonars, P3DXStallBumpers bumpers) {
		this.sonars = sonars;
		this.bumpers = bumpers;
	}

	/* (non-Javadoc)
	 * @see rji.sensors.Sensors#getBumper()
	 */
	public Bumpers getBumpers() {
		return this.bumpers;
	}

	/* (non-Javadoc)
	 * @see rji.sensors.Sensors#getSonars()
	 */
	public Sonars getSonars() {
		return this.sonars;
	}
}
