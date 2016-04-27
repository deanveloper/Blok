package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

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
		var extended: Boolean = false
) : ItemData, BlockData, Rotatable {
	override val id = "piston"
	override val intId = 33
	override val extraData: Nybble
		get() {
			var data = facing.direction.toNybble()
			data[0b1000] = extended

			return data
		}

	override fun clone() = Piston(facing, extended)
}

class StickyPiston(
		override var facing: Rotatable.Direction = Rotatable.Direction.DOWN,
		var sixSided: Boolean = false,
		var extended: Boolean = false
) : ItemData, BlockData, Rotatable {
	override val id = "sticky_piston"
	override val intId = 29
	override val extraData: Nybble
		get() {
			var data = facing.direction.toNybble()
			data[0b1000] = extended

			return data
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
	override val extraData: Nybble
		get() {
			var data = facing.direction.toNybble()
			data[0b1000] = sticky

			return data
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
	override val extraData: Nybble
		get() {
			var data = facing.direction.toNybble()
			data[0b1000] = extended

			return data
		}

	override fun clone() = PistonExtension(facing, extended)
}