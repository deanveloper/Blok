package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

class Stone(var type: StoneType = Stone.StoneType.NORMAL) : ItemData, BlockData {
	override val id = "stone"
	override val intId = 1
	override val extraData: Nybble
		get() = type.ordinal.toNybble()

	override fun clone() = Stone(type);

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