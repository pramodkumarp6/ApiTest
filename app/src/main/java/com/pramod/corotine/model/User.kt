package com.pramod.corotine.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("UserItem")
class User : ArrayList<UserDetals>()

