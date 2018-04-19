package org.usfirst.frc.team6672.robot.commands.drive.autonomous;
import org.usfirst.frc.team6672.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightEncoder extends Command {

	int distanceToDrive = 0;
	
    public DriveStraightEncoder(int distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveControl);
    	distanceToDrive = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveControl.lEncoder.reset();
    	Robot.driveControl.rSpeedController.setInverted(true);
    	Robot.driveControl.r2SpeedController.setInverted(true);
    	Robot.driveControl.driveController.setSetpoint(distanceToDrive);
    	Robot.driveControl.driveController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Distance is " + Robot.driveControl.lEncoder.getDistance());
    	System.out.println("Setpoint is " + Robot.driveControl.driveController.getSetpoint());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveControl.driveController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Drive Controller Disabled");
    	Robot.driveControl.driveController.disable();
    	Robot.driveControl.rSpeedController.setInverted(false);
    	Robot.driveControl.r2SpeedController.setInverted(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
