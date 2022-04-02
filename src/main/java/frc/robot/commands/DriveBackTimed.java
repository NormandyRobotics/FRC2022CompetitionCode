// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveBackTimed extends CommandBase {

  Drivetrain driveTrain;
  Timer timer= new Timer();
  private boolean finish = false;
  /** Creates a new DriveBackTimed. */
  public DriveBackTimed(Drivetrain dt) {
    driveTrain = dt;
    addRequirements(driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    double leftDrive;
    //double rightDrive;
    timer.reset();
    timer.start();
    while(timer.get() <=Constants.AUTO_DRIVEBACK)
    {
     /* 
      if(timer.get()<3)
      {
        leftDrive = 0.75;
      }
      else
      {
        leftDrive = -0.75;
      }
      */
      driveTrain.leftDriveMotor.set(0.75);
      driveTrain.rightDriveMotor.set(0.75);

    }

    finish = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    driveTrain.leftDriveMotor.set(0);
    driveTrain.rightDriveMotor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
