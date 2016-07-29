@file:Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.deanveloper.blok.util

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference
import java.lang.Integer as JInt

/**
 * Represents a 4-bit whole number
 *
 * @author Dean B
 */
class Nybble @JvmOverloads constructor(value: Int = 0b0000) : Number() {
    private val position: Int
    private val raw: AtomicInteger

    private var extracted: Int
        get() = (raw.get() ushr position) and 0b1111
        set(value) = raw.set((value and 0b1111) shl position)

    companion object {
        @JvmStatic private val lastCreated: AtomicReference<Nybble?> = AtomicReference(null)
    }

    init {
        val lastNybble = lastCreated.getAndSet(this)
        if (lastNybble == null || lastNybble.position == 12) {
            position = 0
            raw = AtomicInteger(0)
        } else {
            position = lastNybble.position + 4
            raw = lastNybble.raw
        }
        extracted = value
    }

    constructor(byte: Byte) : this(byte.toInt())

    override fun toChar() = extracted.toChar()
    override fun toDouble() = extracted.toDouble()
    override fun toFloat() = extracted.toFloat()
    override fun toInt() = extracted
    override fun toLong() = extracted.toLong()
    override fun toShort() = extracted.toShort()
    override fun toByte() = extracted.toByte()

    /**
     * Sets bits of our Nybble to a certain value
     *
     * @param[mask]     The bits to set
     * @param[value]    The value for the bit
     */
    operator fun set(mask: Int, value: Boolean) {
        val internal = extracted
        if (value) {
            extracted = internal or mask
        } else {
            extracted = internal and mask.inv()
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
        val internal = extracted
        extracted = internal xor value
    }

    operator fun get(mask: Int): Int {
        return extracted shr mask.lsbPos
    }
}

fun Int.toNybble() = Nybble(this)

val Int.lsbPos: Int
    get() = JInt.numberOfTrailingZeros(JInt.lowestOneBit(this))

val Int.msbPos: Int
    get() = JInt.numberOfTrailingZeros(JInt.highestOneBit(this))