#define PROGRAM_NAME "NEPOprog"
#define WHEEL_DIAMETER 5.6
#define TRACK_WIDTH 18.0

#include <ev3.h>
#include <math.h>
#include <list>
#include "NEPODefs.h"



double ___item = 12345;
bool ___item2 = true;
std::string ___item3 = "Es l\u00E4uft!";
Color ___item4 = Red;
BluetoothConnectionHandle ___item5 = NULL;
std::list<double> ___item6 = ((std::list<double>){12345, 12345, 12345});
std::list<bool> ___item7 = ((std::list<bool>){true, false, true});
std::list<std::string> ___item8 = ((std::list<std::string>){"Hallo", "liebe", "Roberta"});
std::list<Color> ___item9 = ((std::list<Color>){Red, Green, Blue});
std::list<BluetoothConnectionHandle> ___item10 = ((std::list<BluetoothConnectionHandle>){NULL, NULL, NULL});

int main () {
    NEPOInitEV3();
    NEPOSetAllSensors(NULL, NULL, NULL, NULL);
    
    
    DrawString(ToString(___item), 0, 0);
    Wait(1000);
    LcdClean();
    DrawString(ToString(___item2), 0, 0);
    Wait(1000);
    LcdClean();
    DrawString(ToString(___item3), 0, 0);
    Wait(1000);
    LcdClean();
    DrawString(ToString(___item4), 0, 0);
    Wait(1000);
    LcdClean();
    DrawString(ToString(___item5), 0, 0);
    Wait(1000);
    LcdClean();
    DrawString(ToString(___item6), 0, 0);
    Wait(1000);
    LcdClean();
    DrawString(ToString(___item7), 0, 0);
    Wait(1000);
    LcdClean();
    DrawString(ToString(___item8), 0, 0);
    Wait(1000);
    LcdClean();
    DrawString(ToString(___item9), 0, 0);
    Wait(1000);
    LcdClean();
    DrawString(ToString(___item10), 0, 0);
    Wait(1000);
    LcdClean();
    Wait(500);
    LcdPicture(LCD_COLOR_BLACK, 0, 0, OLDGLASSES);
    Wait(500);
    LcdClean();
    LcdPicture(LCD_COLOR_BLACK, 0, 0, EYESOPEN);
    Wait(500);
    LcdClean();
    LcdPicture(LCD_COLOR_BLACK, 0, 0, EYESCLOSED);
    Wait(500);
    LcdClean();
    LcdPicture(LCD_COLOR_BLACK, 0, 0, FLOWERS);
    Wait(500);
    LcdClean();
    LcdPicture(LCD_COLOR_BLACK, 0, 0, TACHO);
    Wait(500);
    LcdClean();
    
    SetLedPattern(LED_GREEN);
    Wait(1000);
    SetLedPattern(LED_BLACK);
    SetLedPattern(LED_ORANGE);
    Wait(1000);
    SetLedPattern(LED_BLACK);
    SetLedPattern(LED_RED);
    Wait(1000);
    SetLedPattern(LED_BLACK);
    
    SetLedPattern(LED_GREEN_FLASH);
    Wait(1000);
    SetLedPattern(LED_BLACK);
    SetLedPattern(LED_ORANGE_FLASH);
    Wait(1000);
    SetLedPattern(LED_BLACK);
    SetLedPattern(LED_RED_FLASH);
    Wait(1000);
    SetLedPattern(LED_BLACK);
    
    SetLedPattern(LED_GREEN_PULSE);
    Wait(1000);
    SetLedPattern(LED_BLACK);
    SetLedPattern(LED_ORANGE_PULSE);
    Wait(1000);
    SetLedPattern(LED_BLACK);
    SetLedPattern(LED_RED_PULSE);
    Wait(1000);
    SetLedPattern(LED_BLACK);
    
    NEPOFreeEV3();
    return 0;
}
