package org.usfirst.frc.team4322.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	// Create a String with the Last Build Time of Code
	
	public static String LAST_BUILD_TIME = "January 2, 2016; 1:30pm";
	public static String CODE_AUTHOR = "Mark McGary";
	public static String ROBOT_NAME = "Not the droids you're looking for.";
		
	// Set Joystick Ports for Drive Station
	public static int PILOT = 0;
		
	// Set CAN_Jaguar Ports
	public static int CAN_Jaguar_1 = 10;
	public static int CAN_Jaguar_2 = 11;
		
	// Drive base Variables
	public static double POWER_LIMIT = 0.8;
		
	// RangeFinder analog port
	public static int RANGE_FINDER_PORT = 0;
		
	// Gyro analog port
	public static int GYRO_PORT = 1;
	public static int GYRO_TEMP_PORT = 2;
}
