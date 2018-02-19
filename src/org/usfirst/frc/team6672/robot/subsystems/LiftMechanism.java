package org.usfirst.frc.team6672.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import java.util.concurrent.TimeUnit;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class LiftMechanism extends Subsystem {

	WPI_TalonSRX liftController = new WPI_TalonSRX(2);
	double speed = 0.8;

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
		liftController.set(0.0);
	}
	
	public void holdLift() {
		liftController.set(0.0);
    	try {
			TimeUnit.MILLISECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	liftController.set(0.4);
    	try {
			TimeUnit.MILLISECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
//        setDefaultCommand(());
    }
}

