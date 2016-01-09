package org.usfirst.frc.team4322.robot;

import edu.wpi.first.wpilibj.buttons.Button;

public class PilotController
{
	private static PilotController _instance = null;
	private XboxController controller = null;
    
	public static PilotController getInstance()
	{
		if(_instance == null)
		{
			_instance = new PilotController();
			_instance.controller = new XboxController(RobotMap.PILOT);
		}
		return _instance;
	}
	
	public Button InterruptButton()
	{
		return controller.a;
	}

	public Button Turn90Button()
	{
		return controller.b;
	}

	public Button DriveForwardToDistanceButton()
	{
		return controller.x;
	}

	// Get values from left Xbox One controller stick and set to throttle value.
	public double getThrottleStick()
	{	
		return controller.leftStick.getY();	
	}
	
	// Get values from right Xbox One controller stick and set to throttle value.
	public double getSteeringStick()
	{
		return controller.rightStick.getX();	
	}
}
