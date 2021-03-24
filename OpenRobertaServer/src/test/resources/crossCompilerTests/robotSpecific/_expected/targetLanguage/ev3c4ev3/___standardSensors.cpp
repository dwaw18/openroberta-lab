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
    
    
    NEPOPlayTone(261.626, 500);
    OnFwdReg(OUT_B, Speed(3));
    for (float ___k0 = 0; ___k0 < 10; ___k0 += 1) {
        DrawString(ToString(ReadEV3TouchSensor(IN_1)), 0, 0);
        DrawString(ToString(ReadEV3UltrasonicSensorDistance(IN_4, CM)), 10, 0);
        DrawString(ToString(ReadEV3UltrasonicSensorListen(IN_4)), 0, 1);
        DrawString(ToString(ReadEV3ColorSensor(IN_3)), 10, 1);
        DrawString(ToString(ReadEV3ColorSensorLight(IN_3, ReflectedLight)), 0, 2);
        DrawString(ToString(NEPOReadEV3ColorSensorRGB(IN_3)), 10, 2);
        DrawString(ToString(ReadEV3ColorSensorLight(IN_3, AmbientLight)), 0, 3);
        DrawString(ToString((MotorRotationCount(OUT_B) / 360.0)), 0, 3);
        DrawString(ToString(MotorRotationCount(OUT_B)), 10, 3);
        DrawString(ToString(((MotorRotationCount(OUT_B) / 360.0) * M_PI * WHEEL_DIAMETER)), 0, 4);
        ResetRotationCount(OUT_B);
        DrawString(ToString(ButtonIsDown(BTNDOWN)), 10, 4);
        DrawString(ToString(ReadEV3GyroSensor(IN_2, EV3GyroAngle)), 0, 5);
        DrawString(ToString(ReadEV3GyroSensor(IN_2, EV3GyroRate)), 10, 5);
        NEPOResetEV3GyroSensor(IN_2);
        DrawString(ToString(GetTimerValue(3)), 0, 6);
        ResetTimer(3);
        while ( true ) {
            if ( ReadEV3TouchSensor(IN_1) == true ) {
                break;
            }
        }
        while ( true ) {
            if ( ReadEV3TouchSensor(IN_1) == false ) {
                break;
            }
        }
        LcdClean();
    }
    
    NEPOFreeEV3();
    return 0;
}
