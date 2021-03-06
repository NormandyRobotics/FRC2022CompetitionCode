// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ClimberExtend;
import frc.robot.commands.ClimberRetract;
import frc.robot.commands.DriveBackTimed;
import frc.robot.commands.DriveWithEncoders;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.IntakeExtend;
import frc.robot.commands.IntakeOff;
import frc.robot.commands.IntakeOn;
import frc.robot.commands.IntakeRetract;
import frc.robot.commands.RotateToDegrees;
import frc.robot.commands.Shoot;
import frc.robot.commands.ShootHigh;
import frc.robot.commands.ShootLow;
import frc.robot.commands.ShootOff;
import frc.robot.commands.TriggerOff;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //Drivetrain declare

  //Joystick declare
  private final XboxController  driverJoystick = new XboxController(Constants.DRIVER_JOYSTICK);
  private final  XboxController operatorJoystick = new XboxController(Constants.OPERATOR_JOYSTICK);

  public final static Drivetrain driveTrain = new Drivetrain();
  private final DriveWithJoysticks driveWithJoysticks = new DriveWithJoysticks(driveTrain, driverJoystick);
  private final DriveWithEncoders driveWithEncoders = new DriveWithEncoders(0, driveTrain); //specify value?
  private final RotateToDegrees rotateToDegrees = new RotateToDegrees(0, driveTrain); //specify value?

  private final TriggerOff triggerOff = new TriggerOff(shooter);
  
  public final static Shooter shooter = new Shooter();
  private final ShootHigh shootHigh = new ShootHigh(shooter);
  private final ShootLow shootLow = new ShootLow(shooter);
  private final ShootOff shootOff = new ShootOff(shooter);
  private final Shoot shoot = new Shoot(shooter);

  public final  Climber climber = new Climber();

  public final static Intake intake = new Intake();

  private final DriveBackTimed driveBackTimed = new DriveBackTimed(driveTrain);
  //private final DriveBackTimed driveBackTimed;

  
  


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
    shootOff.addRequirements(shooter);
    shoot.addRequirements(shooter);

    //driveBackTimed = new DriveBackTimed(driveTrain);
    //driveBackTimed.addRequirements(driveTrain);

    //set default commands on subsystems
    driveTrain.setDefaultCommand(new DriveWithJoysticks(driveTrain, driverJoystick));
    climber.setDefaultCommand(new ClimberRetract(climber));
   // intake.setDefaultCommand(new IntakeRetract());



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
  private void configureButtonBindings() 
  {
    
    //JoystickButton driverLeft = new JoystickButton(driverJoystick, Constants.DRIVER_LEFT);
    //JoystickButton driverRight = new JoystickButton(driverJoystick, Constants.DRIVER_RIGHT);
    //JoystickButton driverUp = new JoystickButton(driverJoystick, Constants.DRIVER_UP);
    //JoystickButton driverDown = new JoystickButton(driverJoystick, Constants.DRIVER_DOWN);
    //JoystickButton driverShoulderTopLeft = new JoystickButton(driverJoystick, Constants.DRIVER_SHOULDER_TOP_LEFT);
    //JoystickButton driverShoulderTopRight = new JoystickButton(driverJoystick, Constants.DRIVER_SHOULDER_TOP_RIGHT);
    JoystickButton driverShoulderBottomLeft = new JoystickButton(driverJoystick, Constants.DRIVER_SHOULDER_BOTTOM_LEFT);
    JoystickButton driverShoulderBottomRight = new JoystickButton(driverJoystick, Constants.DRIVER_SHOULDER_BOTTOM_RIGHT);
    //JoystickButton driverLeftJoystick = new JoystickButton(driverJoystick, Constants.DRIVER_LEFT_JOYSTICK);
    //JoystickButton driverRightJoystick = new JoystickButton(driverJoystick, Constants.DRIVER_RIGHT_JOYSTICK);

    JoystickButton operatorLeft = new JoystickButton(operatorJoystick, Constants.OPERATOR_LEFT);
    JoystickButton operatorRight = new JoystickButton(operatorJoystick, Constants.OPERATOR_RIGHT);
    JoystickButton operatorUp = new JoystickButton(operatorJoystick, Constants.OPERATOR_UP);
    JoystickButton operatorDown = new JoystickButton(operatorJoystick, Constants.OPERATOR_DOWN);
    JoystickButton operatorShoulderTopLeft = new JoystickButton(operatorJoystick, Constants.OPERATOR_SHOULDER_TOP_LEFT);
    JoystickButton operatorShoulderTopRight = new JoystickButton(operatorJoystick, Constants.OPERATOR_SHOULDER_TOP_RIGHT);
    JoystickButton operatorShoulderBottomLeft = new JoystickButton(operatorJoystick, Constants.OPERATOR_SHOULDER_BOTTOM_LEFT);
    JoystickButton operatorShoulderBottomRight = new JoystickButton(operatorJoystick, Constants.OPERATOR_SHOULDER_BOTTOM_RIGHT);
    JoystickButton operatorMidLeft = new JoystickButton(operatorJoystick, Constants.OPERATOR_MID_LEFT);
    //JoystickButton operatorLeftJoystick = new JoystickButton(operatorJoystick, Constants.OPERATOR_LEFT_JOYSTICK);
    //JoystickButton operatorRightJoystick = new JoystickButton(operatorJoystick, Constants.OPERATOR_RIGHT_JOYSTICK);

    //button command links
    operatorUp.whenPressed(new ShootHigh(shooter)); //set shooter motor to shoot to high goal
    //operatorUp.whenReleased(new ShootOff(shooter)); //turn off shooter motor
    operatorDown.whenPressed(new ShootLow(shooter)); //set shooter motor to shoot to low goal
    //operatorDown.whenReleased(new ShootOff(shooter)); // tuirn off shooter motor
    operatorMidLeft.whenPressed(new ShootOff(shooter));
    operatorShoulderTopLeft.whenPressed(new Shoot(shooter)); //feed balls into shooter while button is held
    operatorShoulderTopRight.whenPressed(new TriggerOff(shooter)); //feed balls into shooter while button is held
    operatorLeft.whenPressed(new IntakeOff()); //turn off intake
    operatorRight.whenPressed(new IntakeOn()); //turn on intake
    operatorShoulderBottomLeft.whenPressed(new IntakeExtend()); //toggle intake position
    operatorShoulderBottomRight.whenPressed(new IntakeRetract()); //toggle climber position

    //driverShoulderTopLeft.whenHeld(new StrafeLeft()); //add strafe left command
    //driverShouldTopRight.whenHeld(new StrafeRight()); //add strafe right command
    driverShoulderBottomLeft.whenPressed(new ClimberExtend(climber));
    driverShoulderBottomRight.whenPressed(new ClimberRetract(climber));
    






  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
 
    //return chooser.getSelected();
    return driveBackTimed;
  }
}
