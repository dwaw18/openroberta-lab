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
    
    private Set<UsedSensor> usedSensors = new LinkedHashSet<UsedSensor>(Arrays.asList(new UsedSensor(SensorPort.S1, SensorType.COMPASS, CompassSensorMode.ANGLE), new UsedSensor(SensorPort.S1, SensorType.COMPASS, CompassSensorMode.CALIBRATE)));
    private Hal hal = new Hal(brickConfiguration, usedSensors);
    
    public static void main(String[] args) {
        try {
             brickConfiguration = new EV3Configuration.Builder()
                .setWheelDiameter(5.6)
                .setTrackWidth(18.0)
                .addSensor(SensorPort.S1, new Sensor(SensorType.COMPASS))
                .build();
            
            new NEPOprog().run();
        } catch ( Exception e ) {
            Hal.displayExceptionWaitForKeyPress(e);
        }
    }
    
    float ___item = hal.getHiTecCompassAngle(SensorPort.S1);
    
    public void run() throws Exception {
        hal.hiTecCompassStartCalibration(SensorPort.S1);
        hal.waitFor(40000);
        hal.hiTecCompassStopCalibration(SensorPort.S1);
        hal.drawText(String.valueOf(hal.getHiTecCompassAngle(SensorPort.S1)), 0, 1);
        hal.waitFor(1000);
        hal.clearDisplay();
        hal.hiTecCompassStartCalibration(SensorPort.S1);
        hal.waitFor(40000);
        hal.hiTecCompassStopCalibration(SensorPort.S1);
        hal.drawText(String.valueOf(___item), 0, 1);
        hal.waitFor(1000);
        hal.clearDisplay();
    }
}