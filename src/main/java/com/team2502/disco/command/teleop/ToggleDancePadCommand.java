package com.team2502.disco.command.teleop;

import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class ToggleDancePadCommand extends InstantCommand {

    @Override
    protected void execute(){
        Robot.DANCE_PAD_ENABLED = !Robot.DANCE_PAD_ENABLED;
    }

}
