package org.usfirst.frc.team6672.robot.commands.drive.autonomous;

import org.usfirst.frc.team6672.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class Auton1 extends Command {
	
//	Timer timer = new Timer();
	
	int mRunTime;
//	long mTurnStep; // Fixed position
	double mStraightSpeed;
	
	//	[ ]		3
	//			2
	//	[T]	<-- 1
	
    public Auton1(int runTime, double straightSpeed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveControl);
        this.mRunTime = runTime;
        this.mStraightSpeed = straightSpeed;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1);
    	DriverStation.reportWarning("NOTE: Auton case initialized", false);
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		DriverStation.reportWarning("NOTE: Auton case executing...", false);
    	Robot.driveControl.straightDrive(mStraightSpeed);
    }
    
    public void rotateStep() {
    	
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

	
