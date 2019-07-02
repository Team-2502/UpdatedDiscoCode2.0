package com.team2502.disco.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.team2502.disco.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterAngleSubsystem extends Subsystem
{
    private final WPI_TalonSRX shooterAngle;

    public ShooterAngleSubsystem()
    {
        shooterAngle = new WPI_TalonSRX(RobotMap.Motor.SHOOTER_ANGLE);
    }

    public void driveAngleMotor(double voltage)
    {
        DriverStation.reportWarning("angle", false);
        shooterAngle.set(ControlMode.PercentOutput, voltage);
    }

    @Override
    protected void initDefaultCommand()
    {
    }
}
