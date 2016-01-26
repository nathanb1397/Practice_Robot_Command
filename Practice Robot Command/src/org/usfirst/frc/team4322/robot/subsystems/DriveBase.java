package org.usfirst.frc.team4322.robot.subsystems;

import org.usfirst.frc.team4322.robot.*;
import org.usfirst.frc.team4322.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends Subsystem {

	// Define Talons
	private Talon Talon_1_left;
	private Talon Talon_2_right;
	
	// Setup RobotDrive from WPILIB
	private RobotDrive robotDrive;
	
	public DriveBase()
	{
		super();
		
		// Create instances of Talon for each Talon
		Talon_1_left = new Talon(RobotMap.TALON_1);
		Talon_2_right = new Talon(RobotMap.TALON_2);
		
		// Invert Motors
		Talon_1_left.setInverted(true);
		Talon_2_right.setInverted(true);
		
		// Create instance of robotDrive
		robotDrive = new RobotDrive(Talon_1_left, Talon_2_right);
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new ArcadeDrive());
	}
	
	// ArcadeDrive controller
	public void drive(double moveValue, double rotateValue, double powerLimit)
	{
		robotDrive.arcadeDrive(moveValue * powerLimit, rotateValue * powerLimit);
	}
	
	// Command run by Robot.java to add values to SmartDashboard and/or RobotLogger
	public void log()
	{	
		// Writes current PilotController Joystick values to SmartDashboard
		// Specifically Throttle and Steering Sticks
		SmartDashboard.putNumber("Throttle Stick: ", PilotController.getInstance().getThrottleStick());
		SmartDashboard.putNumber("Steering Stick: ", PilotController.getInstance().getSteeringStick());
	}
	
	public void logOnce()
	{
		// Writes and gets power limit from SmartDashboard
		SmartDashboard.putNumber("Arcade Drive Power Limit: ", RobotMap.POWER_LIMIT);
	}

}
