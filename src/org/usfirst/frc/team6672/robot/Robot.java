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
//import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team6672.robot.commands.drive.SetRotateSpeed;
import org.usfirst.frc.team6672.robot.commands.drive.autonomous.SetRobotLocation;
import org.usfirst.frc.team6672.robot.commands.drive.autonomous.RunAutonCase;
import org.usfirst.frc.team6672.robot.commands.lift.SetLiftSpeed;
import org.usfirst.frc.team6672.robot.commands.taster.SetTasterSpeed;
import org.usfirst.frc.team6672.robot.commands.winch.SetWinchSpeed;
import org.usfirst.frc.team6672.robot.commands.drive.autonomous.*;
import org.usfirst.frc.team6672.robot.subsystems.*;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.CommandGroup;

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
		
	public static OI oi;
	
	public static DigitalInput limitTop = new DigitalInput(9);
	public static DigitalInput limitBot = new DigitalInput(8);
	
	public static Command cmBoxControl, cmLiftControl, cmTasterControl, cmWinchControl, cmDriveControlRotate,
		cmSetRobotLocation, cmSetAutonTarget;
	public static CommandGroup autonGrp = new CommandGroup();
	public static ErrorHandler errH = new ErrorHandler(); 
	
	SendableChooser<Command> cWinchControl = new SendableChooser<>();
	SendableChooser<Command> cLiftControl = new SendableChooser<>();
	SendableChooser<Command> cTasterControl = new SendableChooser<>();
	SendableChooser<Command> cDriveControlRotate = new SendableChooser<>();
	SendableChooser<Command> cRobotLocation = new SendableChooser<>();
	
	public static int mRobotLocation = 2; // Default value set to 3
	public static int mAutonTarget = 0; // 0 = SWITCH, 1 = SCALE
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		errH.reportState(01);
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
		SmartDashboard.putNumber("Robot Location", mRobotLocation);
		SmartDashboard.putNumber("Auton Target", mAutonTarget);
		SmartDashboard.putNumber("Wait Time", 0.0);
		
		cLiftControl.addDefault("Lift (10)", new SetLiftSpeed(1.0));	
		cLiftControl.addObject("Lift (8)", new SetLiftSpeed(0.8));
		cLiftControl.addObject("Lift (6)", new SetLiftSpeed(0.6));
		cLiftControl.addObject("Lift (4)", new SetLiftSpeed(0.4));
		cLiftControl.addObject("Lift (2)", new SetLiftSpeed(0.4));

		cTasterControl.addDefault("Taster (-5.3)", new SetTasterSpeed(-0.53));	
		cTasterControl.addObject("Taster (-3)", new SetTasterSpeed(-0.33));
		cTasterControl.addObject("Taster (-2)", new SetTasterSpeed(-0.2));
		cTasterControl.addObject("Taster (1)", new SetTasterSpeed(0.1));
		cTasterControl.addObject("Taster (2)", new SetTasterSpeed(0.2));
		
		cWinchControl.addDefault("Winch (10)", new SetWinchSpeed(1.0));	
		cWinchControl.addObject("Winch (8)", new SetWinchSpeed(0.8));
		cWinchControl.addObject("Winch (5)", new SetWinchSpeed(0.5));
		cWinchControl.addObject("Winch (-8)", new SetWinchSpeed(-0.8));
		cWinchControl.addObject("Winch (-10)", new SetWinchSpeed(-1.0));
		
		cDriveControlRotate.addObject("Rotate (10)", new SetRotateSpeed(1.0));	
		cDriveControlRotate.addObject("Rotate (8)", new SetRotateSpeed(0.8));	
		cDriveControlRotate.addDefault("Rotate (6)", new SetRotateSpeed(0.6));	
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
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public static void setRobotLocation(int newRobotLocation) {
		mRobotLocation = newRobotLocation;
	}
	
	public static void setAutonTarget(int newAutonTarget) {
		mAutonTarget = newAutonTarget;
	}
	
	@Override
	public void autonomousInit() {
		errH.reportState(201);
		
		autonGrp = null;
		autonGrp = new CommandGroup();
		
		cmSetRobotLocation = new SetRobotLocation((int)(SmartDashboard.getNumber("Robot Location", 1)));
		
//		UNCOMMENT THIS TO AL
		//LOW FOR SCALE AUTO
		cmSetAutonTarget = new SetAutonTarget((int)(SmartDashboard.getNumber("Auton Target", 0)));
		
//		COMMENT THIS TO ALLOW FOR SCALE AUTO
//		cmSetAutonTarget = new SetAutonTarget(0);
		
		Command runAutonCase = new RunAutonCase();
		autonGrp.addSequential(cmSetRobotLocation);
		autonGrp.addSequential(cmSetAutonTarget);
		autonGrp.addSequential(new Wait((int)SmartDashboard.getNumber("Wait Time", 0)));
		autonGrp.addSequential(runAutonCase);
		autonGrp.start();
		errH.reportState(202);
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
