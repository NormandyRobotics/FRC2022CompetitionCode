// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

	//CAN addresses
    public static final int LEFT_MOTOR = 2;
    public static final int RIGHT_MOTOR = 3;
    public static final int H_MOTOR = 4;
	public static final int SHOOTER_MOTOR = 5;
	public static final int FEED_MOTOR = 6;
	public static final int INTAKE_MOTOR = 7;
	public static final int PCM = 1;
	public static final int PDP = 9;


	//DIO
    public static final int LEFT_ENCODER_A = 0;
    public static final int LEFT_ENCODER_B = 1;
    public static final int RIGHT_ENCODER_A = 2;
    public static final int RIGHT_ENCODER_B = 3;
	public static final int H_ENCODER_A = 4;
    public static final int H_ENCODER_B = 5;
	public static final int SHOOTER_ENCODER_A = 6;
	public static final int SHOOTER_ENCODER_B = 7;

	//Joystick button/axis maps
	public static final int DRIVER_JOYSTICK = 0;
	public static final int DRIVER_JOYSTICK_LEFT_Y_AXIS = 1;
	public static final int DRIVER_JOYSTICK_RIGHT_Y_AXIS = 3;

	public static final int DRIVER_SHOULDER_TOP_LEFT = 5;
	public static final int DRIVER_SHOULDER_TOP_RIGHT = 6;
	public static final int DRIVER_LEFT = 1;
	public static final int DRIVER_RIGHT = 3;
	public static final int DRIVER_UP = 4;
	public static final int DRIVER_DOWN = 2;
	public static final int DRIVER_SHOULDER_BOTTOM_LEFT = 7;
	public static final int DRIVER_SHOULDER_BOTTOM_RIGHT = 8;
	public static final int DRIVER_LEFT_JOYSTICK = 9;
	public static final int DRIVER_RIGHT_JOYSTICK = 10;


	public static final int OPERATOR_JOYSTICK = 1;
	public static final int OPERATOR_JOYSTICK_LEFT_Y_AXIS = 1;
	public static final int OPERATOR_JOYSTICK_RIGHT_Y_AXIS = 3;

	public static final int OPERATOR_SHOULDER_TOP_LEFT = 5;
	public static final int OPERATOR_SHOULDER_TOP_RIGHT = 6;
	public static final int OPERATOR_LEFT = 1;
	public static final int OPERATOR_RIGHT = 3;
	public static final int OPERATOR_UP = 4;
	public static final int OPERATOR_DOWN = 2;
	public static final int OPERATOR_SHOULDER_BOTTOM_LEFT = 7;
	public static final int OPERATOR_SHOULDER_BOTTOM_RIGHT = 8;
	public static final int OPERATOR_LEFT_JOYSTICK = 9;
	public static final int OPERATOR_RIGHT_JOYSTICK = 10;



	//Drivetrain constants
	public static final double DRIVETRAINSPEED = 1;  //max speed at 100%
	public static final double H_DRIVE_SPEED = 0.75; //h drive speed at 75%

	//Camera constants
	public static final int CAMERA_RES_X = 320;
	public static final int CAMERA_RES_Y = 240;

	//Encoder Constants
	public static final int LEFT_DRIVE_ENCODER_SAMPLES = 5;
	public static final int RIGHT_DRIVE_ENCODER_SAMPLES = 5;
	public static final int H_DRIVE_ENCODER_SAMPLES = 5;
	public static final int SHOOTER_ENCODER_SAMPLES = 5;
	public static final double ENCODER_MIN_RATE = 10; //tweek this value
	public static final double SHOOTER_ENCODER_MIN_RATE = 10;
    public static double ENCODER_DRIVE_SPEED = 0.5; //set auto drive speed by encoders to 50%
	public static int ENCODER_PULSE_COUNT = 2048;
	public static int SHOOTER_ENCODER_PULSE_COUNT = 256;

	
	//Shooter Constants
	public static final int SHOOT_HIGH_RPM = 5500;
	public static final int SHOOT_LOW_RPM = 3000;
    public static final double SHOOTER_HIGH_SETPOINT = 0;
	public static final double SHOUTER_LOW_SETPOINT = 0;
	public static final double HIGH_SHOT_PERCENT = 1.0;
	public static final double LOW_SHOT_PERCENT = 0.5;

	//Climber Constants
	public static final int CLIMBER_UP_PORT = 1;
	public static final int CLIMBER_DOWN_PORT = 0;

	//Intake Constants
	public static final int INTAKE_UP_PORT = 2;
	public static final int INTAKE_DOWN_PORT = 3;



	//robot specs
	public static int WHEEL_RADIUS = 4;
	public static int SHOOTER_WHEEL_RADIUS = 2;
	public static double WHEEL_ROTATIONS_PER_TURN = 1.4375; //based on 23" robot turn diameter, 8" wheel diameter
	public static double INCHES_PER_TURN = 36.11; //wheel rotations * 25.12 in wheel circumference
	public static double INCHES_PER_DEGREE = 0.1; //approx 36.11/360

















}
