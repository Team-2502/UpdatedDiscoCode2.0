package com.team2502.disco.command.teleop;

import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class RunShooterCommand extends Command
{
    public RunShooterCommand()
    {
        requires(Robot.SHOOTER_FLYWHEEL);

    }

    @Override
    protected void execute()
    {
        Robot.SHOOTER_FLYWHEEL.driveShooter(1);
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
