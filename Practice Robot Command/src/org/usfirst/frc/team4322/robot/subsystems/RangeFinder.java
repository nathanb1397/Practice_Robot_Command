package org.usfirst.frc.team4322.robot.subsystems;

import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RangeFinder extends Subsystem
{	
	private final double IN_TO_CM_CONVERSION = 2.54; //Converts reported inches to cm
    private final double IN_TO_FT_CONVERSION = 1 / 12; //Converts reported inches to ft
    private final double MM_TO_IN_CONVERSION = 1 / 25.4; //Converts reported millimeters to inches
	
	private AnalogInput rangeFinder;

	public RangeFinder()
	{
		super();
		rangeFinder = new AnalogInput(RobotMap.RANGE_FINDER_PORT);
	}

	// Returns raw voltage from sensor
	public double GetVoltage()
	{
		return rangeFinder.getVoltage();
	}
	
	// Initial range finding
    // Finds voltage being supplied to the sensor by dividing the input voltage from the PDP by 0.4 (voltage range needed for the sensor)
    // Divides sensor voltage by the scaling factor provided for sensor
    // Returns range in millimeters
    public double GetRangeInMillimeters()
    {
        double range; //distance, to be determined
        double analogBreakoutVoltage = DriverStation.getInstance().getBatteryVoltage() * 0.4; //supplied voltage
        double scaling_factor = analogBreakoutVoltage / 5120; //the supplied voltage / vpi

        //determine the raw voltage
        range = rangeFinder.getVoltage();
        //divide by scaling factor to get distance
        range = (range / scaling_factor);
        return range;
    }
    
    // Returns range in Centimeters
    public double GetRangeInCM()
    {
        double range;
        range = GetRangeInInches();
        range = range * IN_TO_CM_CONVERSION;
        return range;
    }
    
    // Returns range in Inches
    public double GetRangeInInches()
    {
    	double millimeters = GetRangeInMillimeters();
    	double inches = millimeters * MM_TO_IN_CONVERSION;
    	return inches;
    }
    
    // Returns range in Feet
    public double GetRangeInFT()
    {
        double range;
        range = GetRangeInInches();
        range = range * IN_TO_FT_CONVERSION;
        return range;
    }
    
    // Do not delete this command, even if there is no default command to be run by this subsystem
	@Override
	protected void initDefaultCommand()
	{
		
	}
	
	public void log()
	{
		SmartDashboard.putNumber("RangeFinder Voltage: ", this.GetVoltage());
	}

	
}
