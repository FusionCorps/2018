package org.usfirst.frc.team6672.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class ErrorHandler {
	
	public int lastError, currentError;
	public String type, system, message;
	public String stat = "[   ]", err = "[ X ]", warn = "[ ! ]";
	public String drive = "Drive", auton = "Auton", box = "Box  ", lift = "Lift ",  winch = "Winch", robot = "Robot";
	
	public ErrorHandler() {
	}
	
	public void reportState(int errorCode) {
		currentError = errorCode;
		switch(errorCode) {
		/*		Case designation:
		 * 		
		 * 		1: Robot status
		 * 		2: Auton status
		 * 		3: Teleop status
		 * 		4: Subsystem status
		 */
		
		
		case 000: retMessage(err, robot, "Fatal error"); break;
		case 100: break;
		case 200: break;
		case 300: break;
		}
		lastError = errorCode;
	}
	
	public void retMessage(String type, String system, String message) {
		if(type == err) {
			DriverStation.reportError(type + " " + currentError + "" + system + " | " + message, true);
		} else if(type == warn) {
			DriverStation.reportWarning(type + " " + currentError + "" + system + " | " + message, true);
		} else if(type == stat) {
			DriverStation.reportWarning(type + " " + currentError + "" + system + " | " + message, true);
		}
	}
	
	public int getLastError() {
		return lastError;
	}
}
