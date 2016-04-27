package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a Wool block
 *
 * @author Dean B
 */
class Wool(override var color: DyeColor) : ItemData, BlockData, Colorable {
	override val id = "wool"
	override val intId = 35
	override val extraData: Nybble
		get() = color.ordinal.toNybble()

	override fun clone(): Data {
		throw UnsupportedOperationException()
	}

}

interface Colorable {
	var color: DyeColor
}

enum class DyeColor {

}
