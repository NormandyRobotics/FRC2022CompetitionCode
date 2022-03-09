// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

public class ShootHigh extends CommandBase {
  /** Creates a new ShootHigh. */
  public ShootHigh(Shooter shooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {

    RobotContainer.shooter.shooterEncoder.setSamplesToAverage(Constants.SHOOTER_ENCODER_SAMPLES);
    RobotContainer.shooter.shooterEncoder.setDistancePerPulse(1.0/Constants.SHOOTER_ENCODER_PULSE_COUNT*2.0*Math.PI*Constants.SHOOTER_WHEEL_RADIUS);
    RobotContainer.shooter.shooterEncoder.setMinRate(Constants.SHOOTER_ENCODER_MIN_RATE);
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
   // RobotContainer.shooter.shooterMotor.set()
    RobotContainer.shooter.shooterMotor.getVel

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
