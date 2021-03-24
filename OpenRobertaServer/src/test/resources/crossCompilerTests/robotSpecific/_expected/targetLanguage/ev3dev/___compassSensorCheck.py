#!/usr/bin/python

from __future__ import absolute_import
from roberta.ev3 import Hal
from ev3dev import ev3 as ev3dev
import math
import os

class BreakOutOfALoop(Exception): pass
class ContinueLoop(Exception): pass

_brickConfiguration = {
    'wheel-diameter': 5.6,
    'track-width': 18.0,
    'actors': {
    },
    'sensors': {
        '1':Hal.makeCompassSensor(ev3dev.INPUT_1),
    },
}
hal = Hal(_brickConfiguration)

___item = hal.getHiTecCompassSensorValue('1', 'angle')
def run():
    global ___item
    
    hal.drawText(str(hal.getHiTecCompassSensorValue('1', 'angle')), 0, 1)
    hal.waitFor(1000)
    hal.clearDisplay()
    
    hal.drawText(str(___item), 0, 1)
    hal.waitFor(1000)
    hal.clearDisplay()

def main():
    try:
        run()
    except Exception as e:
        hal.drawText('Fehler im EV3', 0, 0)
        hal.drawText(e.__class__.__name__, 0, 1)
        hal.drawText(str(e), 0, 2)
        hal.drawText('Press any key', 0, 4)
        while not hal.isKeyPressed('any'): hal.waitFor(500)
        raise

if __name__ == "__main__":
    main()