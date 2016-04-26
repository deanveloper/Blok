package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData

class StoneData(var type: StoneType = StoneData.StoneType.NORMAL) : ItemData, BlockData {
	override val id = "stone"
	override val intId = 1
	override val extraData: Byte
		get() = type.ordinal.toByte()

	override fun clone() = StoneData(type);

	enum class StoneType {
		NORMAL,
		GRANITE,
		POLISHED_GRANITE,
		DIORITE,
		POLISHED_DIORITE,
		ANDESITE,
		POLISHED_ANDESITE
	}
}