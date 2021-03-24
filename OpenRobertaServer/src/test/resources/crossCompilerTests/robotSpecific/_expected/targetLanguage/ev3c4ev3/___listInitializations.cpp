#define PROGRAM_NAME "NEPOprog"
#define WHEEL_DIAMETER 5.6
#define TRACK_WIDTH 18.0

#include <ev3.h>
#include <math.h>
#include <list>
#include "NEPODefs.h"




std::list<double> ___numbers = ((std::list<double>){0, ReadEV3UltrasonicSensorDistance(IN_4, CM), MotorRotationCount(OUT_B), (MotorRotationCount(OUT_B) / 360.0), ((MotorRotationCount(OUT_B) / 360.0) * M_PI * WHEEL_DIAMETER), ReadEV3GyroSensor(IN_2, EV3GyroAngle), ReadEV3GyroSensor(IN_2, EV3GyroRate), GetTimerValue(1)});
std::list<bool> ___strings = ((std::list<bool>){true, false, ReadEV3TouchSensor(IN_1), ButtonIsDown(BTNCENTER), ReadEV3UltrasonicSensorListen(IN_4), true == ButtonIsDown(BTNCENTER), true != ButtonIsDown(BTNCENTER), ReadEV3UltrasonicSensorDistance(IN_4, CM) < 0, ReadEV3UltrasonicSensorDistance(IN_4, CM) <= 0, ReadEV3UltrasonicSensorDistance(IN_4, CM) > 0, ReadEV3UltrasonicSensorDistance(IN_4, CM) >= 0, true && ButtonIsDown(BTNCENTER), true || ButtonIsDown(BTNCENTER)});
std::list<std::string> ___booleans = ((std::list<std::string>){"", ToString("") + ToString(ReadEV3ColorSensor(IN_3)) + ToString(((std::list<std::string>){""})) + ToString(true) + ToString(0) + ToString(White)});
std::list<Color> ___colors = ((std::list<Color>){White, ReadEV3ColorSensor(IN_3)});
std::list<BluetoothConnectionHandle> ___connections = ((std::list<BluetoothConnectionHandle>){NEPOWaitConnection(), NEPOConnectTo("")});
std::list<double> ___item = _createListRepeat(5, (double) 5);
std::list<bool> ___item2 = _createListRepeat(5, true);
std::list<std::string> ___item3 = _createListRepeat(5, (std::string) "");
std::list<Color> ___item4 = _createListRepeat(5, Blue);
std::list<BluetoothConnectionHandle> ___item5 = _createListRepeat(5, NEPOWaitConnection());
std::list<double> ___item6 = _createListRepeat(5, 5 + 1.2);
std::list<bool> ___item7 = _createListRepeat(5, true);
std::list<std::string> ___item8 = _createListRepeat(5, (std::string) ToString("") + ToString(ReadEV3ColorSensor(IN_3)));
std::list<Color> ___item9 = _createListRepeat(5, ReadEV3ColorSensor(IN_3));

int main () {
    NEPOInitEV3();
    NEPOSetAllSensors(EV3Touch, EV3Gyro, EV3Color, EV3Ultrasonic);
    NEPOResetEV3GyroSensor(IN_2);
    NEPOResetEV3GyroSensor(IN_2);
    
    
    
    NEPOFreeEV3();
    return 0;
}

