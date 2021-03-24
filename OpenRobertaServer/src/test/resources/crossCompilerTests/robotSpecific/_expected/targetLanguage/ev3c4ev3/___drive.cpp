#define PROGRAM_NAME "NEPOprog"
#define WHEEL_DIAMETER 5.6
#define TRACK_WIDTH 18.0

#include <ev3.h>
#include <math.h>
#include <list>
#include "NEPODefs.h"




int main () {
    NEPOInitEV3();
    NEPOSetAllSensors(NULL, NULL, NULL, NULL);
    startLoggingThread(OUT_BC);
    
    
    for (float ___k0 = 0; ___k0 < 10; ___k0 += 1) {
        RotateMotorForAngle(OUT_BC, Speed(30), (20 * 360) / (M_PI * WHEEL_DIAMETER));
    }
    
    NEPOFreeEV3();
    return 0;
}
