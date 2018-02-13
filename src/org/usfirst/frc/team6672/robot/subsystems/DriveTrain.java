package org.usfirst.frc.team6672.robot.subsystems;

import org.usfirst.frc.team6672.robot.*;
import org.usfirst.frc.team6672.robot.commands.DriveNormal;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem here. Call these from Commands.

	SpeedController lSpeedController = new Spark(4);
	SpeedController l2SpeedController = new Spark(3);
	SpeedController rSpeedController = new Spark(6);
	SpeedController r2SpeedController = new Spark(7);
	SpeedController lSpeedControllerGroup = new SpeedControllerGroup(lSpeedController, l2SpeedController);
	SpeedController rSpeedControllerGroup = new SpeedControllerGroup(rSpeedController, r2SpeedController);
	
//	DifferentialDrive robotDrive = new DifferentialDrive(lSpeedController, rSpeedController);
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	double driveSpeed = 0.6;
	double rotateSpeed = 0.6;
	
	public void setDriveSpeed(double newDriveSpeed) {
		driveSpeed = newDriveSpeed;
	}
	
	public void setRotateSpeed(double newRotateSpeed) {
		rotateSpeed = newRotateSpeed;
	}
	
	public void arcadeDrive() {
//		robotDrive.arcadeDrive(Robot.oi.getStickAxis(1) * driveSpeed, Robot.oi.getStickAxis(4) * rotateSpeed);
	}
	
	public void gyroDrive(double xSpeed, double zRotation) {
//		robotDrive.curvatureDrive(xSpeed, zRotation, false);
	}
	
	public double getGyroAngle() {
		return gyro.getAngle();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveNormal());
    }
}

