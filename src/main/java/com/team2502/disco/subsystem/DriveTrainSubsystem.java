package com.team2502.disco.subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.team2502.disco.Constants;
import com.team2502.disco.RobotMap;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrainSubsystem extends Subsystem
{
    private final DifferentialDrive drive;
    private final SpeedControllerGroup left;
    private final SpeedControllerGroup right;

    private final WPI_TalonSRX frontLeft;
    private final WPI_TalonSRX frontRight;
    private final WPI_TalonSRX backLeft;
    private final WPI_TalonSRX backRight;

    public DriveTrainSubsystem()
    {
        frontLeft = new WPI_TalonSRX(RobotMap.Motor.DRIVE_TRAIN_FRONT_LEFT);
        frontRight = new WPI_TalonSRX(RobotMap.Motor.DRIVE_TRAIN_FRONT_RIGHT);
        backLeft = new WPI_TalonSRX(RobotMap.Motor.DRIVE_TRAIN_BACK_LEFT);
        backRight = new WPI_TalonSRX(RobotMap.Motor.DRIVE_TRAIN_BACK_RIGHT);

        frontLeft.configOpenloopRamp(0.1, Constants.INIT_TIMEOUT);
        frontRight.configOpenloopRamp(0.1, Constants.INIT_TIMEOUT);

        backLeft.configOpenloopRamp(0.1, Constants.INIT_TIMEOUT);
        backRight.configOpenloopRamp(0.1, Constants.INIT_TIMEOUT);

        left = new SpeedControllerGroup(frontLeft, backLeft);
        right = new SpeedControllerGroup(frontRight, backRight);

        drive = new DifferentialDrive(left, right);
    }

    public DifferentialDrive getDrive()
    {
        return drive;
    }

    @Override
    protected void initDefaultCommand()
    {

    }
}
