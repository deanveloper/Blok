package com.deanveloper.blok.util

/**
 * @author Dean B
 */
interface Data : Cloneable {
	val id: String
	@Deprecated("Magic Value") val intId: Int
	@Deprecated("Magic Value") val extraData: Nybble

	override public fun clone(): Data
}

abstract class SeparatedData(
		val itemIntId: Int,
		val blockIntId: Int
) : Data {
	var isItem: Boolean = true
	var isBlock: Boolean
		get() = !isItem
		set(value) {
			isItem = !value
		}

	override final val intId: Int
		get() = if(isItem) itemIntId else blockIntId
}