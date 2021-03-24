#define PROGRAM_NAME "NEPOprog"
#define WHEEL_DIAMETER 5.6
#define TRACK_WIDTH 18.0

#include <ev3.h>
#include <math.h>
#include <list>
#include "NEPODefs.h"



double ___item = ReadHTCompassSensor(IN_1, HTCompassAngle);

int main () {
    NEPOInitEV3();
    NEPOSetAllSensors(HTCompass, NULL, NULL, NULL);
    
    
    
    StartHTCompassCalibration(IN_1);Wait(40000);StopHTCompassCalibration(IN_1);
    
    DrawString(ToString(ReadHTCompassSensor(IN_1, HTCompassAngle)), 0, 1);
    Wait(1000);
    LcdClean();
    
    StartHTCompassCalibration(IN_1);Wait(40000);StopHTCompassCalibration(IN_1);
    
    DrawString(ToString(___item), 0, 1);
    Wait(1000);
    LcdClean();
    
    NEPOFreeEV3();
    return 0;
}
