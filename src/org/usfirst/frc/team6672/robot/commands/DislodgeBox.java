package org.usfirst.frc.team6672.robot.commands;

import java.util.concurrent.TimeUnit;
import org.usfirst.frc.team6672.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DislodgeBox extends Command {

    public DislodgeBox() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.boxIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Dislodging...");
       	Robot.boxIntake.boxEjectFixed();
    	try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Robot.boxIntake.boxIntakeFixed();
       	try {
    			TimeUnit.MILLISECONDS.sleep(100);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.boxIntake.boxStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}