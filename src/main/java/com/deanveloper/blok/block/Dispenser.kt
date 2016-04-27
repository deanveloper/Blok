package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

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
	override val extraData: Nybble
		get() {
			val data = facing.direction.toNybble()
			data[0b1000] = powered

			return data
		}

	override fun clone() = Dispenser(facing, powered)

}