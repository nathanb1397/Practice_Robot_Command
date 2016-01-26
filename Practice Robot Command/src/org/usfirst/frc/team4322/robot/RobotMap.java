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
	
	public static String LAST_BUILD_TIME = "January 25, 2016 @ 7:30pm";
	public static String CODE_AUTHOR = "Nathan Baugh";
	public static String ROBOT_NAME = "null";
		
	// Set Joystick Ports for Drive Station
	public static int PILOT = 0;
		
	// Set CAN_Jaguar Ports
	public static int CAN_Jaguar_1 = 10;
	public static int CAN_Jaguar_2 = 11;
	
	// Set Talon (pwm)
	public static int TALON_1 = 0;
	public static int TALON_2 = 1;
		
	// Drive base Variables
	public static double POWER_LIMIT = 0.8;
		
	// RangeFinder analog port
	public static int RANGE_FINDER_PORT = 0;
		
	// Gyro analog port
	public static int GYRO_PORT = 1;
	public static int GYRO_TEMP_PORT = 2;
	
	// Command Timeout Values
	public static double Turn90Timeout = 5;
	
	// Command Specific Values (such as PID values)
	public static double Turn90pVal = 0.005;
	public static double Turn90iVal = 0;
	public static double Turn90dVal = 0;
}
