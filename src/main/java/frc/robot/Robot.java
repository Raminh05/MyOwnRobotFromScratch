// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  // right motors
  private final WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(13);
  private final WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(10);

  // left motors
  private final WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(20);
  private final WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(12);

  // Speed controller groups -- Controlling all motors on one side at once
  private final SpeedControllerGroup rightSpeedGroup = new SpeedControllerGroup(rightMotor1, rightMotor2);
  private final SpeedControllerGroup leftSpeedGroup = new SpeedControllerGroup(leftMotor1, leftMotor2);

  // Drivetrain
  DifferentialDrive drivetrain = new DifferentialDrive(rightSpeedGroup, leftSpeedGroup);

  // Joystick
  Joystick stick = new Joystick(0);
  
  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    // Tells arcadeDrive to tell receive controller inputs and sends that to the drivetrain
    drivetrain.arcadeDrive(stick.getY(), stick.getZ());

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
