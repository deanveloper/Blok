package com.deanveloper.blok.block

import com.deanveloper.blok.util.Magic

/**
 * Data for a block
 */
class SimpleBlockData(
		override val id: String
) : BlockData {
	override val intId = Magic.stringIdToInt(id)
	override fun clone() = SimpleBlockData(id)
}

