package org.usfirst.frc.team6672.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Spark;

/**
 *
 */
public class TasterControl extends Subsystem {

	WPI_TalonSRX tasteController = new WPI_TalonSRX(3);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark winch = new Spark(2);

	double speed = 1.0;
	double winchSpeed = 0.4;
	
	public void setTasterSpeed(double newSpeed) {
		speed = newSpeed;
	}
	
	public void raiseTaster() {
		tasteController.set(speed);
	}
		
	public void stopTaster() {
		tasteController.set(0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

