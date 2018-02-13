/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6672.robot;

import org.usfirst.frc.team6672.robot.commands.*;

import com.ctre.phoenix.time.StopWatch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton; 

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	Joystick stick = new Joystick(0);
	Button buttonA = new JoystickButton(stick, 1);
	Button buttonB = new JoystickButton(stick, 2);
	Button buttonX = new JoystickButton(stick, 3);
	Button buttonY = new JoystickButton(stick, 4);
	Button lBumper = new JoystickButton(stick, 5);
	Button rBumper = new JoystickButton(stick, 6);
	Button buttonBack = new JoystickButton(stick, 7);
	Button buttonStart = new JoystickButton(stick, 8);
	
	public double getStickAxis(int axis) {
		return stick.getRawAxis(axis);
	}
	
	public boolean isStickActive(int axis) {
		return stick.getRawAxis(axis) > 0.5;
	}
	
	public boolean manualIntakeActivated() {
		return buttonBack.get() && stick.getRawAxis(3) > .5 ;
	}
	
	public boolean manualEjectActivated() {
		return buttonBack.get() && stick.getRawAxis(2) > .5 ;
	}
	
	public OI() {
		buttonA.whenPressed(new SetRotateSpeed(1.0));
		buttonB.whenPressed(new SetRotateSpeed(0.7));
		buttonX.whenPressed(new SetRotateSpeed(0.6));
		buttonY.whenPressed(new SetDriveSpeed(0.8));
//		rBumper.whenPressed(new SetDriveSpeed(1.0));
//		buttonBack.whenPressed(new RaiseLift());
//		buttonStart.whenPressed(new LowerLift());
//		lBumper.whenPressed(new StopLift());
		lBumper.whileHeld(new LowerLift());
		rBumper.whileHeld(new RaiseLift());
		buttonBack.whileHeld(new DislodgeBox());
		buttonStart.whileHeld(new BoxMusic());
	}
}
