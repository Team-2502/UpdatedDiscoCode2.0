package com.team2502.disco.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.team2502.disco.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FlywheelSubsystem extends Subsystem
{
    private final WPI_TalonSRX shooterFront;
    private final WPI_TalonSRX shooterBack;

    public FlywheelSubsystem()
    {
        shooterFront = new WPI_TalonSRX(RobotMap.Motor.SHOOTER_FRONT);
        shooterBack = new WPI_TalonSRX(RobotMap.Motor.SHOOTER_BACK);
    }

    public void driveShooter(double voltage)
    {
        shooterFront.set(ControlMode.PercentOutput, voltage);
        shooterBack.set(ControlMode.PercentOutput, voltage);
    }

    @Override
    protected void initDefaultCommand()
    {
        // no defualt command
    }
}
