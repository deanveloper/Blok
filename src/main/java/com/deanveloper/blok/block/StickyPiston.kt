package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData

/**
 * @author Dean B
 */
class StickyPiston(
		override var facing: Rotatable.Direction = Rotatable.Direction.DOWN,
        var sixSided: Boolean = false,
        var extended: Boolean = false
) : ItemData, BlockData, Rotatable {
	override val id = "sticky_piston"
	override val intId = 29
	override val extraData: Byte
		get() {
			var data: Int = 0
			if(sixSided) {
				data = data or 0x6
			} else {
				data = data or facing.ordinal
			}

			if(extended) data = data or 0x8

			return data.toByte()
		}

	override fun clone() = StickyPiston(facing, sixSided, extended)
}