/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6672.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team6672.robot.commands.drive.SetRotateSpeed;
import org.usfirst.frc.team6672.robot.commands.drive.autonomous.SetRobotLocation;
import org.usfirst.frc.team6672.robot.commands.lift.SetLiftSpeed;
import org.usfirst.frc.team6672.robot.commands.taster.SetTasterSpeed;
import org.usfirst.frc.team6672.robot.commands.winch.SetWinchSpeed;
import org.usfirst.frc.team6672.robot.subsystems.*;
import edu.wpi.first.wpilibj.CameraServer;
import org.usfirst.frc.team6672.robot.AutonControl;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {	
	public static DriveControl driveControl = new DriveControl();
	public static BoxControl boxControl = new BoxControl();
	public static LiftControl liftControl = new LiftControl();
	public static TasterControl tasterControl = new TasterControl();
	public static WinchControl winchControl = new WinchControl();
	
	public static AutonControl autonControl = new AutonControl();	// (isSwitchTarget, isChooserActive)
	
	public static OI oi;
	
	public static DigitalInput limitTop = new DigitalInput(9);
	public static DigitalInput limitBot = new DigitalInput(8);
	
	Command cmBoxControl, cmLiftControl, cmTasterControl, cmWinchControl, cmDriveControlRotate,
		cmSetRobotLocation;

	SendableChooser<Command> cWinchControl = new SendableChooser<>();
	SendableChooser<Command> cLiftControl = new SendableChooser<>();
	SendableChooser<Command> cTasterControl = new SendableChooser<>();
	SendableChooser<Command> cDriveControlRotate = new SendableChooser<>();
	SendableChooser<Command> cRobotLocation = new SendableChooser<>();
//	boolean isCalledBefore = false;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		CameraServer.getInstance().startAutomaticCapture();

		// TODO Clean up smartdashboard sendablechoosers
		SmartDashboard.putData("Scheduled Commands", Scheduler.getInstance());
		SmartDashboard.putData("Drive Command", driveControl);
		SmartDashboard.putData("Box Command", boxControl);
		SmartDashboard.putData("Lift Command", liftControl);
		SmartDashboard.putData("Winch Command", winchControl);
		SmartDashboard.putData("Taster Command", tasterControl);
		SmartDashboard.putData("Top Limit", limitTop);
		SmartDashboard.putData("Bottom Limit", limitBot);
//		SmartDashboard.putNumber("Robot Location", autonControl.mRobotLocation);
		
		cLiftControl.addObject("Lift (10)", new SetLiftSpeed(1.0));	
		cLiftControl.addDefault("Lift (8)", new SetLiftSpeed(0.8));
		cLiftControl.addObject("Lift (6)", new SetLiftSpeed(0.6));
		cLiftControl.addObject("Lift (4)", new SetLiftSpeed(0.4));
		cLiftControl.addObject("Lift (2)", new SetLiftSpeed(0.4));

		cTasterControl.addObject("Taster (5)", new SetTasterSpeed(0.5));	
		cTasterControl.addDefault("Taster (3)", new SetTasterSpeed(0.3));
		cTasterControl.addObject("Taster (2)", new SetTasterSpeed(0.2));
		cTasterControl.addObject("Taster (-1)", new SetTasterSpeed(-0.1));
		cTasterControl.addObject("Taster (-2)", new SetTasterSpeed(-0.2));
		
		cWinchControl.addObject("Winch (10)", new SetWinchSpeed(1.0));	
		cWinchControl.addDefault("Winch (8)", new SetWinchSpeed(0.8));
		cWinchControl.addObject("Winch (5)", new SetWinchSpeed(0.5));
		cWinchControl.addObject("Winch (-8)", new SetWinchSpeed(-0.8));
		cWinchControl.addObject("Winch (-10)", new SetWinchSpeed(-1.0));
		
		cDriveControlRotate.addObject("Rotate (10)", new SetRotateSpeed(1.0));	
		cDriveControlRotate.addObject("Rotate (8)", new SetRotateSpeed(0.8));	
		cDriveControlRotate.addDefault("Rotate (6)", new SetRotateSpeed(0.6));	
		cDriveControlRotate.addObject("Rotate (4)", new SetRotateSpeed(0.4));	

		cRobotLocation.addDefault("Left", new SetRobotLocation(1));
		cRobotLocation.addObject("Middle", new SetRobotLocation(2));
		cRobotLocation.addObject("Right", new SetRobotLocation(3));
		
		SmartDashboard.putData("Lift Speed", cLiftControl);
		SmartDashboard.putData("Taster Speed", cTasterControl);
		SmartDashboard.putData("Rotate Speed", cDriveControlRotate);
		SmartDashboard.putData("Winch Speed", cWinchControl);
		SmartDashboard.putData("Robot Location", cRobotLocation);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
//		Scheduler.getInstance().run();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		DriverStation.reportWarning("Autonomous initiating...", false);
		cmSetRobotLocation = cRobotLocation.getSelected();
		cmSetRobotLocation.start();
		autonControl.runAuton();	// Runs main auton program
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Robot.driveControl.resetGyro();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		cmTasterControl = cTasterControl.getSelected();
		cmLiftControl = cLiftControl.getSelected();
		cmDriveControlRotate = cDriveControlRotate.getSelected();
		cmWinchControl = cWinchControl.getSelected();
		
		cmTasterControl.start();
		cmLiftControl.start();
		cmWinchControl.start();
		cmDriveControlRotate.start();
		
		SmartDashboard.updateValues();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
