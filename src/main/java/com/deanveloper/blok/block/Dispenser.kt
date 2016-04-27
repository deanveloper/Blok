package com.deanveloper.blok.block

import com.deanveloper.blok.util.Data

/**
 * Represents a dispenser
 *
 * @author Dean B
 */
class Dispenser(
		override var facing: Rotatable.Direction = Rotatable.Direction.NORTH,
		var powered: Boolean = false
) : ItemData, BlockData, Rotatable {
	override val id = "dispenser"
	override val intId = 23
	override val extraData: Byte
		get() {
			var data: Int = facing.direction
			if(powered) data = data or 0x8

			return data.toByte()
		}

	override fun clone() = Dispenser(facing, powered)

}