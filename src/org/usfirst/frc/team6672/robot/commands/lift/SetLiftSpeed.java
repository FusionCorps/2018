package org.usfirst.frc.team6672.robot.commands.lift;

import org.usfirst.frc.team6672.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetLiftSpeed extends Command {

	double speed = 0.3;
	double mNewSpeed;
	
    public SetLiftSpeed(double newSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	mNewSpeed = newSpeed;
    	speed = newSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.liftControl.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(speed == mNewSpeed) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
