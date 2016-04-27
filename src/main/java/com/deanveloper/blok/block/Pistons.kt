package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data

/**
 * File that stores piston-related classes
 *
 * @author Dean B
 */

/**
 * Represents a Piston
 */
class Piston(
		override var facing: Rotatable.Direction = Rotatable.Direction.DOWN,
		var sixSided: Boolean = false,
		var extended: Boolean = false
) : ItemData, BlockData, Rotatable {
	override val id = "piston"
	override val intId = 33
	override val extraData: Byte
		get() {
			var data: Int = 0
			if(sixSided) {
				data = data or 0x6
			} else {
				data = data or facing.direction
			}

			if(extended) data = data or 0x8

			return data.toByte()
		}

	override fun clone() = Piston(facing, sixSided, extended)
}

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
				data = data or facing.direction
			}

			if(extended) data = data or 0x8

			return data.toByte()
		}

	override fun clone() = StickyPiston(facing, sixSided, extended)
}

/**
 * Represents a Piston Head
 */
class PistonHead(
		override var facing: Rotatable.Direction = Rotatable.Direction.DOWN,
		var sticky: Boolean = false
) : BlockData, Rotatable {
	override val id = "piston_head"
	override val intId = 34
	override val extraData: Byte
		get() {
			var data: Int = facing.direction

			if(sticky) data = data or 0x8

			return data.toByte()
		}

	override fun clone() = PistonHead(facing, sticky)
}

/**
 * Represents a block that is being pushed by a Piston
 */
class PistonExtension(
		override var facing: Rotatable.Direction = Rotatable.Direction.DOWN,
		var extended: Boolean = false
) : BlockData, Rotatable {
	override val id = "piston_extension"
	override val intId = 36
	override val extraData: Byte
		get() {
			var data: Int = facing.direction

			if(extended) data = data or 0x8

			return data.toByte()
		}

	override fun clone() = PistonExtension(facing, extended)
}