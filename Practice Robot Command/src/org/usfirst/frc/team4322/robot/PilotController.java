package org.usfirst.frc.team4322.robot;

import edu.wpi.first.wpilibj.buttons.Button;

public class PilotController {

	private static PilotController _instance = null;
	private XboxController controller = null;
	public boolean isPilotDriving = true;
	
	/** The Alternate Drive Profile swaps driving sticks
	 * Steering will be left stick X axis
	 * Throttle will be right stick Y axis
	 * Strafing will be right stick X axis
	 */
    
	public static PilotController getInstance()
	{
		if(_instance == null)
		{
			_instance = new PilotController();
			_instance.controller = new XboxController(RobotMap.PILOT);
		}
		return _instance;
	}

	public Button autoButton()
	{
		return controller.x;
	}

	public Button Button0()
	{
		return controller.y;
	}

	public Button Button90()
	{
		return controller.b;
	}

	public Button Button180()
	{
		return controller.a;
	}

	// Get values from left Xbox One controller stick and set to throttle value.
	public double getThrottleStick(){
		
		return controller.leftStick.getY();
		
	}
	
	// Get values from right Xbox One controller stick and set to throttle value.
	public double getSteeringStick(){
		
		return controller.rightStick.getX();
		
	}
}
