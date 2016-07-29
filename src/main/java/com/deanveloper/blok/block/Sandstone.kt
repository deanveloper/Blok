package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a Sandstone block
 *
 * @author Dean B
 */
class Sandstone(var type: SandstoneType = Sandstone.SandstoneType.NORMAL) : BlockData, ItemData {
    override val id = "sandstone"
    override val intId = 24
    override val rawData: Nibble
        get() = type.ordinal.toNybble()

    override fun clone() = Sandstone(type)


    enum class SandstoneType {
        NORMAL,
        CHISELED,
        SMOOTH
    }
}
