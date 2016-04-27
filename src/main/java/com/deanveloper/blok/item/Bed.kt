package com.deanveloper.blok.item

import com.deanveloper.blok.block.Rotatable
import com.deanveloper.blok.util.DoubleData

/**
 * Represents a bed item
 *
 * @author Dean B
 */
class Bed(override var facing: Rotatable.Direction = Rotatable.Direction.NORTH,
          var occupied: Boolean = false,
          var isHead: Boolean = false
) : DoubleData(355, 26), Rotatable {
	override val id = "bed"

	override val extraData: Byte
		get() {
			if(isItem) return 0

			var data: Int = when (facing) {
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

	override fun clone() = Bed()
}
