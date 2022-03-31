// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class DriveWithJoysticks extends CommandBase {

  private final Drivetrain m_driveTrain;
  private final XboxController m_driverJoystick;

  public DriveWithJoysticks(Drivetrain driveTrain, XboxController driverJoystick) {
    m_driveTrain = driveTrain;
    m_driverJoystick = driverJoystick;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = m_driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS) * Constants.DRIVETRAINSPEED;
    // double leftSpeed =
    // (RobotContainer.driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS)*Constants.DRIVETRAINSPEED);
    double rightSpeed = m_driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_Y_AXIS) * Constants.DRIVETRAINSPEED;
    // double rightSpeed =
    // (RobotContainer.driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_Y_AXIS)*Constants.DRIVETRAINSPEED);
    double hSpeed;

    if (m_driverJoystick.getRawButton(Constants.DRIVER_SHOULDER_TOP_RIGHT)) {
      hSpeed = -1 * Constants.H_DRIVE_SPEED;
    } else if (m_driverJoystick.getRawButton(Constants.DRIVER_SHOULDER_TOP_LEFT)) {
      hSpeed = Constants.H_DRIVE_SPEED;
    } else {
      hSpeed = 0;
    }

    RobotContainer.driveTrain.driveWithJoysticks(leftSpeed, rightSpeed, hSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveTrain.driveWithJoysticks(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
