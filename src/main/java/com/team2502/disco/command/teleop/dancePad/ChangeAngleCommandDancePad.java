package com.team2502.disco.command.teleop.dancePad;

import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ChangeAngleCommandDancePad extends Command
{
    private final double voltage;

    public ChangeAngleCommandDancePad(double voltage)
    {
        this.voltage = voltage;
        requires(Robot.SHOOTER_ANGLE);

    }

    @Override
    protected void execute()
    {
        if(Robot.DANCE_PAD_ENABLED) {
            Robot.SHOOTER_ANGLE.driveAngleMotor(voltage);
        }
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

