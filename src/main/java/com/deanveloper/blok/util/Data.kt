package com.deanveloper.blok.util

/**
 * @author Dean B
 */
interface Data : Cloneable {
	val id: String
	@Deprecated("Magic Value") val intId: Int
	@Deprecated("Magic Value") val extraData: Byte

	override public fun clone(): Data
}