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


class GNWSObject {

    var URLString: String? = null

     var socket: WebSocketClient? = null

    fun link(url: String){

        URLString = PORTAL_PREFIX + url + PORTAL_SUFFIX

        socket  = object: WebSocketClient(URI(URLString),Draft_17()){


            override fun onOpen(handshakedata: ServerHandshake?) {

                println("onClose is ${handshakedata!!.httpStatus}" )


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

    fun stop(){

        socket!!.close()
    }




}