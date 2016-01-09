package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotate90 extends Command {
	
	// Define PID Controller
	private PIDController pid;
	
	// Define 'setpoint'
	// This value does not need to be in RobotMap as it is unique to this command and will not be changed
	private final double setpoint = 90;
	
	private final double Turn90pVal = RobotMap.Turn90pVal;
	private final double Turn90iVal = RobotMap.Turn90iVal;
	private final double Turn90dVal = RobotMap.Turn90dVal;

	public Rotate90()
	{
		super(RobotMap.Turn90Timeout);
		requires(Robot.driveBase);
		requires(Robot.gyro);
		pid = new PIDController(Turn90pVal, Turn90iVal, Turn90dVal, new PIDSource()
		{
			@Override
			public void setPIDSourceType(PIDSourceType pidSource)
			{
			}
			@Override
			public double pidGet()
			{
				return Robot.gyro.getGyroAngle();
			}
			
			@Override
			public PIDSourceType getPIDSourceType()
			{
				return null;
			}
		}, new PIDOutput(){
			@Override
			public void pidWrite(double output) {
				Robot.driveBase.drive(0, output, RobotMap.POWER_LIMIT);
			}
		});
		pid.setSetpoint(setpoint);
	}

	protected void initialize()
	{
		Robot.gyro.resetGyro();
		pid.reset();
		pid.enable();
	}

	// This will be run 50x a second until this command is terminated
	protected void execute()
	{
		// PID controller should already be running
		// Output PID values to SmartDashboard
		SmartDashboard.putNumber("PID Error: ", pid.getError());
		SmartDashboard.putBoolean("PID is onTarget: ", pid.onTarget());
	}

	protected boolean isFinished()
	{
		if(isTimedOut() || pid.onTarget())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	protected void end()
	{
		pid.disable();
		Robot.driveBase.drive(0, 0, 0);
	}

	protected void interrupted()
	{
		end();
	}
}
