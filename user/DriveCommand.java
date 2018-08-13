package user;

import frc.Robot;

public class DriveCommand extends Command{
	
	double driveGoal, headingGoal, leftInit, rightInit, angleInit;
	DrivePID leftPID;
	DrivePID rightPID;
	BasicPID anglePID;
	Robot bot;
	public DriveCommand(Robot bot, double driveGoal, double headingGoal, DrivePID leftPID, DrivePID rightPID, BasicPID anglePID) {
		this.driveGoal = driveGoal;
		this.headingGoal = headingGoal;
		this.leftPID = leftPID;
		this.rightPID = rightPID;
		this.anglePID = anglePID;
		this.leftInit = bot.getLeftEncoderDistance();
		this.rightInit = bot.getRightEncoderDistance();
		this.angleInit = bot.getGyroAngle();
		this.bot = bot;
		init();
	}
	
	public void init() {
		leftPID.setSetPoint(leftInit + driveGoal);
		rightPID.setSetPoint(rightInit + driveGoal);
		anglePID.setSetPoint(angleInit + headingGoal);
	}
	
	public void execute() {
		// POWERS
		double leftPower = leftPID.getPower(bot.getLeftEncoderDistance());
		double rightPower = rightPID.getPower(bot.getRightEncoderDistance());
		double anglePower = anglePID.getPower(bot.getGyroAngle());
		

		bot.setLeftPower(leftPower + anglePower);
		bot.setRightPower(rightPower - anglePower);
	}
	
	public boolean isFinished() {
		return false;
	}
}
