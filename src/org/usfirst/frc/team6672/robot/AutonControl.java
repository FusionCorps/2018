package org.usfirst.frc.team6672.robot;

import org.usfirst.frc.team6672.robot.commands.drive.autonomous.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonControl {
	
	// Default data
	public String mGameData = "LLL";
	public int mRobotLocation = 3;
	
	//	[ ]		3	
	//			2	Autonomous 1
	//	[T]	<-- 1	
	
	//	[ ]		3	
	//		  |-2	Autonomous 2
	//	[T]	<-| 1	
	
	//	[ ]	^---3	
	//			2	Autonomous 3
	//	[T]		1
	
	//	[T]	<---3
	//			2	Autonomous 4
	//	[ ]		1
	
	//	[T]	<-| 3
	//		  |-2	Autonomous 5
	//	[ ]		1
	
	//	[T]	    3
	//			2	Autonomous 6
	//	[ ]	\/--1
	
	public AutonControl () {
	}
	
	public void setRobotLocation(int robotLocation) {
		this.mRobotLocation = robotLocation;
	}
	
	public void runAuton() {
		
		char switchLocation = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		
		if(DriverStation.getInstance().isAutonomous()) {		// Check if in Auton and switch is NOT target
			if(mGameData.length() > 0) {						// Make sure gameData is not null
				System.out.println("****** ENTERING AUTON SWITCH ******");
				System.out.println("Robot Location is: " + mRobotLocation);
				System.out.println("Switch Location is: " + switchLocation);
				
				// Switch on left-hand side
				if(switchLocation == 'L') {
					// FINISHED
					if(mRobotLocation == 1) {
						System.out.println("Auton case is: " + switchLocation + mRobotLocation);
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveStraight(1.5, -0.6),        st2 = new DriveAndRotate(0.5, -0.2, -0.4),
								st3 = new DriveAndRotate(1.25, 0.3, -0.3), st4 = new DriveStraight(1.25, -0.6);
						
						cmGrp.addSequential(st1);
						cmGrp.addSequential(st2);
						cmGrp.addSequential(st3);
						cmGrp.addSequential(st4);
						cmGrp.start();
					}
					// FINISHED
					else if(mRobotLocation == 2) {
						System.out.println("Auton case is: " + switchLocation + mRobotLocation);
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveAndRotate(1, -0.3, -0.3),  st2 = new DriveStraight(1, -0.5),
								st3 = new DriveAndRotate(0.6, 0.3, -0.4), st4 = new DriveStraight(1.25, -0.45);
						
						cmGrp.addSequential(st1);
						cmGrp.addSequential(st2);
						cmGrp.addSequential(st3);
						cmGrp.addSequential(st4);
						cmGrp.start();
					}
					// FINISHED
					else if(mRobotLocation == 3) {
						System.out.println("Auton case is: " + switchLocation + mRobotLocation);
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveStraight(3, -0.6);
						
						cmGrp.addSequential(st1);
						cmGrp.start();
					}
					else {
						DriverStation.reportError("Auton failed to start (dsLocation)", true);
					}
				}
				
				// Switch on right-hand side
				else if(switchLocation == 'R') {
					// FINISHED
					if(mRobotLocation == 1) {
						System.out.println("Auton case is: " + switchLocation + mRobotLocation);
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveStraight(1.5, -0.5);
						
						cmGrp.addSequential(st1);
						cmGrp.start();
					}
					// FINISHED
					else if(mRobotLocation == 2) {
						System.out.println("Auton case is: " + switchLocation + mRobotLocation);
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveAndRotate(0.5, 0.3, -0.3),  st2 = new DriveStraight(1.25, -0.5),
								st3 = new DriveAndRotate(0.4, -0.3, -0.4), st4 = new DriveStraight(1.25, -0.5);
						
						cmGrp.addSequential(st1);
						cmGrp.addSequential(st2);
						cmGrp.addSequential(st3);
						cmGrp.addSequential(st4);
						cmGrp.start();
					}
					// FINISHED
					else if(mRobotLocation == 3) {
						System.out.println("Auton case is: " + switchLocation + mRobotLocation);
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveStraight(1, -0.6),         st2 = new DriveAndRotate(1, 0.2, -0.4),
								st3 = new DriveAndRotate(1, -0.35, -0.3), st4 = new DriveStraight(1.25, -0.6);
						
						cmGrp.addSequential(st1);
						cmGrp.addSequential(st2);
						cmGrp.addSequential(st3);
						cmGrp.addSequential(st4);
						cmGrp.start();
					}
					else {
						DriverStation.reportError("Auton failed to start (dsLocation)", true);
					}
				}
				else {
					DriverStation.reportError("Auton failed to start (switchLocation)", true);
				}
			}
			else {
				DriverStation.reportError("Auton failed to start (gameData)", true);
			}
		}
		else {
			DriverStation.reportError("Auton failed to start (not in Auton)", true);
		}
	}
}
