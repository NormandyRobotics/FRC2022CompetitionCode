// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveWithEncoders extends CommandBase {

  private boolean finished = false;
  int distance;

  public DriveWithEncoders(int d) //distance in inches
  {   
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveTrain);

    distance = d;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.driveTrain.leftDriveEncoder.setSamplesToAverage(Constants.LEFT_DRIVE_ENCODER_SAMPLES);
    RobotContainer.driveTrain.rightDriveEncoder.setSamplesToAverage(Constants.RIGHT_DRIVE_ENCODER_SAMPLES);

    RobotContainer.driveTrain.leftDriveEncoder.setDistancePerPulse(1.0/Constants.ENCODER_PULSE_COUNT*2.0*Math.PI*Constants.WHEEL_RADIUS);
    RobotContainer.driveTrain.rightDriveEncoder.setDistancePerPulse(1.0/Constants.ENCODER_PULSE_COUNT*2.0*Math.PI*Constants.WHEEL_RADIUS);   
    
    RobotContainer.driveTrain.leftDriveEncoder.setMinRate(Constants.ENCODER_MIN_RATE);
    RobotContainer.driveTrain.rightDriveEncoder.setMinRate(Constants.ENCODER_MIN_RATE);

    RobotContainer.driveTrain.leftDriveEncoder.reset();
    RobotContainer.driveTrain.rightDriveEncoder.reset();

    //actual drive code - should this move to execute?
    double error;
    double kP = 1.0; // PD proportionality constant

    while ((RobotContainer.driveTrain.leftDriveEncoder.getDistance() - RobotContainer.driveTrain.rightDriveEncoder.getDistance())/2 < distance)
    {
      error = RobotContainer.driveTrain.leftDriveEncoder.getDistance() - RobotContainer.driveTrain.rightDriveEncoder.getDistance();

      double leftSpeed = Constants.ENCODER_DRIVE_SPEED+kP*error;
      double rightSpeed = Constants.ENCODER_DRIVE_SPEED-kP*error; 
  
       RobotContainer.driveTrain.driveWithEncoders(leftSpeed, rightSpeed);
    }

    finished =true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
