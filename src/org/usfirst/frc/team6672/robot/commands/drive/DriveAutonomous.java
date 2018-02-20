package org.usfirst.frc.team6672.robot.commands.drive;

import org.usfirst.frc.team6672.robot.*;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAutonomous extends Command {

    public DriveAutonomous() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveControl);
        setTimeout(3);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.driveTrain.gyroDrive(0.5, Robot.driveTrain.getGyroAngle()*0.03*.35);
    	Robot.driveControl.gyroDrive(-0.5, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveControl.gyroDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
