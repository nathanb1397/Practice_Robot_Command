package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Interrup extends Command {


	public Interrup()
	{
		// Make ArcadeDrive require the DriveBase
		// Robot.driveBase refers to the instance of DriveBase created in Robot.java during init.
		requires(Robot.driveBase);
		setInterruptible(false);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
	}
	
	protected boolean isFinished()
	{
		return true;
	}

	protected void end() {
		// Set ArcadeDrive values to '0' in order to prepare for the next command/operation.
		// If these were not set to '0', ArcadeDrive would continue running with the last values it received from the controller.
		Robot.driveBase.drive(0, 0, 0);
	}
	
	protected void interrupted()
	{
		// Cause this command to 'end' when it's interrupted
		end();
	}

}
