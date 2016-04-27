package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a sponge
 *
 * @author Dean B
 */
class Sponge(var wet: Boolean = false) : ItemData, BlockData {
	override val id = "sponge"
	override val intId = 19
	override val extraData: Nybble
		get() = (if(wet) 1 else 0).toNybble()

	override fun clone() = Sponge(wet)
}