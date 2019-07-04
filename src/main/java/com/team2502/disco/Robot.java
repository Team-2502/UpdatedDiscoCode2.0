/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team2502.disco;

import com.team2502.disco.subsystem.DiscPusherSubsystem;
import com.team2502.disco.subsystem.DriveTrainSubsystem;
import com.team2502.disco.subsystem.FlywheelSubsystem;
import com.team2502.disco.subsystem.ShooterAngleSubsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveTrainSubsystem DRIVE_TRAIN;
  public static FlywheelSubsystem SHOOTER_FLYWHEEL;
  public static ShooterAngleSubsystem SHOOTER_ANGLE;
  public static DiscPusherSubsystem DISC_PUSHER;

  public static Compressor COMPRESSOR;

  public static boolean DANCE_PAD_CONTROLS_ENABLED;

  public static SendableChooser<Boolean> HIDChooser;

  public static OI OI;


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
      DRIVE_TRAIN = new DriveTrainSubsystem();
      SHOOTER_FLYWHEEL = new FlywheelSubsystem();
      SHOOTER_ANGLE = new ShooterAngleSubsystem();
      DISC_PUSHER = new DiscPusherSubsystem();

      COMPRESSOR = new Compressor();
      COMPRESSOR.setClosedLoopControl(true);

      HIDChooser = new SendableChooser<>();
      HIDChooser.setDefaultOption("Joysticks", false);
      HIDChooser.addOption("Dance Pad", true);
      SmartDashboard.putData("teleop mode:", HIDChooser);

      OI = new OI();

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    DashboardData.update();
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit(){

      DANCE_PAD_CONTROLS_ENABLED = (Boolean) HIDChooser.getSelected();

      if(DANCE_PAD_CONTROLS_ENABLED){
          OI.DancePadInit();
      }
      else{
          OI.JoystickInit();
      }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
      DashboardData.update();
      Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
