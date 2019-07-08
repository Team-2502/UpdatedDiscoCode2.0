package com.team2502.disco.command.teleop.dancePad;

import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.Command;

import java.sql.Time;

public class TurnLeftCommand extends Command
{
    public TurnLeftCommand() { }

    @Override
    protected void initialize()
    {
        Robot.DRIVE_TRAIN.dancePadSpeedVectorLeft += -0.4;
        Robot.DRIVE_TRAIN.dancePadSpeedVectorRight += 0.6;
    }

    @Override
    protected void end(){
        Robot.DRIVE_TRAIN.dancePadSpeedVectorRight -= 0.6;
        Robot.DRIVE_TRAIN.dancePadSpeedVectorLeft -= -0.4;
    }

    @Override
    protected boolean isFinished()
    {
        if (timeSinceInitialized() > 0.5){
            return true;
        }
        return false;
    }
}
