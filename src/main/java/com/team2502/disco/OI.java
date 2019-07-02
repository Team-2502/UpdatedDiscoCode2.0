package com.team2502.disco;

import com.team2502.disco.command.teleop.*;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The Operator Interface class
 */
public final class OI
{

    public static final GenericHID DANCE_PAD = new GenericHID(RobotMap.Joystick.DANCE_PAD) {
        @Override
        public double getX(Hand hand) {
            return 0;
        }

        @Override
        public double getY(Hand hand) {
            return 0;
        }
    };


    // Start defining buttons to be using
    // Names are self explanatory
    // Convention: Button variable names here should be the same as ID names in RobotMap

    public static final JoystickButton DDR_UP = new JoystickButton(DANCE_PAD, RobotMap.Joystick.Button.DDR_UP);
    public static final JoystickButton DDR_DOWN = new JoystickButton(DANCE_PAD, RobotMap.Joystick.Button.DDR_DOWN);
    public static final JoystickButton DDR_LEFT = new JoystickButton(DANCE_PAD, RobotMap.Joystick.Button.DDR_LEFT);
    public static final JoystickButton DDR_RIGHT = new JoystickButton(DANCE_PAD, RobotMap.Joystick.Button.DDR_RIGHT);

    public static final JoystickButton DDR_NW = new JoystickButton(DANCE_PAD, RobotMap.Joystick.Button.DDR_NW);
    public static final JoystickButton DDR_NE = new JoystickButton(DANCE_PAD, RobotMap.Joystick.Button.DDR_NE);
    public static final JoystickButton DDR_SW = new JoystickButton(DANCE_PAD, RobotMap.Joystick.Button.DDR_SW);
    public static final JoystickButton DDR_SE = new JoystickButton(DANCE_PAD, RobotMap.Joystick.Button.DDR_SE);
    public static final JoystickButton DDR_START = new JoystickButton(DANCE_PAD, RobotMap.Joystick.Button.DDR_START);
    public static final JoystickButton DDR_SELECT = new JoystickButton(DANCE_PAD, RobotMap.Joystick.Button.DDR_SELECT);


    /*
     * Runs when the first static method (usually OI#init()) is called
     * Called the "static initialization constructor"
     */
    static
    {
        DDR_NW.whileHeld(new RunShooterCommand());
        DDR_SW.whileHeld(new ChangeAngleCommand(1));
        DDR_SE.whileHeld(new ChangeAngleCommand(-1));
        DDR_NE.whenPressed(new ShootDiscCommand());

        DDR_UP.whenPressed(new DriveForwardCommand(0.5));
        DDR_DOWN.whenPressed(new DriveBackwardCommand(0.5));
        DDR_RIGHT.whenPressed(new TurnRightCommand(0.5));
        DDR_LEFT.whenPressed(new TurnLeftCommand(0.5));

    }

    /**
     * Workaround for Java's lazy-loading of static classes
     * <p>
     * When this is called, Java loads the static bits of this class and runs the static init constructor above.
     */
    public static void init() {}

}