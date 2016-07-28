package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
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
        override var facing: Direction = Direction.DOWN,
        var extended: Boolean = false
) : ItemData, BlockData, Rotatable<Direction> {
    override val id = "piston"
    override val intId = 33
    override val rawData: Nybble
        get() {
            val data = facing.asInt.toNybble()
            data[0b1000] = extended

            return data
        }

    override fun clone() = Piston(facing, extended)
}

class StickyPiston(
        override var facing: Direction = Direction.DOWN,
        var sixSided: Boolean = false,
        var extended: Boolean = false
) : ItemData, BlockData, Rotatable<Direction> {
    override val id = "sticky_piston"
    override val intId = 29
    override val rawData: Nybble
        get() {
            val data = facing.asInt.toNybble()
            data[0b1000] = extended

            return data
        }

    override fun clone() = StickyPiston(facing, sixSided, extended)
}

/**
 * Represents a Piston Head
 */
class PistonHead(
        override var facing: Direction = Direction.DOWN,
        var sticky: Boolean = false
) : BlockData, Rotatable<Direction> {
    override val id = "piston_head"
    override val intId = 34
    override val rawData: Nybble
        get() {
            val data = facing.asInt.toNybble()
            data[0b1000] = sticky

            return data
        }

    override fun clone() = PistonHead(facing, sticky)
}

/**
 * Represents a block that is being pushed by a Piston
 */
class PistonExtension(
        override var facing: Direction = Direction.DOWN,
        var extended: Boolean = false
) : BlockData, Rotatable<Direction> {
    override val id = "piston_extension"
    override val intId = 36
    override val rawData: Nybble
        get() {
            val data = facing.asInt.toNybble()
            data[0b1000] = extended

            return data
        }

    override fun clone() = PistonExtension(facing, extended)
}
