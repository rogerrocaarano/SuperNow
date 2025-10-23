package me.rogerroca.supernow.common.tools

import com.thedeanda.lorem.LoremIpsum


val mockTextGen = LoremIpsum.getInstance()

val mockImageUrl: String
    get() = "https://picsum.photos/800/600?random=${
        System.currentTimeMillis() + kotlin.random.Random.nextLong(0, 1_000_000)
    }"