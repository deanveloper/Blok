package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.BOOLEAN_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage

/**
 * @author Dean
 */
class Button(
        val type: ButtonType = Button.ButtonType.STONE,
        facing: Direction = Direction.DOWN,
        powering: Boolean = false
) : BlockData, ItemData, BinaryPowerSource, Rotatable<Direction> {
    override val id = "${type.id}_button"
    override var facing: Direction by NibbleStorage(0b0111, facing, { Direction.values()[it] })
    override val intId = type.intId
    override var rawData = Nibble()

    override var powering: Boolean by NibbleStorage(0b1000, powering, BOOLEAN_MAPPER)

    override fun clone() = Button(type, facing, powering)

    enum class ButtonType(val id: String, val intId: Int) {
        STONE("stone", 77),
        OAK("wooden", 143)
    }
}
