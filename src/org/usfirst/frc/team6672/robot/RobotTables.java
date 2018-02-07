package org.usfirst.frc.team6672.robot;

import edu.wpi.first.networktables.*;

public class RobotTables {
	
	public NetworkTableEntry xEntry;
	public NetworkTableInstance inst;
	double x = 0;
	
	//TODO Server Listener & Client Stuff
	public void robotInit() {
		NetworkTableInstance inst = NetworkTableInstance.create();
		inst.startServer("tables.txt", "192.168.1.2", 22);
		// TODO set datatable stuff
		NetworkTable table = inst.getTable("data");
		xEntry = table.getEntry("x");
	}
		
	public void teleopPeriodic() {
		xEntry.setDouble(x);
		x += 0.5;
	}
	
	public ConnectionInfo[] getConnections() {
		return inst.getConnections();
	}
}
