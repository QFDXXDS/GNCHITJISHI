package com.xxds.GNHelper.GNWS

import org.java_websocket.WebSocket
import org.java_websocket.client.WebSocketClient
import org.java_websocket.drafts.Draft_10
import org.java_websocket.drafts.Draft_17
import org.java_websocket.drafts.Draft_75
import org.java_websocket.handshake.ServerHandshake
import java.lang.Exception
import java.net.URI

/**
 * Created by xxds on 2018/8/29.
 */



 val PORTAL_PREFIX = "ws://"

 val PORTAL_SUFFIX = ":20005/ue"

 val PORTAL_SUFFIX_SUFFIX = "/ue"


typealias socketEventBlock = (SocketEvent,Boolean) -> Unit



enum class SocketEvent{

    GNWS_HeartCheck_Event,
    GNWS_Reconnect_Event,
}

class GNWSObject {

    var URLString: String? = null

    var socket: WebSocketClient? = null

    lateinit var socketEvent:socketEventBlock

    fun link(url: String){

        URLString = PORTAL_PREFIX + url + PORTAL_SUFFIX

        socket  = object: WebSocketClient(URI(URLString),Draft_17()){


            override fun onOpen(handshakedata: ServerHandshake?) {

                println("onClose is ${handshakedata!!.httpStatus}" )
                this@GNWSObject.socketEvent(SocketEvent.GNWS_HeartCheck_Event,true)
                this@GNWSObject.socketEvent(SocketEvent.GNWS_Reconnect_Event,false)


            }

            override fun onMessage(message: String?) {

            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {


                println("onClose is $code" + reason)
            }

            override fun onError(ex: Exception?) {

                println("onClose is " + ex.toString())

            }

        }

        socket!!.connect()
    }

    fun sendMessage(message: String?){

        socket!!.send(message)
    }

    fun close(){

        socket!!.close()
    }
    fun status(): Boolean {


        val state = if (socket!!.readyState == WebSocket.READYSTATE.OPEN) true else false

        return state

    }
}