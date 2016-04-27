package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Describes a sand block
 *
 * @author Dean B
 */
class Sand(val red: Boolean = false) : BlockData, ItemData {
	override val id = "sand"
	override val intId = 12
	override val extraData: Nybble
		get() = (if (red) 1 else 0).toNybble()

	override fun clone() = Sand(red)

}