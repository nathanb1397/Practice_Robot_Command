package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardToDistance extends Command {
	
	public DriveForwardToDistance()
	{
		// Make DriveForwardToDistance require the DriveBase
		// Robot.driveBase refers to the instance of DriveBase created in Robot.java during init.
		requires(Robot.driveBase);
		requires(Robot.rangeFinder);
	}

	@Override
	protected void initialize()
	{
		
	}

	@Override
	protected void execute()
	{
		if(Robot.rangeFinder.GetRangeInInches() < 36)
		{
			Robot.driveBase.drive(0.5, 0, 0);
		}
	}

	@Override
	protected boolean isFinished()
	{
		if(Robot.rangeFinder.GetRangeInInches() <= 36)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	protected void end()
	{
		Robot.driveBase.drive(0, 0, 0);
	}

	@Override
	protected void interrupted()
	{
		end();
	}
}
