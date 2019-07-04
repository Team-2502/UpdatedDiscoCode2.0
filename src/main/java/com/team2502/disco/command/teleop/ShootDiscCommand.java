package com.team2502.disco.command.teleop;

import com.team2502.disco.OI;
import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ShootDiscCommand extends CommandGroup
{
    public ShootDiscCommand() {
        if(OI.SPIN_UP_FLYWHEEL.get()){
            addSequential(new LambdaCommand(Robot.DISC_PUSHER, Robot.DISC_PUSHER::pushDisc));
            addSequential(new WaitCommand(0.1));
            addSequential(new LambdaCommand(Robot.DISC_PUSHER, Robot.DISC_PUSHER::pullBack));
        }
    }
}
