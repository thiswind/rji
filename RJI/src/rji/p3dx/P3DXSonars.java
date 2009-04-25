/**rji.sensors.P3DXSonar
 * created on 2009-4-22	上午01:09:10
 */
package rji.p3dx;

import rji.robot.Size;
import rji.sensors.AbstractSonars;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public class P3DXSonars extends AbstractSonars {
	
	protected final double[] ROBOT_SONAR_SWING_OFFSET = {
		  210.0,	188.0,	185.0,	184.0,	184.0,	185.0,	188.0,	210.0,
		  180.0,	122.0,	104.0,	100.0,	100.0,	104.0,	122.0,	180.0
	};// mm
	
	private Size size = new P3DXSize();
	
	/**
	 * @param num
	 * @param hitRange
	 */
	public P3DXSonars(int num, double hitRange) {
		super(num, hitRange);
	}
	
	public void setRange(int num, double range) {
		synchronized (this) {
			super.ranges[num] = range;
		}
	}

	/* (non-Javadoc)
	 * @see rji.sensors.AbstractSonars#getAngle(int)
	 */
	public double getAngle(int num) {
		switch (num) {
		//front ring
		case 0 : return 90;
		case 1 : return 50;
		case 2 : return 30;
		case 3 : return 10;
		case 4 : return -10;
		case 5 : return -30;
		case 6 : return -50;
		case 7 : return -90;
		
		//back ring
		case 8 : return -90;
		case 9 : return -130;
		case 10 : return -150;
		case 11 : return -170;
		case 12 : return 170;
		case 13 : return 150;
		case 14 : return 130;
		case 15 : return 90;
		}
		return 0;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		int num = this.getNumSonars();
		for (int i=0; i<num; i++) {
			sb.append("[" + i + "] " + this.getMeasurement(i));
			if (i == 7) sb.append("\n");
		}
		
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see rji.sensors.Sonars#getSwingOffset(int)
	 */
	public double getSwingOffset(int num) {
		return this.ROBOT_SONAR_SWING_OFFSET[num];
	}

	/* (non-Javadoc)
	 * @see rji.sensors.Sonars#getDistFrontCenter(int)
	 */
	public double getDistFrontCenter(int num) {
		double dist = this.getMeasurement(num);
		double d = this.getSwingOffset(num);
		
		return dist + this.size.getSwingRadius() - d;
	}

}
