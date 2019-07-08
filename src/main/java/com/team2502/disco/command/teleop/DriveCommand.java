package com.team2502.disco.command.teleop;

import com.team2502.disco.OI;
import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveCommand extends Command
{
    private final DifferentialDrive drive;

    public DriveCommand()
    {
        requires(Robot.DRIVE_TRAIN);
        drive = new DifferentialDrive(Robot.DRIVE_TRAIN.left, Robot.DRIVE_TRAIN.right);
    }

    @Override
    protected void execute()
    {
        if(Robot.DANCE_PAD_ENABLED){
            drive.tankDrive(Robot.DRIVE_TRAIN.dancePadSpeedVectorLeft,Robot.DRIVE_TRAIN.dancePadSpeedVectorRight,true);
        }
        else{
            drive.tankDrive(-OI.JOYSTICK_DRIVE_LEFT.getY(), OI.JOYSTICK_DRIVE_RIGHT.getY(),true);
        }
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}