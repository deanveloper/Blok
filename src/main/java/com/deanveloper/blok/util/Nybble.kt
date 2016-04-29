package com.deanveloper.blok.util

import java.lang.Integer as JInt

/**
 * Represents a 4-bit whole number
 *
 * @author Dean B
 */
class Nybble @JvmOverloads constructor(value: Int = 0b0000) : Number() {
	private var internal: Int = value and 0b1111
		set(value) {
			field = internal and 0b1111
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
	 * @param[mask]     The bits to set
	 * @param[value]    The value for the bit
	 */
	operator fun set(mask: Int, value: Boolean) {
		if(value) {
			internal or mask
		} else {
			internal and mask.inv()
		}
	}

	operator fun set(mask: Int, value: Int) {
		var value = value shl mask.lsbPos
		value = value and mask
		internal = internal xor value
	}

	private fun Boolean.toInt() = if (this) 1 else 0
	private val Int.lsbPos: Int
		get() = JInt.numberOfTrailingZeros(JInt.lowestOneBit(this))
}

fun Int.toNybble() = Nybble(this)