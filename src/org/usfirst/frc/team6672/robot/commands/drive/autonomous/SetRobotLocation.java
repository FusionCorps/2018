package org.usfirst.frc.team6672.robot.commands.drive.autonomous;

import org.usfirst.frc.team6672.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetRobotLocation extends Command {

	int mRobotLocation = 1;
	
    public SetRobotLocation(int robotLocation) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.mRobotLocation = robotLocation;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.autonControl.setRobotLocation(mRobotLocation);
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
    }
}
