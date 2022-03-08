// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  //change speed controller types as necessary
  CANSparkMax leftDriveMotor;
  CANSparkMax rightDriveMotor;
  CANSparkMax hDriveMotor;

  
  public Encoder leftDriveEncoder;
  public Encoder rightDriveEncoder;
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

  public void driveWithJoysticks(double leftSpeed, double rightSpeed, double hSpeed)
  {
    drive.tankDrive(leftSpeed, rightSpeed);
    hDriveMotor.set(hSpeed);
  }


  public void driveWithEncoders(double leftSpeed, double rightSpeed)
  {
    drive.tankDrive(leftSpeed, rightSpeed);
    
  }

  public void rotateToDegrees(double leftSpeed, double rightSpeed)
  {
    drive.tankDrive(leftSpeed, rightSpeed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
    drive.stopMotor();
  }
}
