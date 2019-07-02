package com.team2502.disco.command.teleop;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LambdaCommand extends InstantCommand
{
    private final Runnable lambda;

    public LambdaCommand(Subsystem toRequire, Runnable lambda) {
        this.lambda = lambda;
        requires(toRequire);
    }

    @Override
    protected void execute()
    {
        lambda.run();
    }
}
