package com.deanveloper.blok.item

import com.deanveloper.blok.block.BlockData
import com.deanveloper.blok.util.Magic
import com.deanveloper.blok.util.Data

/**
 * @author Dean B
 */
class SimpleItemBlock(
		override val id: String
) : ItemData, BlockData {
	override val intId = Magic.stringIdToInt(id)
	override val extraData: Byte = 0

	override fun clone(): SimpleItemBlock = SimpleItemBlock(id)
}