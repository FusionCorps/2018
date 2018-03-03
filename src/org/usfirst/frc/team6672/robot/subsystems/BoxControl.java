package org.usfirst.frc.team6672.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team6672.robot.Robot;
import org.usfirst.frc.team6672.robot.RobotMap;
import org.usfirst.frc.team6672.robot.commands.box.IntakeBox;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *
 */
public class BoxControl extends Subsystem {

	WPI_TalonSRX controller1 = new WPI_TalonSRX(RobotMap.BOXCONTROL_TALON_L);
	WPI_TalonSRX controller2 = new WPI_TalonSRX(RobotMap.BOXCONTROL_TALON_R);
	SpeedControllerGroup intakeGroup = new SpeedControllerGroup(controller1, controller2);
//	Spark controller1 = new Spark(2);
//	Spark controller2 = new Spark(3);
//	SpeedControllerGroup intakeGroup = new SpeedControllerGroup(controller1, controller2);

	double speed = RobotMap.boxControl_def_speed;
	
	public void setSpeed(double newSpeed) {
		speed = newSpeed;
	}
	
	public void boxIntake() {
		controller1.setInverted(true);
		controller2.setInverted(false);
		if(Robot.oi.getStickAxis(2)-Robot.oi.getStickAxis(3) >= 0.8) {
			intakeGroup.set(0.8);
		}
		else if(Robot.oi.getStickAxis(2)-Robot.oi.getStickAxis(3) < 0.8) {
			intakeGroup.set(Robot.oi.getStickAxis(2)-Robot.oi.getStickAxis(3));
		}
		
	}
	
	public void boxEject() {
		controller1.setInverted(false);
		controller2.setInverted(true);
		intakeGroup.set(Robot.oi.getStickAxis(3));
	}
	
	public void boxIntakeFixed() {
		controller1.setInverted(true);
		controller2.setInverted(false);
		intakeGroup.set(speed);
	}
	
	public void boxEjectFixed() {
		controller1.setInverted(false);
		controller2.setInverted(true);
		intakeGroup.set(speed);
	}
	
	public void boxDislodge() {
       	boxEjectFixed();
    	try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	boxIntakeFixed();
       	try {
    			TimeUnit.MILLISECONDS.sleep(200);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    	}
	}
	
	public void boxMusicSpeed(double musicSpeed) {
		controller1.setInverted(false);
		controller2.setInverted(false);
		if(musicSpeed == 0.0) {
			intakeGroup.set(musicSpeed);
		}
		else {
			intakeGroup.set(musicSpeed+0.1);
		}
	}
	
	public void boxStop() {
		intakeGroup.set(0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakeBox());
    }
}

