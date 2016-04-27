package com.deanveloper.blok.block

import com.deanveloper.blok.util.Magic

/**
 * Data for a block
 */
class SimpleBlock(
		override val id: String
) : BlockData {
	override val intId = Magic.stringIdToInt(id)
	override val extraData: Byte = 0
	override fun clone() = SimpleBlock(id)
}

