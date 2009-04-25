import java.io.IOException;

import rji.p3dx.P3DXAgent;
import rji.p3dx.P3DXMovement;
import rji.p3dx.P3DXSonars;
import rji.p3dx.P3DXStallBumpers;
import rji.p3dx.P3DXStatus;
import rji.sensors.Bumpers;
import rji.sensors.Sensors;
import rji.sensors.Sonars;

/**.P3DXArRobotProxy
 * created on 2009-4-22	上午01:33:44
 */

/**
 * @author Hukuang(thiswind@vip.qq.com)
 * 
 */
public class P3DXArRobotProxy implements Runnable {

	static {
		try {
			System.loadLibrary("AriaJava");
		} catch (UnsatisfiedLinkError e) {
			System.err.println("Native code library " + "libAriaJava failed to"
					+ " load. Make sure that " + "its directory is in your"
					+ " system library path; " + "See the chapter on Dynamic"
					+ " Linking Problems in " + "the SWIG Java documentation"
					+ " (http://www.swig.org) " + "for help.\n" + e);
			System.exit(1);
		}
	}

	private ArRobot robot;

	private Sensors sensors;

	private boolean isRunning;

	private long frameMillis;

	private P3DXAgent agent;

	/**
	 * @param robot
	 */
	public P3DXArRobotProxy(P3DXAgent agent, Sensors sensors, long frameMillis) {

		this.agent = agent;

		this.sensors = sensors;
		this.isRunning = true;
		this.frameMillis = frameMillis;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		Aria.init();

		this.robot = new ArRobot("robot1", true, true, true);
		ArSimpleConnector conn = new ArSimpleConnector(new String[] {});

		if (!Aria.parseArgs()) {
			Aria.logOptions();
			Aria.shutdown();
			System.exit(1);
		}

		if (!conn.connectRobot(this.robot)) {
			System.err.println("Could not connect to robot, exiting.\n");
			System.exit(1);
		}

		ArSonarDevice sonarDevice = new ArSonarDevice();
		this.robot.addRangeDevice(sonarDevice);

		this.robot.lock();
		this.robot.enableMotors();
		this.robot.enableSonar();
		this.robot.runAsync(true);
		this.robot.unlock();

		Thread emergencyStopper = new Thread() {
			public void run() {
				try {
					System.out.println("[PRESS ENTER FOR EMERGENCY STOP]");
					System.in.read();
					isRunning = false;
					System.out.println("[EMERGENCY STOP]");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		emergencyStopper.start();

		long startTime = 0;
		long endTime = 0;
		long elapsedTime = 0;
		long sleepTime = 0;
		while (this.isRunning) {
			startTime = System.currentTimeMillis();

			this.robot.lock();
			this.updateSensors();
			this.updateAgent();
			this.applyAgentMovement();
			this.robot.unlock();

			// 要做多通道的控制，heading 通道优先级高于 rotSpeed 通道
			// 移动到 x，y 通道的优先级高于 velocity 的通道
			// 移动。。。距离通道的优先级高于 velocity 的通道

			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			sleepTime = this.frameMillis - elapsedTime;

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// ignore
			}
		}

		this.robot.lock();
		this.robot.disableMotors();
		this.robot.disableSonar();
		this.robot.disconnect();
		this.robot.unlock();

		Aria.exit();
	}

	protected void updateSensors() {
		this.updateSonars();
		this.updateBumpers();
	}

	private void updateSonars() {
		Sonars s = this.sensors.getSonars();
		if (s instanceof P3DXSonars) {
			P3DXSonars sonars = (P3DXSonars) s;

			int num = sonars.getNumSonars();
			for (int i = 0; i < num; i++) {
				sonars.setRange(i, this.robot.getSonarRange(i));
			}
		}

	}

	private void updateBumpers() {
		Bumpers bprs = this.sensors.getBumpers();
		if (bprs instanceof P3DXStallBumpers) {
			P3DXStallBumpers bumper = (P3DXStallBumpers) bprs;

			bumper.setLeftStalled(this.robot.isLeftMotorStalled());
			bumper.setRightStalled(this.robot.isRightMotorStalled());
		}
	}

	protected void updateAgent() {
		P3DXStatus status = (P3DXStatus) this.agent.getStatus();

		status.setHeading(this.robot.getTh());
		status.setOdometer(this.robot.getOdometerDistance());

		ArPose pose = this.robot.getPose();
		status.setX(pose.getX());
		status.setY(pose.getY());
	}

	protected void applyAgentMovement() {
		P3DXMovement movement = (P3DXMovement) this.agent.getMovement();

		this.robot.setVel(movement.getTranslationalVelocity());
		this.robot.setRotVel(movement.getRotationalVelocity());
	}
}
