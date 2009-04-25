import rji.p3dx.P3DXAgent;
import rji.p3dx.P3DXSensors;
import rji.p3dx.P3DXSonars;
import rji.p3dx.P3DXStallBumpers;
import rji.sensors.Sensors;
import rji.subsumption.Arbitrator;
import rji.subsumption.Behavior;
import app.GoStraightConstVelocity;
import app.Idle;

/**.Main
 * created on 2009-4-22	上午01:35:14
 */

/**
 * @author Hukuang(thiswind@vip.qq.com)
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		P3DXSonars sonars = new P3DXSonars(16, 500);
		P3DXStallBumpers bumpers = new P3DXStallBumpers();
		Sensors sensors = new P3DXSensors(sonars, bumpers);
		
		P3DXAgent agent = new P3DXAgent();
		
		P3DXArRobotProxy proxy = new P3DXArRobotProxy(agent, sensors, 40);
		new Thread(proxy).start();
		
		Behavior[] behaviors = {
				new Idle(),
				new GoStraightConstVelocity(1000)
				
		};
		Arbitrator arbi = new Arbitrator(behaviors, sensors, agent);
		arbi.start();
	}

}
