package com.deanveloper.blok.item

import com.deanveloper.blok.block.Rotatable
import com.deanveloper.blok.util.Data

/**
 * Represents a bed item
 *
 * @author Dean B
 */
class BedItemData() : ItemData {
	override val id = "bed"
	override val intId = 355
	override val extraData: Byte = 0

	override fun clone() = BedItemData()
}
