package user;

import frc.Field;
import frc.Robot;

public class User{
	public Robot robot;
	public User(Robot robot) {
		this.robot = robot;
	}
	// ONLY HAVE USE TO THE FOLLOWING FUNCTIONS:
	// setLeftPower(double) [-1,1], setRightPower(double) [-1,1], double getLeftEncoderDistance(), double getRightEncoderDistance(), double getGyroAngle()
	// use these to program a awesome path planning
	public void robotPeriodic() {
		double rightDist = robot.getRightEncoderDistance();
		double leftDist = robot.getLeftEncoderDistance();
		double goalLocation = 518 - robot.robotWidthPix/2;
		double rightDistError = goalLocation - rightDist;
		double leftDistError = goalLocation - leftDist;
		double P = 1.0/150.0;
		
		robot.setLeftPower(leftDistError*P);
		robot.setRightPower(rightDistError*P);
		
		
	}
}
