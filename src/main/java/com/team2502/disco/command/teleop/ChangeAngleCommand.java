package com.team2502.disco.command.teleop;

import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ChangeAngleCommand extends Command
{
    private final double voltage;

    public ChangeAngleCommand(double voltage)
    {
        this.voltage = voltage;
        requires(Robot.SHOOTER_ANGLE);

    }

    @Override
    protected void execute()
    {
        Robot.SHOOTER_ANGLE.driveAngleMotor(voltage);
    }

    @Override
    protected void end() {
        Robot.SHOOTER_ANGLE.driveAngleMotor(0);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
