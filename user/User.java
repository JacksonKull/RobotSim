package user;

import frc.Field;
import frc.Robot;
import main.Viewer;

public class User {
	public Robot robot;

	public User(Robot robot) {
		this.robot = robot;
		leftPID = new BasicPID(1.0/500.0, 1.0/1500.0, 0.0);
		rightPID = new BasicPID(1.0/500.0, 1.0/1500.0, 0.0);
		anglePID = new BasicPID(1.0/8.0, 0.0, 0.0);
	}

	// ONLY HAVE USE TO THE FOLLOWING FUNCTIONS:
	// setLeftPower(double) [-1,1], setRightPower(double) [-1,1], double
	// getLeftEncoderDistance(), double getRightEncoderDistance(), double
	// getGyroAngle()
	// use these to program a awesome path planning
	
	// PIDS
	BasicPID leftPID;
	BasicPID rightPID;
	BasicPID anglePID;
	
	public void robotPeriodic() {
		
		leftPID.setSetPoint(518 - robot.robotWidthPix/2);
		rightPID.setSetPoint(518 - robot.robotWidthPix/2);
		
		// POWERS
		double leftPower = leftPID.getPower(robot.getLeftEncoderDistance());
		double rightPower = rightPID.getPower(robot.getRightEncoderDistance());
		double anglePower = anglePID.getPower(robot.getGyroAngle());
		
		

		robot.setLeftPower(leftPower + anglePower);
		robot.setRightPower(rightPower - anglePower);
	}
}
