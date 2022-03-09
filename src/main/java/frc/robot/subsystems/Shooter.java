// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  public CANSparkMax shooterMotor;
  public Encoder shooterEncoder;
  VictorSPX feedMotor;
  

  

  public Shooter() 
  {
    shooterMotor = new CANSparkMax(Constants.SHOOTER_MOTOR, MotorType.kBrushed);
    shooterMotor.setInverted(false);
    shooterEncoder = new Encoder(Constants.SHOOTER_ENCODER_A, Constants.SHOOTER_ENCODER_B);

    feedMotor = new VictorSPX(Constants.FEED_MOTOR);


  }

  public void shoot(double shootSpeed)
  {
    feedMotor.set(ControlMode.PercentOutput, shootSpeed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
