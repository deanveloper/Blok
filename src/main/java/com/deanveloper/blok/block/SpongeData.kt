package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData

/**
 * Represents a sponge
 *
 * @author Dean B
 */
class SpongeData(var wet: Boolean = false) : ItemData, BlockData {
	override val id = "sponge"
	override val intId = 19
	override val extraData: Byte
		get() = if(wet) 1 else 0

	override fun clone() = SpongeData(wet)
}