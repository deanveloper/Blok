@file:Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.deanveloper.blok.util

import java.lang.ref.Reference
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import java.lang.Integer as JInt

/**
 * Represents a 4-bit whole number
 *
 * @author Dean B
 */
class Nybble @JvmOverloads constructor(value: Int = 0b0000) : Number() {
    private val position: Int
    private var raw: AtomicInteger

    private var internal: Int
        get() {
            return raw.get() ushr (position) and 0b1111
        }
        set(value) {
            raw.set(raw.get() or (value shl position))
        }

    companion object {
        @JvmStatic private val lastNybble: Nybble? = null
    }

    init {
        if(lastNybble == null || lastNybble.position == 3) {
            position = 0
            raw = AtomicInteger(0)
        } else {
            position = lastNybble.position + 1
            raw = lastNybble.raw
        }
    }

    constructor(byte: Byte) : this(byte.toInt())

    override fun toChar() = internal.toChar()
    override fun toDouble() = internal.toDouble()
    override fun toFloat() = internal.toFloat()
    override fun toInt() = internal
    override fun toLong() = internal.toLong()
    override fun toShort() = internal.toShort()
    override fun toByte() = internal.toByte()

    /**
     * Sets bits of our Nybble to a certain value
     *
     * @param[mask]     The bits to set
     * @param[value]    The value for the bit
     */
    operator fun set(mask: Int, value: Boolean) {
        if (value) {
            internal or mask
        } else {
            internal and mask.inv()
        }
    }

    /**
     * Sets bits of our Nybble to an integer value
     *
     * @param[mask]     The bits we are setting
     * @param[value]    The number to set the bits to
     */
    operator fun set(mask: Int, value: Int) {
        @Suppress("NAME_SHADOWING")
        var value = value shl mask.lsbPos
        value = value.inv() and mask
        internal = internal xor value
    }

    operator fun get(mask: Int): Int {
        return internal shr mask.lsbPos
    }
}

fun Int.toNybble() = Nybble(this)

val Int.lsbPos: Int
    get() = JInt.numberOfTrailingZeros(JInt.lowestOneBit(this))

val Int.msbPos: Int
    get() = JInt.numberOfTrailingZeros(JInt.highestOneBit(this))