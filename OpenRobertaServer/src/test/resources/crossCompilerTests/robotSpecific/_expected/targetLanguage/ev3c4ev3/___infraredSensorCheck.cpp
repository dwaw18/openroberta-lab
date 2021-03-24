#define PROGRAM_NAME "NEPOprog"
#define WHEEL_DIAMETER 5.6
#define TRACK_WIDTH 18.0

#include <ev3.h>
#include <math.h>
#include <list>
#include "NEPODefs.h"



double ___item = ReadEV3IrSensorProximity(IN_4);
std::list<double> ___item2 = _ReadIRSeekAllChannels(IN_4);
double ___item3 = ReadHTIrSensor(IN_1, Modulated);
double ___item4 = ReadHTIrSensor(IN_1, Unmodulated);

int main () {
    NEPOInitEV3();
    NEPOSetAllSensors(HTIr, NULL, NULL, EV3Ir);
    
    
    NEPOPlayTone(261.626, 2000);
    OnFwdReg(OUT_B, Speed(30));
    for (float ___k0 = 0; ___k0 < 10; ___k0 += 1) {
        DrawString(ToString(ReadEV3IrSensorProximity(IN_4)), 0, 1);
        DrawString(ToString(_ReadIRSeekAllChannels(IN_4)), 0, 2);
        DrawString(ToString(ReadHTIrSensor(IN_1, Modulated)), 0, 3);
        DrawString(ToString(ReadHTIrSensor(IN_1, Unmodulated)), 0, 4);
        LcdClean();
        Wait(500);
        DrawString(ToString(___item), 0, 1);
        DrawString(ToString(___item2), 0, 2);
        DrawString(ToString(___item3), 0, 3);
        DrawString(ToString(___item4), 0, 4);
    }
    
    NEPOFreeEV3();
    return 0;
}
