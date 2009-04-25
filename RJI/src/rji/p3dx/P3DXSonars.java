/**rji.sensors.P3DXSonar
 * created on 2009-4-22	上午01:09:10
 */
package rji.p3dx;

import rji.sensors.AbstractSonars;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public class P3DXSonars extends AbstractSonars {

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

}
