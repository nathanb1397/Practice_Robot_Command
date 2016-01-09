package org.usfirst.frc.team4322.robot.subsystems;

import org.usfirst.frc.team4322.robot.*;
import org.usfirst.frc.team4322.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem {

	// Define CANJaguars
	private CANJaguar Jaguar_1;
	private CANJaguar Jaguar_2;
	
	// Setup RobotDrive from WPILIB
	private RobotDrive robotDrive;
	
	public DriveBase()
	{
		super();
		
		// Create instances of CANJaguar for each Jaguar
		Jaguar_1 = new CANJaguar(RobotMap.CAN_Jaguar_1);
		Jaguar_2 = new CANJaguar(RobotMap.CAN_Jaguar_2);
		
		// Create instance of robotDrive
		robotDrive = new RobotDrive(Jaguar_1, Jaguar_2);
		
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new ArcadeDrive());
	}
	
	public void drive(double moveValue, double rotateValue, double powerLimit)
	{
		robotDrive.arcadeDrive(moveValue * powerLimit, rotateValue * powerLimit);
	}

}
