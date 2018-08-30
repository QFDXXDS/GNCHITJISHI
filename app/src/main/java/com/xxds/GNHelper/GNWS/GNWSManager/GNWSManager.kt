package com.xxds.GNHelper.GNWS.GNWSManager

import com.xxds.GNHelper.GNWS.GNWSObject
import com.xxds.GNHelper.GNConfig.GNFailBlock
import com.xxds.GNHelper.GNConfig.GNSuccessBlock
import com.xxds.GNHelper.GNConfig.GNWSInterface
import com.xxds.GNHelper.GNWS.SocketEvent
import com.xxds.GNHelper.GNWS.socketEventBlock
import kotlin.properties.Delegates


/**
 * Created by xxds on 2018/8/30.
 */





class GNWSManager {

    val socketObject = GNWSObject()

    init {

        instance = this
        socketObject.socketEvent = { event,Bool ->

        }
    }
    companion object {

        var instance =  GNWSManager()

        fun sendLink(url: String){

           instance.socketObject.link(url)
        }
        fun sendReq(req:GNWSInterface,success: GNSuccessBlock,fail: GNFailBlock) {

            if (instance.socketObject.status()) {



//                instance.socketObject.sendMessage()
            }
        }

        fun close(){

            instance.socketObject.close()
        }


    }





}