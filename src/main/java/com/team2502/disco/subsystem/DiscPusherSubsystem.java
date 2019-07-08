package com.team2502.disco.subsystem;

import com.team2502.disco.Robot;
import com.team2502.disco.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DiscPusherSubsystem extends Subsystem
{
    private final Solenoid pusherSolenoid;

    public DiscPusherSubsystem()
    {
        pusherSolenoid = new Solenoid(RobotMap.Solenoid.PUSHER_SOLENOID);
    }

    public void pushDisc() {
        if(Robot.SHOOTER_FLYWHEEL.isSpunUp()) {
            pusherSolenoid.set(true);
        }
    }

    public void pullBack() {
        pusherSolenoid.set(false);
    }

    @Override
    protected void initDefaultCommand()
    {
        // none
    }
}
