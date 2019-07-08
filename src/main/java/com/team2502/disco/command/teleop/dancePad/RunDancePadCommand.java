package com.team2502.disco.command.teleop.dancePad;

import com.team2502.disco.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class RunDancePadCommand extends InstantCommand {

    private Command commandToRun;

    public RunDancePadCommand(Command command){
        commandToRun = command;
    }

    @Override
    protected void execute(){
        if(Robot.DANCE_PAD_ENABLED){
            commandToRun.start();
        }
    }
}
