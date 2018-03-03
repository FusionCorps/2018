package org.usfirst.frc.team6672.robot;

import org.usfirst.frc.team6672.robot.commands.drive.autonomous.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonControl {
	
	String mGameData = "LLL";
	int mDSLocation = 1;
	
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
	
	public boolean checkGameData() {
		return mGameData.length() > 0;
	}
	
	public String getGameData() {
		return DriverStation.getInstance().getGameSpecificMessage();
	}
	
	public int getDSLocation() {
		return DriverStation.getInstance().getLocation();
	}
	
	public void setRobotLocation(int robotLocation) {
		this.mDSLocation = robotLocation;
	}
	
	public void runAuton() {
		
		String gameData = getGameData();
		this.mGameData = gameData;
				
		if(DriverStation.getInstance().isAutonomous()) {// Check if in Auton and switch is NOT target
			if(checkGameData()) {										// Make sure gameData is not null
				System.out.println("Entering auton switch...");
				char switchLocation = gameData.charAt(0);

				// Switch on left-hand side
				if(switchLocation == 'L') {
					// FINISHED
					if(mDSLocation == 1) {
						Command driveStraight = new DriveStraight(1, -1.0);
						driveStraight.start();
					}
					// FINISHED
					else if(mDSLocation == 2) {
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
					else if(mDSLocation == 3) {
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
					if(mDSLocation == 1) {
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveAndRotate(0.5, -0.2, -0.4);
						Command st2 = new DriveStraight(1, -0.4);
						
						cmGrp.addSequential(st1);
						cmGrp.addSequential(st2);
						cmGrp.start();
					}
					// FINISHED
					else if(mDSLocation == 2) {
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
					else if(mDSLocation == 3) {
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveStraight(1, -0.6),        st2 = new DriveAndRotate(1.25, 0.2, -0.4),
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
