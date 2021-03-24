package generated.main;

import de.fhg.iais.roberta.runtime.*;
import de.fhg.iais.roberta.runtime.ev3.*;

import de.fhg.iais.roberta.mode.general.*;
import de.fhg.iais.roberta.mode.action.*;
import de.fhg.iais.roberta.mode.sensor.*;
import de.fhg.iais.roberta.mode.action.ev3.*;
import de.fhg.iais.roberta.mode.sensor.ev3.*;

import de.fhg.iais.roberta.components.*;

import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import lejos.remote.nxt.NXTConnection;

public class NEPOprog {
    private static Configuration brickConfiguration;
    
    private Set<UsedSensor> usedSensors = new LinkedHashSet<UsedSensor>(Arrays.asList(new UsedSensor(SensorPort.S4, SensorType.ULTRASONIC, UltrasonicSensorMode.DISTANCE), new UsedSensor(SensorPort.S2, SensorType.GYRO, GyroSensorMode.ANGLE), new UsedSensor(SensorPort.S2, SensorType.GYRO, GyroSensorMode.RATE), new UsedSensor(SensorPort.S1, SensorType.TOUCH, TouchSensorMode.TOUCH), new UsedSensor(SensorPort.S4, SensorType.ULTRASONIC, UltrasonicSensorMode.PRESENCE), new UsedSensor(SensorPort.S3, SensorType.COLOR, ColorSensorMode.COLOUR)));
    private Hal hal = new Hal(brickConfiguration, usedSensors);
    
    public static void main(String[] args) {
        try {
             brickConfiguration = new EV3Configuration.Builder()
                .setWheelDiameter(5.6)
                .setTrackWidth(18.0)
                .addActor(ActorPort.B, new Actor(ActorType.LARGE, true, DriveDirection.FOREWARD, MotorSide.RIGHT))
                .addSensor(SensorPort.S1, new Sensor(SensorType.TOUCH))
                .addSensor(SensorPort.S2, new Sensor(SensorType.GYRO))
                .addSensor(SensorPort.S3, new Sensor(SensorType.COLOR))
                .addSensor(SensorPort.S4, new Sensor(SensorType.ULTRASONIC))
                .build();
            
            new NEPOprog().run();
        } catch ( Exception e ) {
            Hal.displayExceptionWaitForKeyPress(e);
        }
    }
    
    ArrayList<Float> ___numbers = new ArrayList<>(Arrays.asList((float) 0, (float) hal.getUltraSonicSensorDistance(SensorPort.S4), (float) hal.getRegulatedMotorTachoValue(ActorPort.B, MotorTachoMode.DEGREE), (float) hal.getRegulatedMotorTachoValue(ActorPort.B, MotorTachoMode.ROTATION), (float) hal.getRegulatedMotorTachoValue(ActorPort.B, MotorTachoMode.DISTANCE), (float) hal.getGyroSensorAngle(SensorPort.S2), (float) hal.getGyroSensorRate(SensorPort.S2), (float) hal.getTimerValue(1)));
    ArrayList<Boolean> ___strings = new ArrayList<>(Arrays.<Boolean>asList(true, false, hal.isPressed(SensorPort.S1), hal.isPressed(BrickKey.ENTER), hal.getUltraSonicSensorPresence(SensorPort.S4), true == hal.isPressed(BrickKey.ENTER), true != hal.isPressed(BrickKey.ENTER), hal.getUltraSonicSensorDistance(SensorPort.S4) < 0, hal.getUltraSonicSensorDistance(SensorPort.S4) <= 0, hal.getUltraSonicSensorDistance(SensorPort.S4) > 0, hal.getUltraSonicSensorDistance(SensorPort.S4) >= 0, true && hal.isPressed(BrickKey.ENTER), true || hal.isPressed(BrickKey.ENTER)));
    ArrayList<String> ___booleans = new ArrayList<>(Arrays.<String>asList("", String.valueOf("") + String.valueOf(hal.getColorSensorColour(SensorPort.S3)) + String.valueOf(new ArrayList<>(Arrays.<String>asList(""))) + String.valueOf(true) + String.valueOf(0) + String.valueOf(PickColor.WHITE)));
    ArrayList<PickColor> ___colors = new ArrayList<>(Arrays.<PickColor>asList(PickColor.WHITE, hal.getColorSensorColour(SensorPort.S3)));
    ArrayList<NXTConnection> ___connections = new ArrayList<>(Arrays.<NXTConnection>asList(hal.waitForConnection(), hal.establishConnectionTo("")));
    ArrayList<Float> ___item = new ArrayList<>(Collections.nCopies( (int) 5,  (float) 5));
    ArrayList<Boolean> ___item2 = new ArrayList<>(Collections.nCopies( (int) 5, true));
    ArrayList<String> ___item3 = new ArrayList<>(Collections.nCopies( (int) 5, ""));
    ArrayList<PickColor> ___item4 = new ArrayList<>(Collections.nCopies( (int) 5, PickColor.BLUE));
    ArrayList<NXTConnection> ___item5 = new ArrayList<>(Collections.nCopies( (int) 5, hal.waitForConnection()));
    ArrayList<Float> ___item6 = new ArrayList<>(Collections.nCopies( (int) 5, 5 + ((float) 1.2)));
    ArrayList<Boolean> ___item7 = new ArrayList<>(Collections.nCopies( (int) 5, true));
    ArrayList<String> ___item8 = new ArrayList<>(Collections.nCopies( (int) 5, String.valueOf("") + String.valueOf(hal.getColorSensorColour(SensorPort.S3))));
    ArrayList<PickColor> ___item9 = new ArrayList<>(Collections.nCopies( (int) 5, hal.getColorSensorColour(SensorPort.S3)));
    
    public void run() throws Exception {
    }

}