package org.usfirst.frc.team6672.robot.commands.drive.autonomous;

import java.util.Timer;
import java.util.TimerTask;

import org.usfirst.frc.team6672.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auton3 extends Command {

	Timer timer = new Timer();
	
	long mRunTime;
	long mTurnStep;
	double mStraightSpeed;
	double mRotateSpeed = 0.5;
	
	//	[ ]	^---3
	//			2
	//	[T]		1
	
    public Auton3(long runTime, double straightSpeed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveControl);
        this.mRunTime = runTime;
        this.mStraightSpeed = straightSpeed;
    }
    
    public void createTimerTask() {
    	TimerTask task = new TimerTask() {
            public void run() {
                isFinished();
            }
        };    
        TimerTask turnStep = new TimerTask() {
            public void run() {
                rotateStep();
            }
        };    
        //delay in milliseconds
        timer.schedule(task, mRunTime);
        timer.schedule(turnStep, mTurnStep);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	createTimerTask();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveControl.straightDrive(mStraightSpeed);
    }
    
    public void rotateStep() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
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

