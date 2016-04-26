package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData

class DirtData(val dirtType: DirtType = DirtData.DirtType.NORMAL) : BlockData, ItemData {
	override val id = "dirt"
	override val intId = 3

	override fun clone(): DirtData = DirtData(dirtType)


	enum class DirtType {
		NORMAL,
		COARSE,
		PODZOL
	}
}