package com.deanveloper.blok.block

import com.deanveloper.blok.util.Data

/**
 * Represents a singular bed block
 *
 * @author Dean B
 */
class BedBlockData(override var rotation: Rotatable.Direction = Rotatable.Direction.NORTH,
                   var occupied: Boolean = false,
                   var isHead: Boolean = false) : BlockData, Rotatable {
	override val id = "bed"
	override val intId = 26
	override val extraData: Byte
		get() {
			var data: Int = when (rotation) {
				Rotatable.Direction.SOUTH -> 0
				Rotatable.Direction.WEST -> 1
				Rotatable.Direction.NORTH -> 2
				Rotatable.Direction.EAST -> 3
				else -> throw IllegalStateException("Bed rotation cannot be UP or DOWN")
			}
			if(occupied) data = data or 0x4
			if(isHead) data = data or 0x8

			return data.toByte()
		}

	override fun clone() = BedBlockData(rotation, occupied, isHead)

}