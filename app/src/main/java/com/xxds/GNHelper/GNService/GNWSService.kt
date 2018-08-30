package com.xxds.GNHelper.GNService

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.xxds.GNHelper.GNWS.GNWSObject

class GNWSService : Service() {


    val socketObject = GNWSObject()

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()


    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        socketObject.link("chitdev.byshang.cn")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()



    }


}
