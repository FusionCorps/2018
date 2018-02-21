package org.usfirst.frc.team6672.robot;

import org.usfirst.frc.team6672.robot.commands.drive.autonomous.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;

public class AutonControl {

	String gameData = getGameData();

	public AutonControl () {
	}
	
	public String getGameData() {
		return DriverStation.getInstance().getGameSpecificMessage();
	}
	
	public int getDSLocation() {
		return DriverStation.getInstance().getLocation();
	}
	
	public void runAuton() {
		
		char switchLocation = gameData.charAt(0);
		int dsLocation = getDSLocation();
		Command auton1 = new Auton1(10, -0.8),
		auton2 = new Auton2(3000, -1.0),
				auton3 = new Auton3(1000, 0.4), auton4 = new Auton4(), 
				auton5 = new Auton5(), auton6 = new Auton6();
		
		if(DriverStation.getInstance().isAutonomous()) {
				if(gameData.length() > 0) {
					DriverStation.reportWarning("NOTE: Entering auton switch...", false);
				switch(switchLocation) {
					case 'L':
						DriverStation.reportWarning("NOTE: (Auton State) Left", false);
//						switch(dsLocation) {
//							case 1:
								DriverStation.reportWarning("NOTE: (Auton Case) 1", false);
								auton1.start();
//							case 2:
//								DriverStation.reportWarning("NOTE: (Auton Case) 2", false);
//								auton2.start();
//							case 3:
//								DriverStation.reportWarning("NOTE: (Auton Case) 3", false);
//								auton3.start();
//							default:
//								DriverStation.reportError("WARN: Could not start Auton program", true);
//						}
//					case 'R':
//						DriverStation.reportWarning("NOTE: (Auton State) Right", false);
//						switch(dsLocation) {
//							case 1:
//								DriverStation.reportWarning("NOTE: (Auton Case) 4", false);
//								auton4.start();
//							case 2:
//								DriverStation.reportWarning("NOTE: (Auton Case) 5", false);
//								auton5.start();
//							case 3:
//								DriverStation.reportWarning("NOTE: (Auton Case) 6", false);
//								auton6.start();
//							default:
//								DriverStation.reportError("WARN: Could not start Auton program", true);
//						}
					default:
						DriverStation.reportError("WARN: Could not start Auton Program", true);
				}
			}
		}
		else {
			DriverStation.reportError("WARN: Auton failed to start (not in Auton)", true);
		}
	}
}
