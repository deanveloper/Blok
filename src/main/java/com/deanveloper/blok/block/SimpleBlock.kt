package com.deanveloper.blok.block

import com.deanveloper.blok.util.Magic
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Data for a block
 */
class SimpleBlock(
		override val id: String
) : BlockData {
	override val intId = Magic.stringIdToInt(id)
	override val extraData: Nybble = 0.toNybble()
	override fun clone() = SimpleBlock(id)
}

