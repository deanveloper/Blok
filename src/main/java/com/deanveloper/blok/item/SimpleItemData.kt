package com.deanveloper.blok.item

import com.deanveloper.blok.util.Magic

/**
 * Data for an item
 *
 * @author Dean B
 */
open class SimpleItemData(
		override val id: String
) : ItemData {
	override val intId = Magic.stringIdToInt(id)
	override val extraData: Byte = 0
	override fun clone() = SimpleItemData(id)
}