package com.deanveloper.blok.item

import com.deanveloper.blok.block.BlockData
import com.deanveloper.blok.util.Magic
import com.deanveloper.blok.util.Nybble

/**
 * @author Dean B
 */
class SimpleItemBlock(
        override val id: String,
        override val intId: Int = Magic.stringIdToInt(id)
) : ItemData, BlockData {
    override var rawData = Nybble()

    override fun clone(): SimpleItemBlock = SimpleItemBlock(id)
}
