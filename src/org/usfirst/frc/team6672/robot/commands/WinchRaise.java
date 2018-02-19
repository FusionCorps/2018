package org.usfirst.frc.team6672.robot.commands;

import org.usfirst.frc.team6672.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchRaise extends Command {

    public WinchRaise() {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.tasteMechanism);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tasteMechanism.raiseWinch();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.tasteMechanism.stopWinch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}