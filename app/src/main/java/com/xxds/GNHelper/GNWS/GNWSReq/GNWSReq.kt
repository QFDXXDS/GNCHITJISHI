package com.xxds.GNHelper.GNWS.GNWSReq

import com.xxds.GNHelper.GNConfig.GNWSInterface
import kotlin.properties.Delegates

/**
 * Created by xxds on 2018/8/31.
 */


open  class GNWSReq: GNWSInterface {

    override fun opt(): String {

        return ""
    }
}

class  GNWSHeartReq: GNWSReq() {

   lateinit var status: String

    lateinit var id: String
}