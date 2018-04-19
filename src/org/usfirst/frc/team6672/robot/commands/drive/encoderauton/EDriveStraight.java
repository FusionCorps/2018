package org.usfirst.frc.team6672.robot.commands.drive.encoderauton;

import org.usfirst.frc.team6672.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class EDriveStraight extends Command {

	int distanceToDrive = 0;
	
    public EDriveStraight(int distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveControl);
    	distanceToDrive = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveControl.lEncoder.reset();
    	Robot.driveControl.rEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double difference = Robot.driveControl.lEncoder.getDistance() - Robot.driveControl.rEncoder.getDistance();
    	double kP = -difference * .015;
    	if (kP <= -0.2) {
    		kP = -0.2;
    	} else if (kP >= 0.2) {
    		kP = 0.2;
    	}
    	if ((distanceToDrive - Robot.driveControl.lEncoder.getDistance() <= 0) && (distanceToDrive - Robot.driveControl.rEncoder.getDistance() <= 0)) {
        	Robot.driveControl.curveDrive(-0.4, kP);
    	} else {
        	Robot.driveControl.curveDrive(0.4, kP);
    	}
    	System.out.println("Left Encoder = " + Robot.driveControl.lEncoder.getDistance());
    	System.out.println("Right Encoder = " + Robot.driveControl.rEncoder.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double lEncoderDistance = Robot.driveControl.lEncoder.getDistance();
    	double rEncoderDistance = Robot.driveControl.rEncoder.getDistance();
    	return (Math.abs(distanceToDrive - lEncoderDistance) <= 5) && (Math.abs(distanceToDrive - rEncoderDistance) <= 5);
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
