#define PROGRAM_NAME "NEPOprog"
#define WHEEL_DIAMETER 5.6
#define TRACK_WIDTH 18.0

#include <ev3.h>
#include <math.h>
#include <list>
#include "NEPODefs.h"



Color ___item = White;
double ___item2 = 0;
std::list<double> ___item3 = ((std::list<double>){});

int main () {
    NEPOInitEV3();
    NEPOSetAllSensors(NULL, NULL, HTColorV2, NULL);
    
    
    ___item = NEPOReadHTColorSensorV2(IN_3);
    ___item2 = NEPOReadHTColorSensorV2Light(IN_3);
    ___item2 = NEPOReadHTColorSensorV2AmbientLight(IN_3);
    ___item3 = NEPOReadHTColorSensorV2RGB(IN_3);
    
    NEPOFreeEV3();
    return 0;
}
