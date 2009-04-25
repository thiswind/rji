/**rji.Agent
 * created on 2009-4-22	下午01:09:18
 */
package rji;

import rji.robot.Movement;
import rji.robot.Status;

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public interface Agent {
	Status getStatus();
	
	Movement getMovement();
}
