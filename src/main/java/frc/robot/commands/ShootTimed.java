// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShootTimed extends CommandBase {
  /** Creates a new ShootTimed. */
  Shooter shooter;
  Timer timer = new Timer();
  private boolean finish = false;

  public ShootTimed(Shooter st) {
    shooter = st;
    addRequirements(shooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    double feedSpeed = 0;

    while (timer.get() < 3)
    {
      shooter.shooterMotor.set(1.0);

      if (timer.get() >1.5)
      {
        feedSpeed = 1.0;
      }
      shooter.feedMotor.set(VictorSPXControlMode.PercentOutput,feedSpeed);
    }

    shooter.feedMotor.set(VictorSPXControlMode.PercentOutput, 0);
    finish = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
