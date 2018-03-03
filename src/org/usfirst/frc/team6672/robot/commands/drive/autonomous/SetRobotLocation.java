package org.usfirst.frc.team6672.robot.commands.drive.autonomous;

import org.usfirst.frc.team6672.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetRobotLocation extends Command {

	public int mNewRobotLocation;
	Robot robot = new Robot();
	
    public SetRobotLocation(int newRobotLocation) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.mNewRobotLocation = newRobotLocation;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	robot.setRobotLocation(mNewRobotLocation);
    	System.out.println("Set robot location to: " + mNewRobotLocation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
