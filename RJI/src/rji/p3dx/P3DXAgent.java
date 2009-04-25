/**rji.p3dx.P3DXAgent
 * created on 2009-4-22	下午02:02:05
 */
package rji.p3dx;

import rji.Agent;
import rji.robot.Movement;
import rji.robot.Status;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 * 
 */
public class P3DXAgent implements Agent {
	
	private Status status;
	private Movement movement;
	
	public P3DXAgent() {
		this.status = new P3DXStatus();
		this.movement = new P3DXMovement();
	}

	/* (non-Javadoc)
	 * @see rji.Agent#getStatus()
	 */
	public Status getStatus() {
		return this.status;
	}

	/* (non-Javadoc)
	 * @see rji.Agent#getMovement()
	 */
	public Movement getMovement() {
		return this.movement;
	}

}
