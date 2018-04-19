package org.usfirst.frc.team6672.robot.subsystems;

import org.usfirst.frc.team6672.robot.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import org.usfirst.frc.team6672.robot.commands.drive.DriveNormal;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 *
 */
public class DriveControl extends Subsystem {

    // Put methods for controlling this subsystem here. Call these from Commands.
	public SpeedController lSpeedController = new Spark(RobotMap.DRIVECONTROL_SPARK_L1);
	public SpeedController l2SpeedController = new Spark(RobotMap.DRIVECONTROL_SPARK_L2);
	SpeedController lSpeedControllerGroup = new SpeedControllerGroup(lSpeedController, l2SpeedController);

	public SpeedController rSpeedController = new Spark(RobotMap.DRIVECONTROL_SPARK_R1);
	public SpeedController r2SpeedController = new Spark(RobotMap.DRIVECONTROL_SPARK_R2);
	SpeedController rSpeedControllerGroup = new SpeedControllerGroup(rSpeedController, r2SpeedController);
	
	SpeedController combinedSpeedControllerGroup = new SpeedControllerGroup(lSpeedController, l2SpeedController, rSpeedController, r2SpeedController);
	
	DifferentialDrive robotDrive = new DifferentialDrive(lSpeedControllerGroup, rSpeedControllerGroup);
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	public Encoder lEncoder = new Encoder(0,1);
	public Encoder rEncoder = new Encoder(2,3);
	double p = 0.015;
	// DRIVE STRAIGHT P VALUE: .015
	// TURN P VALUE: .03
	
	public PIDController driveController = new PIDController(.015, 0, 0, lEncoder, combinedSpeedControllerGroup);
	
	double lDistancePerPulse = Math.PI * 6 / 1440; // 2048
	double rDistancePerPulse = Math.PI * 6 / 2048; //470
	
	double driveSpeed = RobotMap.driveControl_def_driveSpeed;
	double rotateSpeed = RobotMap.driveControl_def_rotateSpeed;
	
	double Kp = 0.03;
	
	public void setupEncoder() {
		lEncoder.setDistancePerPulse(lDistancePerPulse);
		rEncoder.setDistancePerPulse(rDistancePerPulse);
		driveController.setAbsoluteTolerance(5);
		driveController.setOutputRange(-0.6, 0.6);
		lEncoder.reset();
		rEncoder.reset();
	}
	
	public void setDriveSpeed(double newDriveSpeed) {
		driveSpeed = newDriveSpeed;
	}
	
	public void setRotateSpeed(double newRotateSpeed) {
		rotateSpeed = newRotateSpeed;
	}
	
	public void curvatureDrive() {
		robotDrive.curvatureDrive(-Robot.oi.getStickAxis(1) * driveSpeed, Robot.oi.getStickAxis(4) * rotateSpeed, true);
	}
	
	public void curveDrive(double xSpeed, double zRotation) {
		robotDrive.curvatureDrive(xSpeed, zRotation, true);
	}
	
	public void stop() {
		robotDrive.stopMotor();
	}
	
	public double getGyroAngle() {
		return gyro.getAngle();
	}
	
	public void resetGyro() {
		gyro.reset();
	}
	
	public void gyroDrive(double tempSpeed) {
		curveDrive(tempSpeed, 0.0);
	}
	
	public void gyroDrive(double tempSpeed, double turnAmt) {
		curveDrive(tempSpeed, turnAmt);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveNormal());
    }
}

