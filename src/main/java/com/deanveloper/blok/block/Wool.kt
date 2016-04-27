package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data

/**
 * Represents a Wool block
 *
 * @author Dean B
 */
class Wool(override var color: DyeColor) : ItemData, BlockData, Colorable {
	override val id = "wool"
	override val intId = 35
	override val extraData: Byte
		get() = color.ordinal.toByte()

	override fun clone(): Data {
		throw UnsupportedOperationException()
	}

}

interface Colorable {
	var color: DyeColor
}

enum class DyeColor {

}
