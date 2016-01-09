package org.usfirst.frc.team4322.robot.subsystems;

import org.usfirst.frc.team4322.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gyro extends Subsystem {
	
	// FRC Plugins update (1/8/16) changed Gyro to be AnalogGyro
	private AnalogGyro gyro;

	public Gyro()
	{
		super();
		gyro = new AnalogGyro(RobotMap.GYRO_PORT);
	}
	
	// Resets gyro angle when run
	public void resetGyro()
	{
		gyro.reset();
	}
		
	// Returns current gyro angle as double
	public double getGyroAngle()
	{
		double angle = gyro.getAngle();
		return angle;
	}
		
	// Returns current absolute gyro angle in 360 degree intervals
	public double getGyro360()
	{
		double gyro360 = Math.abs(this.getGyroAngle());
		gyro360 = gyro360 % 360;
		return gyro360;
	}
	
	// Do not delete this command, even if there is no default command to be run by this subsystem
	@Override
	protected void initDefaultCommand()
	{
		
	}
	
	// Command run by Robot.java to add values to SmartDashboard and/or RobotLogger
	public void log()
	{
		// Writes current Gyro angle values to SmartDashboard
		SmartDashboard.putNumber("Current Gyro Angle: ", this.getGyroAngle());
		SmartDashboard.putNumber("Current Absolute Gyro Angle (360°): ", this.getGyro360());
	}

}
