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
    
    private Set<UsedSensor> usedSensors = new LinkedHashSet<UsedSensor>(Arrays.asList(new UsedSensor(SensorPort.S1, SensorType.TOUCH, TouchSensorMode.TOUCH), new UsedSensor(SensorPort.S4, SensorType.ULTRASONIC, UltrasonicSensorMode.DISTANCE), new UsedSensor(SensorPort.S4, SensorType.ULTRASONIC, UltrasonicSensorMode.PRESENCE), new UsedSensor(SensorPort.S3, SensorType.COLOR, ColorSensorMode.COLOUR), new UsedSensor(SensorPort.S3, SensorType.COLOR, ColorSensorMode.RED), new UsedSensor(SensorPort.S3, SensorType.COLOR, ColorSensorMode.AMBIENTLIGHT), new UsedSensor(SensorPort.S2, SensorType.GYRO, GyroSensorMode.ANGLE), new UsedSensor(SensorPort.S2, SensorType.GYRO, GyroSensorMode.RATE)));
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
    
    
    public void run() throws Exception {
        hal.startLogging();
        hal.playTone( (float) 261.626,  (float) 500);
        for ( float ___k0 = 0; ___k0< 10; ___k0+= 1 ) {
            while ( true ) {
                if ( hal.isPressed(SensorPort.S1) == true ) {
                    break;
                }
                if ( hal.getUltraSonicSensorDistance(SensorPort.S4) < 30 ) {
                    break;
                }
                if ( hal.getUltraSonicSensorPresence(SensorPort.S4) == true ) {
                    break;
                }
                if ( hal.getColorSensorColour(SensorPort.S3) == PickColor.RED ) {
                    break;
                }
                if ( hal.getColorSensorRed(SensorPort.S3) > 50 ) {
                    break;
                }
                if ( hal.getColorSensorAmbient(SensorPort.S3) > 50 ) {
                    break;
                }
                if ( hal.getRegulatedMotorTachoValue(ActorPort.B, MotorTachoMode.ROTATION) > 2 ) {
                    hal.resetRegulatedMotorTacho(ActorPort.B);
                    break;
                }
                if ( hal.getRegulatedMotorTachoValue(ActorPort.B, MotorTachoMode.DEGREE) > 180 ) {
                    hal.resetRegulatedMotorTacho(ActorPort.B);
                    break;
                }
                if ( hal.isPressed(BrickKey.DOWN) == true ) {
                    break;
                }
                if ( hal.getGyroSensorAngle(SensorPort.S2) > 90 ) {
                    hal.resetGyroSensor(SensorPort.S2);
                    break;
                }
                if ( hal.getGyroSensorRate(SensorPort.S2) > 90 ) {
                    hal.resetGyroSensor(SensorPort.S2);
                    break;
                }
                if ( hal.getTimerValue(1) > 50000 ) {
                    hal.resetTimer(1);
                    break;
                }
                hal.waitFor(15);
            }
            hal.playTone( (float) 130.813,  (float) 2000);
        }
        hal.closeResources();
        
    }
}