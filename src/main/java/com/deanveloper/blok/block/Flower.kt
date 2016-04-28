package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble

class Flower(var type: FlowerData = FlowerData.POPPY) : ItemData, BlockData {
	override val id = "red_flower"
	override val intId = 38
	override val extraData: Nybble
		get() = throw UnsupportedOperationException()

	override fun clone() = Flower(type)

	enum class FlowerData {
		POPPY,
		BLUE_ORCHID,
		ALLIUM,
		AZURE_BLUET,
		RED_TULIP,
		ORANGE_TULIP,
		WHITE_TULIP,
		PINK_TULIP,
		OXEYE_DAISY
	}
}