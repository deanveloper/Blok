package com.deanveloper.blok.block

class Stone(var type: StoneType = Stone.StoneType.NORMAL) : ItemData, BlockData {
	override val id = "stone"
	override val intId = 1
	override val extraData: Byte
		get() = type.ordinal.toByte()

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