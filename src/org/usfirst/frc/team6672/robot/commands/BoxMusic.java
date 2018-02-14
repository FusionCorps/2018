package org.usfirst.frc.team6672.robot.commands;

import java.util.concurrent.TimeUnit;
import org.usfirst.frc.team6672.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BoxMusic extends Command {
	
	double d = 0.33422;		//
	double a = 0.75076;		//
	double b = 0.56208;		//
	double g = 0.44613;		//
	double e = 0.75015;		//
	double f = 0.39745;		//
	double stop = 0.0;		//
	double hN = 2.0;		// Put this before any note to make it a
							// 		half note
	boolean isHalfNote = false;
	double[] twinkle = { d, d, a, a, b, b, hN, a, g, g, f, f, e, e, hN, d, a, 
			a, g, g, f, f, hN, e, a, a, g, g, f, f, hN, e, d, d, a, a, b, b,
			hN, a, g, g, f, f, e, e, hN, d };
	
    public void BoxMusic() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.boxIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    public void playMusic(double[] inputMusic) {
    	for(double x : inputMusic) {
    		if(x == 2.0) {
    			isHalfNote = true;
    			continue;
    		}
    		if(isHalfNote == false) {
        		Robot.boxIntake.boxMusicSpeed(x);
            	try {
        			TimeUnit.MILLISECONDS.sleep(250);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
               	Robot.boxIntake.boxMusicSpeed(stop);
            	try {
        			TimeUnit.MILLISECONDS.sleep(250);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
    		}
    		if(isHalfNote == true) {
        		Robot.boxIntake.boxMusicSpeed(x);
            	try {
        			TimeUnit.MILLISECONDS.sleep(500);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
               	Robot.boxIntake.boxMusicSpeed(stop);
            	try {
        			TimeUnit.MILLISECONDS.sleep(250);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
               	isHalfNote = false;
    		}
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Setting up orchestra...");
    	playMusic(twinkle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Clap for the orchestra on your way out.");
    	Robot.boxIntake.boxStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
