package org.usfirst.frc.team6672.robot.commands.box;

import java.util.concurrent.TimeUnit;
import org.usfirst.frc.team6672.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DislodgeBox extends Command {

    public DislodgeBox() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.boxControl);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.boxControl.boxDislodge();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.boxControl.boxStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
