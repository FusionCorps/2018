package org.usfirst.frc.team6672.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class ErrorHandler {
	
	public int lastError, currentError;
	public String type, system, message;
	public String stat = "[   ]", err = "[ X ]", warn = "[ ! ]";
	public String drive = "Drive", auton = "Auton", box = "Box  ",
			      lift = "Lift ",  winch = "Winch", robot = "Robot";
	
	public ErrorHandler() {
	}
	
	// For preconfigured errors
	public void reportState(int errorCode) {
		currentError = errorCode;
		switch(errorCode) {
		/*		Case designation:
		 * 		
		 * 		0: Robot status
		 * 		1: Drive status
		 * 		2: Auton status
		 * 		3: Box status
		 * 		4: Lift status
		 * 		5: Winch status
		 * 		9: Custom status
		 */
		
		case 000: retMessage(err, robot, "Fatal error"); break;
		case 001: retMessage(stat, robot, "robotInit()!"); break;
		case 100: retMessage(stat, drive, "Ok!"); break;
		
		case 200: retMessage(stat, auton, "Ok!"); break;
		case 201: retMessage(warn, auton, "autonInit()!"); break;
		case 202: retMessage(warn, auton, "autonGrp added and started!"); break;
		case 299: retMessage(err, auton, "Auton failed to start!"); break;
		
		case 300: retMessage(stat, box, "Ok!"); break;
		case 400: retMessage(stat, lift, "Ok!"); break;
		case 500: retMessage(stat, winch, "Ok!"); break;
		default: break;
		}
		lastError = errorCode;
	}
	
	// For custom errors
	public void reportState(int customCode, int errType, int errSubsystem, String message) {
		currentError = customCode;
		String mErrType = null, mErrSubsystem = null;
		
		switch(errType) {
			case 1: mErrType = stat; break;
			case 2: mErrType = warn; break;
			case 3: mErrType = err; break;
			default: mErrType = stat; break;
		} switch(errSubsystem) {
			case 0: mErrSubsystem = robot; break;
			case 1: mErrSubsystem = drive; break;
			case 2: mErrSubsystem = auton; break;
			case 3: mErrSubsystem = box; break;
			case 4: mErrSubsystem = lift; break;
			case 5: mErrSubsystem = winch; break;
		default: mErrType = robot; break; }
		
		if(mErrType == err) {
			DriverStation.reportError(mErrType + " (" + currentError + ") " + mErrSubsystem + " | " + message, true);
		} else if(mErrType == warn) {
			DriverStation.reportWarning(mErrType + " (" + currentError + ") " + mErrSubsystem + " | " + message, true);
		} else if(mErrType == stat) {
			DriverStation.reportWarning(mErrType + " (" + currentError + ") " + mErrSubsystem + " | " + message, true);
		}
		lastError = customCode;
	}
	
	public void retMessage(String type, String system, String message) {
		if(type == err) {
			DriverStation.reportError(type + " (" + currentError + ") " + system + " | " + message, true);
		} else if(type == warn) {
			DriverStation.reportWarning(type + " (" + currentError + ") " + system + " | " + message, true);
		} else if(type == stat) {
			DriverStation.reportWarning(type + " (" + currentError + ") " + system + " | " + message, true);
		}
	}
	
	public int getLastError() {
		return lastError;
	}
	
	public void handleState(Command handleCommand) {
		Scheduler.getInstance().add(handleCommand);
		Scheduler.getInstance().run();
	}
}
