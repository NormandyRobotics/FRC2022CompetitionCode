// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.cscore.UsbCamera;
//import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.DriveWithEncoders;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.RotateToDegrees;
import frc.robot.commands.Shoot;
import frc.robot.commands.ShootHigh;
import frc.robot.commands.ShootLow;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //Drivetrain declare
  public final static Drivetrain driveTrain = new Drivetrain();
  private final DriveWithJoysticks driveWithJoysticks = new DriveWithJoysticks();
  private final DriveWithEncoders driveWithEncoders = new DriveWithEncoders(0, driveTrain); //specify value?
  private final RotateToDegrees rotateToDegrees = new RotateToDegrees(0, driveTrain); //specify value?
  
  public final static Shooter shooter = new Shooter();
  private final ShootHigh shootHigh = new ShootHigh(shooter);
  private final ShootLow shootLow = new ShootLow(shooter);
  private final Shoot shoot = new Shoot(shooter);
  
  

  //Joystick declare
  public static XboxController  driverJoystick = new XboxController(Constants.DRIVER_JOYSTICK);
  public static XboxController operatorJoystick = new XboxController(Constants.OPERATOR_JOYSTICK);

  //Sendable chooser declare
  SendableChooser<Command> chooser = new SendableChooser<>();
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //addRequirements
    driveWithJoysticks.addRequirements(driveTrain);
    driveWithEncoders.addRequirements(driveTrain);
    rotateToDegrees.addRequirements(driveTrain);

    shootHigh.addRequirements(shooter);
    shootLow.addRequirements(shooter);
    shoot.addRequirements(shooter);



    //set default commands on subsystems
    driveTrain.setDefaultCommand(new DriveWithJoysticks());



    //initalize camera (move to its own subsystem later)
  /*  UsbCamera camera = CameraServer.startAutomaticCapture();
    camera.setResolution(Constants.CAMERA_RES_X, Constants.CAMERA_RES_Y);
  */



    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
 
    return chooser.getSelected();
  }
}
