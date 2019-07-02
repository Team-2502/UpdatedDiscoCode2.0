package com.team2502.disco.command.teleop;

import com.team2502.disco.OI;
import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickDriveCommand extends Command
{
    public JoystickDriveCommand()
    {
        requires(Robot.DRIVE_TRAIN);
    }

    @Override
    protected void execute()
    {
        Robot.DRIVE_TRAIN.getDrive().tankDrive(-OI.JOYSTICK_DRIVE_LEFT.getY(), OI.JOYSTICK_DRIVE_RIGHT.getY(),true);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}