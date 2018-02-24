package org.usfirst.frc.team6672.robot.commands.lift;

import org.usfirst.frc.team6672.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseLift extends Command {
	
    public RaiseLift() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.liftControl);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.limitTop.get()) {
        	Robot.liftControl.raiseLift();
    	}
    	else if (!Robot.limitTop.get()) {
    		Robot.liftControl.holdLift();
    	}
    	else {
    		Robot.liftControl.stopLift();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.liftControl.stopLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
