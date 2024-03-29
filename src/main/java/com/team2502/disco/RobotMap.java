package com.team2502.disco;

import java.util.HashMap;
import java.util.Map;

/**
 * Exclusively for defining Button ID's, Solenoid ID's, Motor ID's, and other kinds of ID's
 * Stuff like conversion constants DO NOT belong here
 */
public class RobotMap
{

    private RobotMap() { }

    /**
     * Define Joystick ID's and button ID's
     */
    public static final class Joystick
    {
        public static final int JOYSTICK_DRIVE_LEFT = 1;
        public static final int JOYSTICK_DRIVE_RIGHT = 0;

        private Joystick() { }

        /**
         * Define Button ID's, which should be used in OI.java
         */
        public static final class Button
        {
            public static final int SPIN_UP_FLYWHEEL = 2;
            public static final int PUSH_DISC = 1;

            public static final int RAISE_SHOOTER = 4;
            public static final int LOWER_SHOOTER = 3;
            private Button() { }
        }
    }

    /**
     * Define Motor Controller ID's
     */
    public static final class Motor
    {
        public static final int DRIVE_TRAIN_FRONT_RIGHT = 1;
        public static final int DRIVE_TRAIN_BACK_RIGHT = 2;
        public static final int DRIVE_TRAIN_FRONT_LEFT = 3;
        public static final int DRIVE_TRAIN_BACK_LEFT = 4;

        public static final int SHOOTER_FRONT = 5;
        public static final int SHOOTER_BACK = 6;

        public static final int SHOOTER_ANGLE = 7;


        private Motor() { }
    }

    /**
     * Define Solenoid ID's
     */
    public static final class Solenoid
    {
        public static final int PUSHER_SOLENOID = 1;

        private Solenoid() { }
    }
}