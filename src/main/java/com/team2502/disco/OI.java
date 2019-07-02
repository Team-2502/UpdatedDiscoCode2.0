package com.team2502.disco;

import com.team2502.disco.command.teleop.ChangeAngleCommand;
import com.team2502.disco.command.teleop.RunShooterCommand;
import com.team2502.disco.command.teleop.ShootDiscCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The Operator Interface class
 */
public final class OI
{
    /**
     * Represents the left drive joystick
     *
     * @see OI
     */
    public static final Joystick JOYSTICK_DRIVE_LEFT = new Joystick(RobotMap.Joystick.JOYSTICK_DRIVE_LEFT);

    /**
     * Represents the right drive joystick
     *
     * @see OI
     */
    public static final Joystick JOYSTICK_DRIVE_RIGHT = new Joystick(RobotMap.Joystick.JOYSTICK_DRIVE_RIGHT);


    // Start defining buttons to be using
    // Names are self explanatory
    // Convention: Button variable names here should be the same as ID names in RobotMap

    public static final JoystickButton SPIN_UP_FLYWHEEL = new JoystickButton(JOYSTICK_DRIVE_RIGHT, RobotMap.Joystick.Button.SPIN_UP_FLYWHEEL);
    public static final JoystickButton PUSH_DISC = new JoystickButton(JOYSTICK_DRIVE_RIGHT, RobotMap.Joystick.Button.PUSH_DISC);
    public static final JoystickButton RAISE_SHOOTER = new JoystickButton(JOYSTICK_DRIVE_RIGHT, RobotMap.Joystick.Button.RAISE_SHOOTER);
    public static final JoystickButton LOWER_SHOOTER = new JoystickButton(JOYSTICK_DRIVE_RIGHT, RobotMap.Joystick.Button.LOWER_SHOOTER);

    /*
     * Runs when the first static method (usually OI#init()) is called
     * Called the "static initialization constructor"
     */
    static
    {
        SPIN_UP_FLYWHEEL.whileHeld(new RunShooterCommand());
        RAISE_SHOOTER.whileHeld(new ChangeAngleCommand(1));
        LOWER_SHOOTER.whileHeld(new ChangeAngleCommand(-1));
        PUSH_DISC.whenPressed(new ShootDiscCommand());
    }

    /**
     * Workaround for Java's lazy-loading of static classes
     * <p>
     * When this is called, Java loads the static bits of this class and runs the static init constructor above.
     */
    public static void init() {}

}