package com.application.dagger

import android.util.Log

class Bike constructor(val engine: Engine,val suspension: Suspension,val wheels: Wheels) {

    fun drivebike(){
        engine.engine()
        suspension.suspension()
        wheels.wheels()
        Log.d("sudarshan", "bike broooom brooom ")
    }


}