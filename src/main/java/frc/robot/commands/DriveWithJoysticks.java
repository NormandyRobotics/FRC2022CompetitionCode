// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
//import frc.robot.subsystems.Drivetrain;

public class DriveWithJoysticks extends CommandBase {

    public DriveWithJoysticks() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = (RobotContainer.driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS)*Constants.DRIVETRAINSPEED);
    double rightSpeed = (RobotContainer.driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_Y_AXIS)*Constants.DRIVETRAINSPEED);
    double hSpeed;

    if (RobotContainer.driverJoystick.getRawButton(Constants.DRIVER_SHOULDER_TOP_LEFT))
    {
      hSpeed = -1*Constants.H_DRIVE_SPEED;
    }
    else if (RobotContainer.driverJoystick.getRawButton(Constants.DRIVER_SHOULDER_TOP_RIGHT))
    {
      hSpeed = Constants.H_DRIVE_SPEED;
    }
    else
    {
      hSpeed = 0;
    }

    RobotContainer.driveTrain.driveWithJoysticks(leftSpeed, rightSpeed, hSpeed);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    RobotContainer.driveTrain.driveWithJoysticks(0,0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
