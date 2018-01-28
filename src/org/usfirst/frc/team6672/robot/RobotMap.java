/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6672.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
//	buttonA = 1				lStickXAxis = 1
//	buttonB = 2				lStickYAxis = 2
//	buttonX = 3				Triggers	= 3
//	buttonY = 4				rStickXAxis	= 4
//	lBumper = 5				lStickYAxis = 5
//	rBumper = 6				DPad		= 6
//	buttonBack = 7			
//	buttonStart = 8			
	
	public static final int SPCONTROLLER_RIGHT = 0;
	public static final int SPCONTROLLER_LEFT = 1;	
}
