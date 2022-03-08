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


	//DIO
    public static final int LEFT_ENCODER_A = 0;
    public static final int LEFT_ENCODER_B = 1;
    public static final int RIGHT_ENCODER_A = 2;
    public static final int RIGHT_ENCODER_B = 3;
	public static final int H_ENCODER_A = 4;
    public static final int H_ENCODER_B = 5;

	//Joystick button/axis maps
	public static final int DRIVER_JOYSTICK = 0;
	public static final int DRIVER_JOYSTICK_LEFT_Y_AXIS = 1;
	public static final int DRIVER_JOYSTICK_RIGHT_Y_AXIS = 3;

	public static final int DRIVER_SHOULDER_TOP_LEFT = 0;
	public static final int DRIVER_SHOULDER_TOP_RIGHT = 0;



	public static final int OPERATOR_JOYSTICK = 1;

	//Drivetrain constants
	public static final double DRIVETRAINSPEED = 0.75;  //max speed at 75%
	public static final double H_DRIVE_SPEED = 0.50; //h drive speed at 50%

	//Camera constants
	public static final int CAMERA_RES_X = 320;
	public static final int CAMERA_RES_Y = 240;

	//Encoder Constants
	public static final int LEFT_DRIVE_ENCODER_SAMPLES = 5;
	public static final int RIGHT_DRIVE_ENCODER_SAMPLES = 5;
	public static final int H_DRIVE_ENCODER_SAMPLES = 5;
    public static double ENCODER_DRIVE_SPEED = 0.5; //set auto drive speed by encoders to 50%












}
