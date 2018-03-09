package org.usfirst.frc.team6672.robot.commands.drive.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6672.robot.Robot;

/**
 *
 */
public class SetAutonTarget extends Command {
	
	int newAutonTarget;

    public SetAutonTarget(int newAutonTarget) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.newAutonTarget = newAutonTarget;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.setAutonTarget(newAutonTarget);
    	System.out.println("Set auton target to: " + newAutonTarget);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(newAutonTarget == Robot.mAutonTarget) {
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
