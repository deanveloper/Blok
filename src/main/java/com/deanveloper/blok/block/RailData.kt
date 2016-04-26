package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData

/**
 * Represents a rail
 *
 * @author Dean B
 *
 * @property[rotation]  The direction the rail is going
 * @property[rising]    The direction the rail is rising, [Rotatable.Direction.DOWN] if none
 */
sealed class RailData(
		override var rotation: Rotatable.Direction
) : BlockData, ItemData,  Rotatable {
	var rising: Rotatable.Direction = Rotatable.Direction.NORTH
		set(value) {
			if(rotation.ordinal / 2 != value.ordinal / 2)
				throw IllegalArgumentException("Cannot rise and face different directions!")
		}

	class PoweredRail(
			rotation: Rotatable.Direction = Rotatable.Direction.NORTH,
	        rising: Rotatable.Direction = Rotatable.Direction.NORTH,
	        var powered: Boolean = false
	) : RailData(rotation) {
		override val id = "golden_rail"
		override val intId = 27
		override val extraData: Byte
			get() {
				var data: Int = if(rising == Rotatable.Direction.DOWN) {
					when(rotation) {
						Rotatable.Direction.NORTH, Rotatable.Direction.SOUTH -> 0
						Rotatable.Direction.EAST, Rotatable.Direction.WEST -> 1
						else -> throw IllegalStateException("rotation cannot be UP or DOWN")
					}
				} else {
					when (rising) {
						Rotatable.Direction.EAST -> 2
						Rotatable.Direction.WEST -> 3
						Rotatable.Direction.NORTH -> 4
						Rotatable.Direction.SOUTH -> 5
						else -> throw IllegalStateException("rising cannot be UP")
					}
				}

				if(powered) data = data or 0x8

				return data.toByte();
			}

		init {
			this.rising = rising
		}

		override fun clone() = PoweredRail(rotation, rising, powered)
	}
}