package org.usfirst.frc.team6672.robot.commands.drive.autonomous;

import org.usfirst.frc.team6672.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRotate extends Command {

	double mRunTime;
	double mTurnAmt;
	
    public DriveRotate(double runTime, double turnAmt) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveControl);
        this.mRunTime = runTime;
        this.mTurnAmt = turnAmt;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(mRunTime);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveControl.gyroDrive(0.0, mTurnAmt);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveControl.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
