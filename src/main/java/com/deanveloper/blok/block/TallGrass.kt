package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData

/**
 * @author Dean B
 */
class TallGrass(
		var type: GrassType = TallGrass.GrassType.SHRUB
) : ItemData, BlockData {
	override val id = "tallgrass"
	override val intId = 31
	override val extraData: Byte
		get() = type.ordinal.toByte()

	override fun clone() = TallGrass(type)


	enum class GrassType {
		SHRUB,
		TALL_GRASS,
		FERN
	}
}