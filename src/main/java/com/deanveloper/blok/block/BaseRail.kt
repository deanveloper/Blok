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
sealed class BaseRail(
		var shape: RailShape
) : ItemData, BlockData {

	class PoweredRail(
			shape: RailShape = RailShape.NORTH_SOUTH,
	        var powered: Boolean = false
	) : BaseRail(shape) {
		override val id = "golden_rail"
		override val intId = 27
		override val extraData: Byte
			get() {
				var data: Int = shape.ordinal

				if(powered) data = data or 0x8

				return data.toByte();
			}

		override fun clone() = PoweredRail(shape, powered)
	}

	class DetectorRail(
			shape: RailShape = RailShape.NORTH_SOUTH,
			var pressed: Boolean = false
	) : BaseRail(shape) {
		override val id = "detector_rail"
		override val intId = 28
		override val extraData: Byte
			get() {
				var data: Int = shape.ordinal

				if(pressed) data = data or 0x8

				return data.toByte();
			}

		override fun clone() = PoweredRail(shape, pressed)
	}

	enum class RailShape {
		NORTH_SOUTH,
		EAST_WEST,
		ASCENDING_NORTH,
		ASCENDING_SOUTH,
		ASCENDING_EAST,
		ASCENDING_WEST
	}
}