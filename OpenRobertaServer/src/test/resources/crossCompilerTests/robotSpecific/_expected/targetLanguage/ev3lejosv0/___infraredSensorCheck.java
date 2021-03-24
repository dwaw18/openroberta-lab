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
    
    private Set<UsedSensor> usedSensors = new LinkedHashSet<UsedSensor>(Arrays.asList(new UsedSensor(SensorPort.S4, SensorType.INFRARED, InfraredSensorMode.DISTANCE), new UsedSensor(SensorPort.S4, SensorType.INFRARED, InfraredSensorMode.SEEK), new UsedSensor(SensorPort.S1, SensorType.IRSEEKER, IRSeekerSensorMode.MODULATED), new UsedSensor(SensorPort.S1, SensorType.IRSEEKER, IRSeekerSensorMode.UNMODULATED)));
    private Hal hal = new Hal(brickConfiguration, usedSensors);
    
    public static void main(String[] args) {
        try {
             brickConfiguration = new EV3Configuration.Builder()
                .setWheelDiameter(5.6)
                .setTrackWidth(18.0)
                .addActor(ActorPort.B, new Actor(ActorType.LARGE, true, DriveDirection.FOREWARD, MotorSide.RIGHT))
                .addSensor(SensorPort.S1, new Sensor(SensorType.IRSEEKER))
                .addSensor(SensorPort.S4, new Sensor(SensorType.INFRARED))
                .build();
            
            new NEPOprog().run();
        } catch ( Exception e ) {
            Hal.displayExceptionWaitForKeyPress(e);
        }
    }
    
    float ___item = hal.getInfraredSensorDistance(SensorPort.S4);
    ArrayList<Float> ___item2 = hal.getInfraredSensorSeek(SensorPort.S4);
    float ___item3 = hal.getHiTecIRSeekerModulated(SensorPort.S1);
    float ___item4 = hal.getHiTecIRSeekerUnmodulated(SensorPort.S1);
    
    public void run() throws Exception {
        hal.playTone( (float) 261.626,  (float) 2000);
        hal.turnOnRegulatedMotor(ActorPort.B, 30);
        for ( float ___k0 = 0; ___k0< 10; ___k0+= 1 ) {
            hal.drawText(String.valueOf(hal.getInfraredSensorDistance(SensorPort.S4)), 0, 1);
            hal.drawText(String.valueOf(hal.getInfraredSensorSeek(SensorPort.S4)), 0, 2);
            hal.drawText(String.valueOf(hal.getHiTecIRSeekerModulated(SensorPort.S1)), 0, 3);
            hal.drawText(String.valueOf(hal.getHiTecIRSeekerUnmodulated(SensorPort.S1)), 0, 4);
            hal.clearDisplay();
            hal.waitFor(500);
            hal.drawText(String.valueOf(___item), 0, 1);
            hal.drawText(String.valueOf(___item2), 0, 2);
            hal.drawText(String.valueOf(___item3), 0, 3);
            hal.drawText(String.valueOf(___item4), 0, 4);
        }
    }
}