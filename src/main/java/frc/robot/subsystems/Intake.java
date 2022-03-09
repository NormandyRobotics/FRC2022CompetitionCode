// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public DoubleSolenoid intakeExtend;
  
  public Intake() 
  {
      intakeExtend = new DoubleSolenoid(Constants.PCM, PneumaticsModuleType.CTREPCM, Constants.INTAKE_UP_PORT, Constants.INTAKE_DOWN_PORT);
    
    }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
