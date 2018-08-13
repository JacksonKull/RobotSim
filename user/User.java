package user;

import java.util.ArrayList;

import frc.Field;
import frc.Robot;
import main.Viewer;

public class User {
	public Robot robot;

	public User(Robot robot) {
		this.robot = robot;
		leftPID = new DrivePID(1.0/500.0, 1.0/100.0, 0.0, -16.0, 16.0);
		rightPID = new DrivePID(1.0/500.0, 1.0/100.0, 0.0, -16.0, 16.0);
		anglePID = new BasicPID(1.0/8.0, 0.0, 0.0);
		cs = new ArrayList<Command>();
		cs.add(new DriveCommand(robot,518 - robot.robotWidthPix/2, 0.0, leftPID, rightPID, anglePID));
		cs.add(new DriveCommand(robot,518*2 - robot.robotWidthPix*2, 0.0, leftPID, rightPID, anglePID));
	}

	// ONLY HAVE USE TO THE FOLLOWING FUNCTIONS:
	// setLeftPower(duble) [-1,1], setRightPower(double) [-1,1], double
	// getLeftEncoderDistance(), double getRightEncoderDistance(), double
	// getGyroAngle()
	// use these to program a awesome path planning
	
	// PIDS
	DrivePID leftPID;
	DrivePID rightPID;
	BasicPID anglePID;
	// COMMANDS
	ArrayList<Command> cs;
	
	public void robotPeriodic() {
		// SCHEDULER
		if(cs.size() > 0) {
			if(runCommand(cs.get(0))) {
				cs.remove(0);
			}
		}
	}
	public boolean runCommand(Command c) {
		c.execute();
		return c.isFinished();
	}
}
