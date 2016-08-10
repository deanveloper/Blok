package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * Represents a Sandstone block
 *
 * @author Dean B
 */
class Sandstone(type: SandstoneType = Sandstone.SandstoneType.NORMAL) : BlockData, ItemData {
    override val id = "sandstone"
    override val intId = 24
    override var rawData = Nibble()

    var type: SandstoneType by NibbleStorage(0b0011, type, { SandstoneType.values()[it] })

    override fun clone() = Sandstone(type)


    enum class SandstoneType {
        NORMAL,
        CHISELED,
        SMOOTH
    }
}
