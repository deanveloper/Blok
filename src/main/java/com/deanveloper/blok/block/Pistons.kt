package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.BOOLEAN_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
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
        facing: Direction = Direction.DOWN,
        extended: Boolean = false,
        val sticky: Boolean = false
) : ItemData, BlockData, Rotatable<Direction> {
    override val id = if(sticky) "sticky_piston" else "piston"
    override val intId = if(sticky) 29 else 33
    override var rawData = Nibble()

    override var facing: Direction by NibbleStorage(0b0111, facing, { Direction.values()[it] })

    var extended: Boolean by NibbleStorage(0b1000, extended, BOOLEAN_MAPPER)

    override fun clone() = Piston(facing, extended, sticky)
}

/**
 * Represents a Piston Head
 */
class PistonHead(
        facing: Direction = Direction.DOWN,
        sticky: Boolean = false
) : BlockData, Rotatable<Direction> {
    override val id = "piston_head"
    override val intId = 34
    override var rawData = Nibble()

    override var facing: Direction by NibbleStorage(0b0111, facing, { Direction.values()[it] })

    var sticky: Boolean by NibbleStorage(0b1000, sticky, BOOLEAN_MAPPER)

    override fun clone() = PistonHead(facing, sticky)
}

/**
 * Represents a block that is being pushed by a Piston
 */
class PistonExtension(
        facing: Direction = Direction.DOWN,
        extended: Boolean = false
) : BlockData, Rotatable<Direction> {
    override val id = "piston_extension"
    override val intId = 36
    override var rawData = Nibble()

    override var facing: Direction by NibbleStorage(0b0111, facing, { Direction.values()[it] })

    var extended: Boolean by NibbleStorage(0b1000, extended, BOOLEAN_MAPPER)

    override fun clone() = PistonExtension(facing, extended)
}
