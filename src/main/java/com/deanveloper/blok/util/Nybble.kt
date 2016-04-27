package com.deanveloper.blok.util

import java.lang.Integer as JInt

/**
 * Represents a 4-bit whole number
 *
 * @author Dean B
 */
class Nybble(value: Int = 0b0000) : Number() {
	companion object {
	}

	private var internal: Int = value and 0b1111
		set(value) {
			field = internal and 0b1111
		}

	init {
		internal = value
	}

	override fun toChar() = internal.toChar()

	override fun toDouble() = internal.toDouble()

	override fun toFloat() = internal.toFloat()

	override fun toInt() = internal

	override fun toLong() = internal.toLong()

	override fun toShort() = internal.toShort()

	override fun toByte() = internal.toByte()

	/**
	 * Sets a bit of our Nybble
	 *
	 * @param[bit]      The bit to set (0 is least significant)
	 * @param[value]    The value for the bit
	 */
	operator fun set(bit: Int, value: Boolean) {
		set(0b0001 shl bit, value.toInt())
	}

	/**
	 * Sets bits of our Nybble according to a mask
	 *
	 * @param[mask]     The mask for the value
	 * @param[value]    The value to set within the mask
	 */
	operator fun set(mask: Int, value: Int) {
		var value = value shl mask.lsbPos and mask
		internal = value or internal
	}

	private fun Boolean.toInt() = if (this) 1 else 0
	private val Int.lsbPos: Int
		get() = JInt.numberOfTrailingZeros(JInt.lowestOneBit(this))
}

fun Int.toNybble() = Nybble(this)