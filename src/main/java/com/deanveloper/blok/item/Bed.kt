package com.deanveloper.blok.item

import com.deanveloper.blok.block.Rotatable
import com.deanveloper.blok.util.DoubleData
import com.deanveloper.blok.util.Nybble

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

	override val extraData: Nybble
		get() {
			var data = Nybble()
			if(isItem) return data

			data[0b0011] = when (facing) {
				Rotatable.Direction.SOUTH -> 0
				Rotatable.Direction.WEST -> 1
				Rotatable.Direction.NORTH -> 2
				Rotatable.Direction.EAST -> 3
				else -> throw IllegalStateException("Bed rotation cannot be UP or DOWN")
			}
			data[2] = occupied
			data[3] = isHead

			return data
		}

	override fun clone() = Bed()
}
