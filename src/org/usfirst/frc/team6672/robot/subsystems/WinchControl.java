package org.usfirst.frc.team6672.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6672.robot.RobotMap;
import org.usfirst.frc.team6672.robot.commands.winch.StopWinch;

import edu.wpi.first.wpilibj.Spark;

/**
 *
 */
public class WinchControl extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Spark winchController = new Spark(RobotMap.WINCHCONTROL_SPARK);

	double speed = RobotMap.winchControl_def_speed;
	
	public void setWinchSpeed(double newSpeed) {
		speed = newSpeed;
	}
	
	public void raiseWinch() {
		winchController.setInverted(true);
		winchController.set(speed);
	}
	
	public void stopWinch() {
		winchController.set(0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopWinch());
    }
}

