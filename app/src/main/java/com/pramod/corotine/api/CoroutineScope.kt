package com.pramod.corotine.api

import kotlin.coroutines.CoroutineContext

interface CoroutineScope {

    public val coroutineContext: CoroutineContext
}