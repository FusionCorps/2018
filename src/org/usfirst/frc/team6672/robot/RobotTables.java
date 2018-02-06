package org.usfirst.frc.team6672.robot;

import edu.wpi.first.networktables.*;

public class RobotTables {
	
	NetworkTableEntry xEntry;
	
	//TODO Server Listener & Client Stuff
	public void robotInit() {
		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		NetworkTable table = inst.getTable("dataTable");
		xEntry = table.getEntry("x");
	}
	
	double x = 0;
	
	public void teleopPeriodic() {
		xEntry.setDouble(x);
		x += 0.5;
	}
}
