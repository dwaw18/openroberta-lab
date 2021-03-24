#define PROGRAM_NAME "NEPOprog"
#define WHEEL_DIAMETER 5.6
#define TRACK_WIDTH 18.0

#include <ev3.h>
#include <math.h>
#include <list>
#include "NEPODefs.h"




int main () {
    NEPOInitEV3();
    NEPOSetAllSensors(EV3Touch, EV3Gyro, EV3Color, EV3Ultrasonic);
    NEPOResetEV3GyroSensor(IN_2);
    NEPOResetEV3GyroSensor(IN_2);
    startLoggingThread(OUT_BC);
    
    
    NEPOPlayTone(261.626, 500);
    for (float ___k0 = 0; ___k0 < 10; ___k0 += 1) {
        while ( true ) {
            if ( ReadEV3TouchSensor(IN_1) == true ) {
                break;
            }
            if ( ReadEV3UltrasonicSensorDistance(IN_4, CM) < 30 ) {
                break;
            }
            if ( ReadEV3UltrasonicSensorListen(IN_4) == true ) {
                break;
            }
            if ( ReadEV3ColorSensor(IN_3) == Red ) {
                break;
            }
            if ( ReadEV3ColorSensorLight(IN_3, ReflectedLight) > 50 ) {
                break;
            }
            if ( ReadEV3ColorSensorLight(IN_3, AmbientLight) > 50 ) {
                break;
            }
            if ( (MotorRotationCount(OUT_B) / 360.0) > 2 ) {
                ResetRotationCount(OUT_B);
                break;
            }
            if ( MotorRotationCount(OUT_B) > 180 ) {
                ResetRotationCount(OUT_B);
                break;
            }
            if ( ButtonIsDown(BTNDOWN) == true ) {
                break;
            }
            if ( ReadEV3GyroSensor(IN_2, EV3GyroAngle) > 90 ) {
                NEPOResetEV3GyroSensor(IN_2);
                break;
            }
            if ( ReadEV3GyroSensor(IN_2, EV3GyroRate) > 90 ) {
                NEPOResetEV3GyroSensor(IN_2);
                break;
            }
            if ( GetTimerValue(1) > 50000 ) {
                ResetTimer(1);
                break;
            }
        }
        NEPOPlayTone(130.813, 2000);
    }
    
    NEPOFreeEV3();
    return 0;
}
