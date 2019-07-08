package com.team2502.disco.command.teleop.dancePad;

import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class RunShooterCommandDancePad extends Command
{
    public RunShooterCommandDancePad()
    {
        requires(Robot.SHOOTER_FLYWHEEL);

    }

    @Override
    protected void execute()
    {
        if(Robot.DANCE_PAD_ENABLED) {
            Robot.SHOOTER_FLYWHEEL.driveShooter(1);
        }
    }


    @Override
    protected void end() {
        Robot.SHOOTER_FLYWHEEL.driveShooter(0);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
