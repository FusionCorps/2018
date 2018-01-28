package org.usfirst.frc.team6672.robot;

import edu.wpi.first.networktables.*;

public class RobotTables {

	NetworkTable netTable;
	NetworkTableInstance netInstance;
	NetworkTableEntry netEntry;
	NetworkTableValue netEntryVal;
	
	//TODO Literally everything else
	public void init() {
		netInstance.startServer();
		netInstance.startClient();
	}
}
