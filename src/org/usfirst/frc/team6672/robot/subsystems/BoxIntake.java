package org.usfirst.frc.team6672.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6672.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import org.usfirst.frc.team6672.robot.commands.*;

/**
 *
 */
public class BoxIntake extends Subsystem {

//	WPI_TalonSRX lIntakeController = new WPI_TalonSRX(3);
//	WPI_TalonSRX rIntakeController = new WPI_TalonSRX(1);
//	SpeedControllerGroup intakeGroup = new SpeedControllerGroup(lIntakeController, rIntakeController);
	Spark controller1 = new Spark(0);
	Spark controller2 = new Spark(1);
	SpeedControllerGroup intakeGroup = new SpeedControllerGroup(controller1, controller2);

	double speed = 0.6;
	
	public void setSpeed(double newSpeed) {
		speed = newSpeed;
	}
	
	public void boxIntake() {
//		intakeGroup.setInverted(false);
		controller1.setInverted(true);
		controller2.setInverted(false);
		intakeGroup.set(Robot.oi.getStickAxis(2)-Robot.oi.getStickAxis(3));
	}
	
	public void boxEject() {
//		intakeGroup.setInverted(true);
		controller1.setInverted(false);
		controller2.setInverted(true);
		intakeGroup.set(Robot.oi.getStickAxis(3));
	}
	
	public void boxStop() {
		intakeGroup.set(0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakeBox());
    }
}

