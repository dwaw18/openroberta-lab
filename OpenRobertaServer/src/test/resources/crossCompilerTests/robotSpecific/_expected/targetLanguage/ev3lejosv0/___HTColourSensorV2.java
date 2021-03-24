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
    
    private Set<UsedSensor> usedSensors = new LinkedHashSet<UsedSensor>(Arrays.asList(new UsedSensor(SensorPort.S3, SensorType.HT_COLOR, HiTecColorSensorV2Mode.COLOUR), new UsedSensor(SensorPort.S3, SensorType.HT_COLOR, HiTecColorSensorV2Mode.LIGHT), new UsedSensor(SensorPort.S3, SensorType.HT_COLOR, HiTecColorSensorV2Mode.AMBIENTLIGHT), new UsedSensor(SensorPort.S3, SensorType.HT_COLOR, HiTecColorSensorV2Mode.RGB)));
    private Hal hal = new Hal(brickConfiguration, usedSensors);
    
    public static void main(String[] args) {
        try {
             brickConfiguration = new EV3Configuration.Builder()
                .setWheelDiameter(5.6)
                .setTrackWidth(18.0)
                .addSensor(SensorPort.S3, new Sensor(SensorType.HT_COLOR))
                .build();
            
            new NEPOprog().run();
        } catch ( Exception e ) {
            Hal.displayExceptionWaitForKeyPress(e);
        }
    }
    
    PickColor ___item = PickColor.WHITE;
    float ___item2 = 0;
    ArrayList<Float> ___item3 = new ArrayList<>();
    
    public void run() throws Exception {
        ___item = hal.getHiTecColorSensorV2Colour(SensorPort.S3);
        ___item2 = hal.getHiTecColorSensorV2Light(SensorPort.S3);
        ___item2 = hal.getHiTecColorSensorV2Ambient(SensorPort.S3);
        ___item3 = hal.getHiTecColorSensorV2Rgb(SensorPort.S3);
    }
}