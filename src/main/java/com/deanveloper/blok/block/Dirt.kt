package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData

class Dirt(val dirtType: DirtType = Dirt.DirtType.NORMAL) : BlockData, ItemData {
	override val id = "dirt"
	override val intId = 3
	override val extraData: Byte
		get() = dirtType.ordinal.toByte()

	override fun clone(): Dirt = Dirt(dirtType)


	enum class DirtType {
		NORMAL,
		COARSE,
		PODZOL
	}
}