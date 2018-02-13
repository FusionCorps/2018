package org.usfirst.frc.team6672.robot.commands;

import java.util.concurrent.TimeUnit;
import org.usfirst.frc.team6672.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BoxMusic extends Command {
	
	double d = 0.33422;
	double a = 0.75076;
	double b = 0.56208;
	double g = 0.44613;
	double e = 0.75015;
	double f = 0.39745;
	double stop = 0.0;
	
    public void BoxMusic() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.boxIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Playing 1812 Overture...");
       	Robot.boxIntake.boxMusicSpeed(d);
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
    	Robot.boxIntake.boxMusicSpeed(d);
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
       	Robot.boxIntake.boxMusicSpeed(a);
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
       	Robot.boxIntake.boxMusicSpeed(a);
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
       	Robot.boxIntake.boxMusicSpeed(b);
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
       	Robot.boxIntake.boxMusicSpeed(b);
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
       	Robot.boxIntake.boxMusicSpeed(a); //half note
       	try {
    			TimeUnit.MILLISECONDS.sleep(750);
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
       	Robot.boxIntake.boxMusicSpeed(g);
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
       	Robot.boxIntake.boxMusicSpeed(g);
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
       	Robot.boxIntake.boxMusicSpeed(f);
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
       	Robot.boxIntake.boxMusicSpeed(f);
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
       	Robot.boxIntake.boxMusicSpeed(e);
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
       	Robot.boxIntake.boxMusicSpeed(e);
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
       	Robot.boxIntake.boxMusicSpeed(d); //half note
       	try {
    			TimeUnit.MILLISECONDS.sleep(750);
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
       	
       	
       	
       	
       	
       	
       	
       	Robot.boxIntake.boxMusicSpeed(a);
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
       	Robot.boxIntake.boxMusicSpeed(a);
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
       	Robot.boxIntake.boxMusicSpeed(g);
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
       	Robot.boxIntake.boxMusicSpeed(g);
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
       	Robot.boxIntake.boxMusicSpeed(f);
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
       	Robot.boxIntake.boxMusicSpeed(f);
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
       	Robot.boxIntake.boxMusicSpeed(e);
       	try {
    			TimeUnit.MILLISECONDS.sleep(750);
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
       	
       	
       	
       	
       	
       	
       	
       	Robot.boxIntake.boxMusicSpeed(a);
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
       	Robot.boxIntake.boxMusicSpeed(a);
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
       	Robot.boxIntake.boxMusicSpeed(g);
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
       	Robot.boxIntake.boxMusicSpeed(g);
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
       	Robot.boxIntake.boxMusicSpeed(f);
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
       	Robot.boxIntake.boxMusicSpeed(f);
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
       	Robot.boxIntake.boxMusicSpeed(e);
       	try {
    			TimeUnit.MILLISECONDS.sleep(750);
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
       	
       	
       	
       	
       	
       	
       	
       	
       	Robot.boxIntake.boxMusicSpeed(d);
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
    	Robot.boxIntake.boxMusicSpeed(d);
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
       	Robot.boxIntake.boxMusicSpeed(a);
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
       	Robot.boxIntake.boxMusicSpeed(a);
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
       	Robot.boxIntake.boxMusicSpeed(b);
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
       	Robot.boxIntake.boxMusicSpeed(b);
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
       	Robot.boxIntake.boxMusicSpeed(a); //half note
       	try {
    			TimeUnit.MILLISECONDS.sleep(750);
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
       	Robot.boxIntake.boxMusicSpeed(g);
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
       	Robot.boxIntake.boxMusicSpeed(g);
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
       	Robot.boxIntake.boxMusicSpeed(f);
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
       	Robot.boxIntake.boxMusicSpeed(f);
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
       	Robot.boxIntake.boxMusicSpeed(e);
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
       	Robot.boxIntake.boxMusicSpeed(e);
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
       	Robot.boxIntake.boxMusicSpeed(d); //half note
       	try {
    			TimeUnit.MILLISECONDS.sleep(750);
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

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.boxIntake.boxStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
