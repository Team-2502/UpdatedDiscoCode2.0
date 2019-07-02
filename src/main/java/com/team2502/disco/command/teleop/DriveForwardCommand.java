package com.team2502.disco.command.teleop;

import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class DriveForwardCommand extends TimedCommand
{
    public DriveForwardCommand(double timeout)
    {
        super(timeout);
        requires(Robot.DRIVE_TRAIN);
    }

    @Override
    protected void execute()
    {
        Robot.DRIVE_TRAIN.getDrive().tankDrive(0.5, 0.5, true);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
