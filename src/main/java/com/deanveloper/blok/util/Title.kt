package com.deanveloper.blok.util

import java.time.Duration

data class Title(
        val title: String = "",
        val subTitle: String = "",
        val fadeIn: Duration = 0.5.seconds,
        val stay: Duration = 1.seconds,
        val fadeOut: Duration = 0.5.seconds
)
