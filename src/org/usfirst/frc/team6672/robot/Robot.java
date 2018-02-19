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
import org.usfirst.frc.team6672.robot.commands.*;
import org.usfirst.frc.team6672.robot.subsystems.*;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {	
	public static DriveTrain driveTrain = new DriveTrain();
	public static BoxIntake boxIntake = new BoxIntake();
	public static LiftMechanism liftMechanism = new LiftMechanism();
	public static TasteMechanism tasteMechanism = new TasteMechanism();
	public static final ExampleSubsystem kExampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static RobotTables robotTables;
	public static DigitalInput limitTop = new DigitalInput(9);
	public static DigitalInput limitBot = new DigitalInput(8);
	
	Command autonomousCommand, cmBoxIntake, cmDriveTrain, cmLiftMechanism, cmTasteMechanism, cmWinch, 
		cmDriveTrainRotate;
//	SendableChooser<Command> chooser = new SendableChooser<>();
//	SendableChooser<Command> cDriveTrain = new SendableChooser<>();
	SendableChooser<Command> cTasteWinch = new SendableChooser<>();
	SendableChooser<Command> cLiftMechanism = new SendableChooser<>();
	SendableChooser<Command> cTasteMechanism = new SendableChooser<>();
	SendableChooser<Command> cDriveTrainRotate = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		robotTables = new RobotTables();
		robotTables.robotInit();
		CameraServer.getInstance().startAutomaticCapture();
		
//		chooser.addDefault("Default Auto", new DriveAutonomous());
		// chooser.addObject("My Auto", new MyAutoCommand());
//		SmartDashboard.putData("Auton mode", chooser);
		
		SmartDashboard.putData("Current Command", Scheduler.getInstance());
		SmartDashboard.putData("Current Drive Train", driveTrain);
		SmartDashboard.putData("Current Box Intake", boxIntake);
		SmartDashboard.putData("Current Lift Mechanism", liftMechanism);
		SmartDashboard.putData("Current Winch", tasteMechanism);
		SmartDashboard.putData("Top Limit", limitTop);
		SmartDashboard.putData("Bottom Limit", limitBot);
		
//		cDriveTrain.addObject("[DRIVE] 100%", new SetDriveSpeed(1.0));	
//		cDriveTrain.addDefault("[DRIVE] 80%", new SetDriveSpeed(0.8));
//		cDriveTrain.addObject("[DRIVE] 60%", new SetDriveSpeed(0.6));
//		cDriveTrain.addObject("[DRIVE] 40%", new SetDriveSpeed(0.4));
		
		cLiftMechanism.addObject("[LIFTM] 100%", new SetLiftSpeed(1.0));	
		cLiftMechanism.addDefault("[LIFTM] 80%", new SetLiftSpeed(0.8));
		cLiftMechanism.addObject("[LIFTM] 60%", new SetLiftSpeed(0.6));
		cLiftMechanism.addObject("[LIFTM] 40%", new SetLiftSpeed(0.4));
		cLiftMechanism.addObject("[LIFTM] 20%", new SetLiftSpeed(0.4));

		cTasteMechanism.addObject("[TASTE] 100%", new SetTasterSpeed(1.0));	
		cTasteMechanism.addDefault("[TASTE] 80%", new SetTasterSpeed(0.8));
		cTasteMechanism.addObject("[TASTE] 60%", new SetTasterSpeed(0.6));
		cTasteMechanism.addObject("[TASTE] 40%", new SetTasterSpeed(0.4));
		cTasteMechanism.addObject("[TASTE] 20%", new SetTasterSpeed(0.4));
		
		cTasteWinch.addObject("[WINCH] 100%", new SetWinchSpeed(1.0));	
		cTasteWinch.addDefault("[WINCH] 80%", new SetWinchSpeed(0.8));
		cTasteWinch.addObject("[WINCH] 60%", new SetWinchSpeed(0.6));
		cTasteWinch.addObject("[WINCH] 40%", new SetWinchSpeed(0.4));
		cTasteWinch.addObject("[WINCH] 20%", new SetWinchSpeed(0.4));
		
		cDriveTrainRotate.addObject("[ROTAT] 100%", new SetRotateSpeed(1.0));	
		cDriveTrainRotate.addDefault("[ROTAT] 80%", new SetRotateSpeed(0.8));	
		cDriveTrainRotate.addObject("[ROTAT] 60%", new SetRotateSpeed(0.6));	
		cDriveTrainRotate.addObject("[ROTAT] 40%", new SetRotateSpeed(0.4));	

//		SmartDashboard.putData("DriveTrain Speed", cDriveTrain);
		SmartDashboard.putData("LiftMechanism Speed", cLiftMechanism);
		SmartDashboard.putData("TasteMechanism Speed", cTasteMechanism);
		SmartDashboard.putData("DriveTrainRotate Speed", cDriveTrainRotate);
		SmartDashboard.putData("Winch Speed", cTasteWinch);
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

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
//		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
//		if (autonomousCommand != null) {
//			autonomousCommand.start();
//		}
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
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
//		if (autonomousCommand != null) {
//			autonomousCommand.cancel();
//		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
//		cmDriveTrain = cDriveTrain.getSelected();
		cmTasteMechanism = cTasteMechanism.getSelected();
		cmLiftMechanism = cLiftMechanism.getSelected();
		cmDriveTrainRotate = cDriveTrainRotate.getSelected();
		cmWinch = cTasteWinch.getSelected();
//		cmDriveTrain.start();
		cmTasteMechanism.start();
		cmLiftMechanism.start();
		cmWinch.start();
		cmDriveTrainRotate.start();
		SmartDashboard.updateValues();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
