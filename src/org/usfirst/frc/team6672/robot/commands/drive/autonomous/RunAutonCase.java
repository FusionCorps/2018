package org.usfirst.frc.team6672.robot.commands.drive.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6672.robot.Robot;

public class RunAutonCase extends Command {

	public RunAutonCase() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	CommandGroup caseCommand = new CommandGroup();

	// Called just before this Command runs the first time
	protected void initialize() {
		char switchLocation = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		char scaleLocation = DriverStation.getInstance().getGameSpecificMessage().charAt(1);

		if (Robot.mAutonTarget == 0) {
			if (switchLocation == 'L') {
				if (Robot.mRobotLocation == 1) {
					System.out.println("Auton case is SWITCH: " + switchLocation + Robot.mRobotLocation);
					Command st1 = new DriveStraight(8.5, -0.28), st2 = new DriveAndRotate(1, 0.35, 0), st3 = new DriveStraight(1.25, -0.6);
					caseCommand.addSequential(st1);
					caseCommand.addSequential(st2);
					caseCommand.addSequential(st3);
					caseCommand.start();
				} else if (Robot.mRobotLocation == 2) {
					System.out.println("Auton case is SWITCH: " + switchLocation + Robot.mRobotLocation);
					
//					Old but working
					Command st1 = new DriveAndRotate(0.5, -0.3, -0.3), st2 = new DriveStraight(1.1, -0.5),
							st3 = new DriveAndRotate(0.4, 0.3, -0.4), st4 = new DriveStraight(1.25, -0.6);
					
//					New maybe working
//					Command st1 = new DriveAndRotate(1.2, -0.2, -0.2), st2 = new DriveStraight(4, -0.3),
//							st3 = new DriveAndRotate(1.2, 0.2, -0.2), st4 = new DriveStraight(1.25, -0.6);
					
					caseCommand.addSequential(st1);
					caseCommand.addSequential(st2);
					caseCommand.addSequential(st3);
					caseCommand.addSequential(st4);
					caseCommand.start();
				} else if (Robot.mRobotLocation == 3) {
					System.out.println("Auton case is SWITCH: " + switchLocation + Robot.mRobotLocation);
					Command st1 = new DriveAndRotate(3, 0.045, -0.5);
					caseCommand.addSequential(st1);
					caseCommand.start();
				} else { Robot.errH.reportState(299); }
			} else if (switchLocation == 'R') {
				if (Robot.mRobotLocation == 1) {
					System.out.println("Auton case is SWITCH: " + switchLocation + Robot.mRobotLocation);
					Command st1 = new DriveAndRotate(3, 0.045, -0.5);
					caseCommand.addSequential(st1);
					caseCommand.start();
				} else if (Robot.mRobotLocation == 2) {
					System.out.println("Auton case is SWITCH: " + switchLocation + Robot.mRobotLocation);
					Command st1 = new DriveAndRotate(0.42, 0.3, -0.3), st2 = new DriveStraight(.9, -0.5),
							st3 = new DriveAndRotate(0.25, -0.3, -0.4), st4 = new DriveStraight(1.25, -0.6);

					caseCommand.addSequential(st1);
					caseCommand.addSequential(st2);
					caseCommand.addSequential(st3);
					caseCommand.addSequential(st4);
					caseCommand.start();
				} else if (Robot.mRobotLocation == 3) {
					System.out.println("Auton case is SWITCH: " + switchLocation + Robot.mRobotLocation);
					Command st1 = new DriveStraight(8.5, -0.28), st2 = new DriveAndRotate(1, -0.35, 0), st3 = new DriveStraight(1.25, -0.6);
//					Command st1 = new DriveStraight(1, -0.6), st2 = new DriveAndRotate(1.0, 0.2, -0.4),
//							st3 = new DriveAndRotate(1, -0.35, -0.3), st4 = new DriveStraight(1.25, -0.6);

					caseCommand.addSequential(st1);
					caseCommand.addSequential(st2);
					caseCommand.addSequential(st3);
//					caseCommand.addSequential(st4);
					caseCommand.start();
				} else { Robot.errH.reportState(299); }
			} else { Robot.errH.reportState(299); }
		} else {
			if(scaleLocation == 'L') {
				if(Robot.mRobotLocation == 1) {
					System.out.println("Auton case is SCALE: " + scaleLocation + Robot.mRobotLocation);
					Command st1 = new DriveAndRotate(4.9, 0.03, 0.5), st2 = new DriveAndRotate(0.8, 0.25, 0), st3 = new AutoRaiseLift(), st4 = new AutoEjectBox();
					caseCommand.addSequential(st1);
					caseCommand.addSequential(st2);
//					caseCommand.addSequential(st3);
//					caseCommand.addSequential(st4);
					caseCommand.start();
				} else if(Robot.mRobotLocation == 3) {
					System.out.println("Auton case is SCALE: " + scaleLocation + Robot.mRobotLocation);
					Command st1 = new DriveAndRotate(3, 0.03, 0.5);
					caseCommand.addSequential(st1);
					caseCommand.start();
				}
			} else if(scaleLocation == 'R') {
				if(Robot.mRobotLocation == 1) {
					System.out.println("Auton case is SCALE: " + scaleLocation + Robot.mRobotLocation);
					Command st1 = new DriveAndRotate(3, 0.03, 0.5);
					caseCommand.addSequential(st1);
					caseCommand.start();
				} else if(Robot.mRobotLocation == 3) {					
					System.out.println("Auton case is SCALE: " + scaleLocation + Robot.mRobotLocation);
					Command st1 = new DriveAndRotate(4.9, 0.03, 0.5), st2 = new DriveAndRotate(0.8, -0.25, 0), st3 = new AutoRaiseLift(), st4 = new AutoEjectBox();
					caseCommand.addSequential(st1);
					caseCommand.addSequential(st2);
//					caseCommand.addSequential(st3);
//					caseCommand.addSequential(st4);
					caseCommand.start();
				}
			}
		}
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
