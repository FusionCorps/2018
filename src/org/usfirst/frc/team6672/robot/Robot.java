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
import org.usfirst.frc.team6672.robot.commands.drive.SetRotateSpeed;
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
	
	public static AutonControl autonControl = new AutonControl(false);	// Not subsystem control
	
	public static OI oi;
	
	public static DigitalInput limitTop = new DigitalInput(9);
	public static DigitalInput limitBot = new DigitalInput(8);
	
	Command cmBoxControl, cmLiftControl, cmTasterControl, cmWinchControl, cmDriveControlRotate;

	SendableChooser<Command> cWinchControl = new SendableChooser<>();
	SendableChooser<Command> cLiftControl = new SendableChooser<>();
	SendableChooser<Command> cTasterControl = new SendableChooser<>();
	SendableChooser<Command> cDriveControlRotate = new SendableChooser<>();

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
		
		cLiftControl.addObject("Lift (10)", new SetLiftSpeed(1.0));	
		cLiftControl.addDefault("Lift (8)", new SetLiftSpeed(0.8));
		cLiftControl.addObject("Lift (6)", new SetLiftSpeed(0.6));
		cLiftControl.addObject("Lift (4)", new SetLiftSpeed(0.4));
		cLiftControl.addObject("Lift (2)", new SetLiftSpeed(0.4));

		cTasterControl.addObject("Taster (10)", new SetTasterSpeed(1.0));	
		cTasterControl.addDefault("Taster (8)", new SetTasterSpeed(0.8));
		cTasterControl.addObject("Taster (6)", new SetTasterSpeed(0.6));
		cTasterControl.addObject("Taster (4)", new SetTasterSpeed(0.4));
		cTasterControl.addObject("Taster (2)", new SetTasterSpeed(0.4));
		
		cWinchControl.addObject("Winch (10)", new SetWinchSpeed(1.0));	
		cWinchControl.addDefault("Winch (8)", new SetWinchSpeed(0.8));
		cWinchControl.addObject("Winch (6)", new SetWinchSpeed(0.6));
		cWinchControl.addObject("Winch (4)", new SetWinchSpeed(0.4));
		cWinchControl.addObject("Winch (2)", new SetWinchSpeed(0.4));
		
		cDriveControlRotate.addObject("Rotate (10)", new SetRotateSpeed(1.0));	
		cDriveControlRotate.addDefault("Rotate (8)", new SetRotateSpeed(0.8));	
		cDriveControlRotate.addObject("Rotate (6)", new SetRotateSpeed(0.6));	
		cDriveControlRotate.addObject("Rotate (4)", new SetRotateSpeed(0.4));	

		SmartDashboard.putData("Lift Speed", cLiftControl);
		SmartDashboard.putData("Taster Speed", cTasterControl);
		SmartDashboard.putData("Rotate Speed", cDriveControlRotate);
		SmartDashboard.putData("Winch Speed", cWinchControl);
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
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		Robot.driveControl.resetGyro();
		autonControl.runAuton();				// Runs main auton program
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
		
		SmartDashboard.updateValues();	//TODO Check if this does anything
		// Would be nice if WPILib's API actually told us right?
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
