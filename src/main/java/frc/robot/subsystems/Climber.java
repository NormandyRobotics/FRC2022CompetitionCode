// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  public DoubleSolenoid climberArm;


  public Climber() 
  {
    climberArm = new DoubleSolenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, Constants.CLIMBER_UP_PORT, Constants.CLIMBER_DOWN_PORT);
  }

  public void climberExtend()
  {

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
