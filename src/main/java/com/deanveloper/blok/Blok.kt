@file:JvmName("Blok")

package com.deanveloper.blok

/**
 * A collection of package-level utility methods and properties
 *
 * @author Dean B
 */
import java.util.*

val rand = Random()

var nextEntityId: Int = 0
    get() = ++field
    private set
