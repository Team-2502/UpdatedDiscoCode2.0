package com.team2502.disco.controls;

import com.team2502.disco.DashboardData;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;
import java.util.*;

public class DancePad extends GenericHID implements DashboardData.DashboardUpdater {

    public ArrayList<Integer> CURRENT_COMBO;
    public Panel PANELS[];

    public static final int UP_ARROW_ID = 3;
    public static final int DOWN_ARROW_ID = 2;
    public static final int LEFT_ARROW_ID = 1;
    public static final int RIGHT_ARROW_ID = 4;
    public static final int NW_ID = 0;              //TODO Find correct IDs
    public static final int NE_ID = 0;
    public Panel UP_ARROW, DOWN_ARROW, LEFT_ARROW, RIGHT_ARROW, NW, NE;

    public double TIME_COMBO_STARTED;
    public boolean COMBO_IN_PROGRESS;

    public DancePad(int usbPort){
        super(usbPort);
        UP_ARROW = new Panel(UP_ARROW_ID);
        DOWN_ARROW = new Panel(DOWN_ARROW_ID);
        LEFT_ARROW = new Panel(LEFT_ARROW_ID);
        RIGHT_ARROW = new Panel(RIGHT_ARROW_ID);
        NW = new Panel(NW_ID);
        NE = new Panel(NE_ID);

        CURRENT_COMBO = new ArrayList<>();
        PANELS = new Panel[]{UP_ARROW, DOWN_ARROW, LEFT_ARROW, RIGHT_ARROW, NW, NE};

        TIME_COMBO_STARTED = System.currentTimeMillis();
        COMBO_IN_PROGRESS = false;

        DashboardData.addUpdater(this);
    }

    @Override
    public double getX(Hand hand)
    {
        return 0;
    }

    @Override
    public double getY(Hand hand)
    {
        return 0;
    }

    public void update(){
        if(!COMBO_IN_PROGRESS) {
            TIME_COMBO_STARTED = System.currentTimeMillis();
        }

        for (Panel PANEL : PANELS) {
            PANEL.update();
            if (PANEL.hasBeenPressed) {
                CURRENT_COMBO.add(PANEL.buttonID);
                COMBO_IN_PROGRESS = true;
            }
        }

        if(CURRENT_COMBO.size() > 3 || System.currentTimeMillis() - TIME_COMBO_STARTED > 1000){
            CURRENT_COMBO.clear();
            COMBO_IN_PROGRESS = false;
        }
    }

    @Override
    public void updateDashboard(){

        // Update with current combo values
        for (int i = 1; i < 4; i++) {
            try {
                SmartDashboard.putNumber("Combo Value" + Integer.toString(i), CURRENT_COMBO.get(i));
            }
            catch ( IndexOutOfBoundsException e ) {
                SmartDashboard.putNumber("Combo Value" + Integer.toString(i), 10);
            }
        }

        // Update with the values of all buttons
        for (Panel panel:PANELS) {
            SmartDashboard.putBoolean(Integer.toString(panel.buttonID), panel.beingPressed);
        }
    }

    public void whileBothHeld(Panel panel1, Panel panel2, Command command){
        if(panel1.beingHeld && panel2.beingHeld){
            command.start();
        }
    }

    public void whenComboPressed(int[] combo, Command command){
        int[] currentComboAsArray = CURRENT_COMBO.stream().mapToInt(j -> j).toArray();
        if (Arrays.equals(combo, currentComboAsArray)) {
            command.start();
            CURRENT_COMBO.clear();
            COMBO_IN_PROGRESS = false;
        }
    }

    public class Panel extends Trigger {
        private int buttonID;
        private double timeWhenPressed;             // The time the button was first activated
        public boolean beingPressed = false;        // If the button is pressed on the current update
        public boolean beingHeld = false;           // If the button is held it was pressed on at least the last update
        public boolean beingLongPressed = false;    // If the button has been held down for at least 250 milliseconds
        public boolean hasBeenPressed = false;      // If the button was pressed on the most recent update
        public boolean hasBeenReleased= false;      // If the button released a press on the most recent update
        public boolean hasBeenLongReleased = false; // If the button released a long press on the most recent update

        public Panel(int id) { buttonID = id; timeWhenPressed = System.currentTimeMillis();}

        public void update(){
            beingPressed = getRawButton(buttonID);      //Check if button is being pressed

            hasBeenReleased = false;
            hasBeenLongReleased = false;
            hasBeenPressed = false;

            if(beingPressed){
                // If the button is being held down
                if (beingHeld) {
                    // If the button has been held down long enough to constitute a long press
                    if(System.currentTimeMillis() - timeWhenPressed > 500) {
                        beingLongPressed = true;
                    }
                }
                // If the button was not being held down on the last update
                else {
                    hasBeenPressed = true;
                    beingHeld = true;
                    timeWhenPressed = System.currentTimeMillis();
                }
            }

            // If the button is not being pressed
            else{
                // If the button was being held on the last update
                if(beingHeld){
                    beingHeld = false;
                    if(beingLongPressed){
                        beingLongPressed = false;
                        hasBeenLongReleased = true;
                    }
                    else{
                        hasBeenReleased = true;
                    }
                }
            }
        }

        @Override
        public boolean get() {
            return getRawButton(buttonID);
        }

        public void whenPressed(final Command command) {
            if(hasBeenPressed){
                command.start();
            }
        }
        public void whileHeld(final Command command) {
            while(hasBeenPressed){
                command.start();
            }
            command.cancel();

        }
        public void whenReleased(final Command command) {
            if(hasBeenReleased){
                command.start();
            }
        }
        public void whenLongPressed(final Command command){
            if(beingLongPressed){
                command.start();
            }
        }
    }
}

