package com.pramod.apitest.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("UserItem")
class User : ArrayList<UserDetals>()

