package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * @author Dean B
 */
class Torch(
		facing: Rotatable.Direction = Rotatable.Direction.UP
) : ItemData, BlockData, Rotatable {
	override val id = "torch"
	override val intId = 50

	override var facing = facing
		set(value) {
			if(value == Rotatable.Direction.DOWN) field = Rotatable.Direction.UP
			field = value
		}

	override val extraData: Nybble
		get() = (6 - facing.direction).toNybble()

	override fun clone() = Torch(facing)

}
