// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  //change speed controller types as necessary
  CANSparkMax leftDriveMotor;
  CANSparkMax rightDriveMotor;
  CANSparkMax hDriveMotor;

  
  Encoder leftDriveEncoder;
  Encoder rightDriveEncoder;
  Encoder hDriveEncoder;


   DifferentialDrive drive;
  

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftDriveMotor = new CANSparkMax(Constants.LEFT_MOTOR, MotorType.kBrushed);
    leftDriveMotor.setInverted(false);
    leftDriveEncoder = new Encoder(Constants.LEFT_ENCODER_A, Constants.LEFT_ENCODER_B);

    rightDriveMotor = new CANSparkMax(Constants.RIGHT_MOTOR, MotorType.kBrushed);
    rightDriveMotor.setInverted(false);
    rightDriveEncoder = new Encoder(Constants.RIGHT_ENCODER_A, Constants.RIGHT_ENCODER_B);

    hDriveMotor = new CANSparkMax(Constants.H_MOTOR, MotorType.kBrushed);
    hDriveMotor.setInverted(false);
    hDriveEncoder = new Encoder(Constants.H_ENCODER_A, Constants.H_ENCODER_B);




    drive = new DifferentialDrive(leftDriveMotor, rightDriveMotor);
    



  }

  public void driveWithJoysticks(XboxController controller)
  {
    leftDriveMotor.set(controller.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS)*Constants.DRIVETRAINSPEED);
    rightDriveMotor.set(controller.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_Y_AXIS)*Constants.DRIVETRAINSPEED);

    //activate H Drive strafe using top shoulder buttons. Off if no button pressed
    if (controller.getRawButton(Constants.DRIVER_SHOULDER_TOP_LEFT))
    {
      hDriveMotor.set(-1*Constants.H_DRIVE_SPEED);
    }
    else if (controller.getRawButton(Constants.DRIVER_SHOULDER_TOP_RIGHT))
    {
      hDriveMotor.set(Constants.H_DRIVE_SPEED);
    }
    else
    {
      hDriveMotor.set(0);
    }

  }

  public void driveWithEncoders(int distance)
  {
    double error;
    /* where do we initialize the encoders?  */
    leftDriveEncoder.reset();
    rightDriveEncoder.reset();

    //leftDriveEncoder.setSamplesToAverage(Constants.LEFT_DRIVE_ENCODER_SAMPLES);
    //rightDriveEncoder.setSamplesToAverage(Constants.RIGHT_DRIVE_ENCODER_SAMPLES);
    
    //read current left and right encoder values
    //set left and right motors to constant drive speed
    //drive until distance is met


    while(((leftDriveEncoder.getDistance() + rightDriveEncoder.getDistance())/2) < distance)
    {
      error = leftDriveEncoder.getDistance() - rightDriveEncoder.getDistance();
      double kP = 1; //proportionality constant for PD control

      //may need to change both values to + kP*error based on motor inversion
      drive.tankDrive(Constants.ENCODER_DRIVE_SPEED+kP*error, Constants.ENCODER_DRIVE_SPEED - kP*error);

    }

    leftDriveMotor.set(0);
    rightDriveMotor.set(0);
    

  }

  public void driveWithGyros(int degrees)
  {
    
    //reset gyro
    //read current gyro position
    //tank drive wheels opposite directions until desired direction acquired

      
     // drive.tankDrive(Constants.ENCODER_DRIVE_SPEED+kP*error, Constants.ENCODER_DRIVE_SPEED - kP*error);

    

    leftDriveMotor.set(0);
    rightDriveMotor.set(0);
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
    drive.stopMotor();
  }
}
