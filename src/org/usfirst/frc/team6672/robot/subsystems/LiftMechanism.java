package org.usfirst.frc.team6672.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class LiftMechanism extends Subsystem {

	WPI_TalonSRX liftController = new WPI_TalonSRX(4);
	double speed = 0.3;

	public void setSpeed(double newSpeed) {
		speed = newSpeed;
	}
	
	public void raiseLift() {
		liftController.setInverted(false);
		liftController.set(speed);
	}
	
	public void lowerLift() {
		liftController.setInverted(true);
		liftController.set(speed);
	}
	
	public void stopLift() {
		liftController.stopMotor();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

