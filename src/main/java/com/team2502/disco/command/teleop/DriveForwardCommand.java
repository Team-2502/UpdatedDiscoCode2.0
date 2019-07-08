package com.team2502.disco.command.teleop;

import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

import java.sql.Time;

public class DriveForwardCommand extends Command
{
    public DriveForwardCommand()
    {
        requires(Robot.DRIVE_TRAIN);
    }

    @Override
    protected void execute()
    {
        Robot.DRIVE_TRAIN.left.set(0.5);
        Robot.DRIVE_TRAIN.right.set(0.5);
    }

    @Override
    protected void end(){
        Robot.DRIVE_TRAIN.left.stopMotor();
        Robot.DRIVE_TRAIN.right.stopMotor();
    }

    @Override
    protected boolean isFinished()
    {
        if (timeSinceInitialized() > 0.35){
            return true;
        }
        return false;
    }
}
