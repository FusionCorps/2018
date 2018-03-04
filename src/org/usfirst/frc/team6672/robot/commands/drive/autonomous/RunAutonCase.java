package org.usfirst.frc.team6672.robot.commands.drive.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team6672.robot.Robot;


/**
 *
 */
public class RunAutonCase extends Command {

    public RunAutonCase() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    CommandGroup caseCommand = new CommandGroup();

    // Called just before this Command runs the first time
    protected void initialize() {
		char switchLocation = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		char scaleLocation = DriverStation.getInstance().getGameSpecificMessage().charAt(2);
		if(switchLocation == 'L') {
			if(Robot.mRobotLocation == 1) {
				System.out.println("Auton case is: " + switchLocation + Robot.mRobotLocation);
//				Command st1 = new DriveStraight(1.5, -0.6),     st2 = new DriveAndRotate(0.5, -0.2, -0.4),
//						st3 = new DriveAndRotate(2, 0.2, -0.3), st4 = new DriveStraight(1, -0.6);
//				
////				Command st1 = new DriveStraight(1, -0.5), st2 = new DriveRotate(1, 90);
//				
//				
//				caseCommand.addSequential(st1);
//				caseCommand.addSequential(st2);
//				caseCommand.addSequential(st3);
//				caseCommand.addSequential(st4);
//				
////				caseCommand.addSequential(st1);
////				caseCommand.addSequential(st2);
//				caseCommand.start();
				Command st1 = new DriveAndRotate(3, 0.045, -0.5);
				caseCommand.addSequential(st1);				
				caseCommand.start();
			}
			else if(Robot.mRobotLocation == 2) {
				System.out.println("Auton case is: " + switchLocation + Robot.mRobotLocation);
				Command st1 = new DriveAndRotate(0.5, -0.3, -0.3),st2 = new DriveStraight(1, -0.5),
						st3 = new DriveAndRotate(0.65, 0.3, -0.4), st4 = new DriveStraight(1.25, -0.45);
				
				caseCommand.addSequential(st1);
				caseCommand.addSequential(st2);
				caseCommand.addSequential(st3);
				caseCommand.addSequential(st4);
				caseCommand.start();
			}
			else if(Robot.mRobotLocation == 3) {
				System.out.println("Auton case is: " + switchLocation + Robot.mRobotLocation);
//				Command st1 = new DriveStraight(3, -0.6);
//				
//				caseCommand.addSequential(st1);
//				caseCommand.start();
				Command st1 = new DriveAndRotate(3, 0.045, -0.5);
				caseCommand.addSequential(st1);				
				caseCommand.start();
			}
			else {
				DriverStation.reportError("Auton failed to start (Robot Location): " + Robot.mRobotLocation, false);
			}
		}
		else if(switchLocation == 'R') {
			if(Robot.mRobotLocation == 1) {
				System.out.println("Auton case is: " + switchLocation + Robot.mRobotLocation);
//				Command st1 = new DriveStraight(2.5, -0.5);
//				
				Command st1 = new DriveAndRotate(3, 0.045, -0.5);
				caseCommand.addSequential(st1);				
				caseCommand.start();
//				caseCommand.addSequential(st1);
//				caseCommand.start();
			}
			else if(Robot.mRobotLocation == 2) {
				System.out.println("Auton case is: " + switchLocation + Robot.mRobotLocation);
				Command st1 = new DriveAndRotate(0.5, 0.3, -0.3),  st2 = new DriveStraight(1.25, -0.5),
						st3 = new DriveAndRotate(0.4, -0.3, -0.4), st4 = new DriveStraight(1.25, -0.5);
				
				caseCommand.addSequential(st1);
				caseCommand.addSequential(st2);
				caseCommand.addSequential(st3);
				caseCommand.addSequential(st4);
				caseCommand.start();
			}
			else if(Robot.mRobotLocation == 3) {
				System.out.println("Auton case is: " + switchLocation + Robot.mRobotLocation);
//				Command st1 = new DriveStraight(1, -0.6),         st2 = new DriveAndRotate(1, 0.2, -0.4),
//						st3 = new DriveAndRotate(1, -0.35, -0.3), st4 = new DriveStraight(1.25, -0.6);
				
//				caseCommand.addSequential(st1);
//				caseCommand.addSequential(st2);
//				caseCommand.addSequential(st3);
//				caseCommand.addSequential(st4);
				
				Command st1 = new DriveAndRotate(3, 0.045, -0.5);
				caseCommand.addSequential(st1);				
				caseCommand.start();

//				Command st1 = new DriveStraight(2, -0.2), st2 = new DriveRotate(1, -0.2);

//				caseCommand.addSequential(st2);
			}
			else {
				DriverStation.reportError("Auton failed to start (Robot Location): " + Robot.mRobotLocation, false);
			}
		}
		else {
			DriverStation.reportError("Auton failed to start (switchLocation): " + switchLocation, false);
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
