package org.usfirst.frc.team6672.robot;

import org.usfirst.frc.team6672.robot.commands.box.EjectBox;
import org.usfirst.frc.team6672.robot.commands.drive.autonomous.*;
import org.usfirst.frc.team6672.robot.commands.lift.LowerLift;
import org.usfirst.frc.team6672.robot.commands.lift.RaiseLift;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonControl {

	String gameData = getGameData();
	int mDSLocation;
	boolean mIsSwitchTarget = false, mIsChooserActive = false;
	
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
	
	public AutonControl (boolean isSwitchTarget, boolean isSendableChooserActive) {
		this.mIsSwitchTarget = isSwitchTarget;
		this.mIsChooserActive = isSendableChooserActive;
	}
	
	public void SetDSLocation(int dsLocation) {
		this.mDSLocation = dsLocation;
	}
	
	public String getGameData() {
		return DriverStation.getInstance().getGameSpecificMessage();
	}
	
	public int getDSLocation() {
		return DriverStation.getInstance().getLocation();
	}
	
	// TODO Clean up DS Selectors with SendableChooser options
	// TODO Check if dsLocation detector actually works
	public void runAuton() {
		
		char switchLocation = gameData.charAt(0);
		
		if(mIsChooserActive) {
			this.mDSLocation = getDSLocation();
		}
		else if(!mIsChooserActive) {
		}
		
		if(DriverStation.getInstance().isAutonomous() && !mIsSwitchTarget) {// Check if in Auton and switch is NOT target
			if(gameData.length() > 0) {										// Make sure gameData is not null
				System.out.println("Entering auton switch...");
				
				// Switch on left-hand side
				if(switchLocation == 'L') {
					if(mDSLocation == 1) {
						Command driveStraight = new DriveStraight(1, -1.0);
						driveStraight.start();
					}
					// FINISHED
					else if(mDSLocation == 2) {
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveAndRotate(1, -0.3, -0.3),  st2 = new DriveStraight(1, -0.5),
								st3 = new DriveAndRotate(0.4, 0.4, -0.4), st4 = new DriveStraight(1.25, -0.45);
						
						cmGrp.addSequential(st1);
						cmGrp.addSequential(st2);
						cmGrp.addSequential(st3);
						cmGrp.addSequential(st4);
						cmGrp.start();
					}
					else if(mDSLocation == 3) {
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveAndRotate(1, 0.3, -0.3), st2 = new DriveStraight(1, -0.5);
						
						cmGrp.addSequential(st1);
						cmGrp.addSequential(st2);
						cmGrp.start();
					}
					else {
						DriverStation.reportError("Auton failed to start (dsLocation)", true);
					}
				}
				
				// Switch on right-hand side
				else if(switchLocation == 'R') {
					if(mDSLocation == 1) {
						Command driveStraight = new DriveStraight(2, 1.0);
						driveStraight.start();
					}
					// FINISHED
					else if(mDSLocation == 2) {
						CommandGroup cmGrp = new CommandGroup();
						Command st1 = new DriveAndRotate(0.5, 0.3, -0.3),  st2 = new DriveStraight(1, -0.5),
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
						Command st1 = new DriveStraight(1, -0.6),         st2 = new DriveAndRotate(1.25, 0.2, -0.3),
								st3 = new DriveAndRotate(1, -0.35, -0.4), st4 = new DriveStraight(1.25, -0.6);
						
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
		
		// TODO FINISH TEST CASE
		
		/* TEST CASE
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		if(DriverStation.getInstance().isAutonomous() && mIsSwitchTarget) {// Check if in Auton and switch is NOT target
			if(gameData.length() > 0) {							// Make sure gameData is not null
				System.out.println("Entering auton switch...");
				
				// Switch on left-hand side
				if(switchLocation == 'L') {
					if(mDSLocation == 1) {
						Command driveStraight = new DriveStraight(2, 1.0);
						driveStraight.start();
					}
					else if(mDSLocation == 2) {
						
						/* TEST CASE HERE */
						
						
						
						
						CommandGroup cmGrp = new CommandGroup();
						Command driveStep1 = new DriveStraight(1, 1.0);
						Command rotateStep1 = new DriveRotate(1, -90);
						Command driveStep2 = new DriveStraight(1, 1.0);
						Command rotateStep2 = new DriveRotate(1, 90);
						Command driveStep3 = new DriveStraight(1, 1.0);
						Command liftStep = new RaiseLift();
						Command ejectStep = new EjectBox();
						Command resetStep = new LowerLift();
						
						cmGrp.addSequential(driveStep1);
						cmGrp.addSequential(rotateStep1);
						cmGrp.addSequential(driveStep2);
						cmGrp.addSequential(rotateStep2);
						cmGrp.addSequential(driveStep3);
						cmGrp.addSequential(liftStep, 2);
						cmGrp.addSequential(ejectStep, 0.5);
						cmGrp.addSequential(resetStep, 2);
						
						cmGrp.start();
					}
					else if(mDSLocation == 3) {
						CommandGroup cmGrp = new CommandGroup();
						Command driveStep1 = new DriveStraight(2, 1.0);
						Command rotateStep1 = new DriveRotate(1, 90);
						Command driveStep2 = new DriveStraight(1, 1.0);
						Command rotateStep2 = new DriveRotate(1, -90);
						Command driveStep3 = new DriveStraight(1, 1.0);
						
						cmGrp.addSequential(driveStep1);
						cmGrp.addSequential(rotateStep1);
						cmGrp.addSequential(driveStep2);
						cmGrp.addSequential(rotateStep2);
						cmGrp.addSequential(driveStep3);
						cmGrp.start();
					}
					else {
						DriverStation.reportError("Auton failed to start (dsLocation)", true);
					}
				}
				
				// Switch on right-hand side
				else if(switchLocation == 'R') {
					if(mDSLocation == 1) {
						Command driveStraight = new DriveStraight(2, 1.0);
						driveStraight.start();
					}
					else if(mDSLocation == 2) {
						CommandGroup cmGrp = new CommandGroup();
						Command driveStep1 = new DriveStraight(1, 1.0);
						Command rotateStep1 = new DriveRotate(1, 90);
						Command driveStep2 = new DriveStraight(1, 1.0);
						Command rotateStep2 = new DriveRotate(1, -90);
						Command driveStep3 = new DriveStraight(1, 1.0);
						
						cmGrp.addSequential(driveStep1);
						cmGrp.addSequential(rotateStep1);
						cmGrp.addSequential(driveStep2);
						cmGrp.addSequential(rotateStep2);
						cmGrp.addSequential(driveStep3);
						cmGrp.start();
					}
					else if(mDSLocation == 3) {
						CommandGroup cmGrp = new CommandGroup();
						Command driveStep1 = new DriveStraight(1, 1.0);
						Command rotateStep1 = new DriveRotate(1, -90);
						Command driveStep2 = new DriveStraight(1, 1.0);
						Command rotateStep2 = new DriveRotate(1, 90);
						Command driveStep3 = new DriveStraight(1, 1.0);
						
						cmGrp.addSequential(driveStep1);
						cmGrp.addSequential(rotateStep1);
						cmGrp.addSequential(driveStep2);
						cmGrp.addSequential(rotateStep2);
						cmGrp.addSequential(driveStep3);
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
