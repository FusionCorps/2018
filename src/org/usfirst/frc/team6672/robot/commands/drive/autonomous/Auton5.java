package org.usfirst.frc.team6672.robot.commands.drive.autonomous;

import org.usfirst.frc.team6672.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auton5 extends Command {
	
	//	[T]	<-| 3
	//		  |-2
	//	[ ]		1
	
    public Auton5() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveControl);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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