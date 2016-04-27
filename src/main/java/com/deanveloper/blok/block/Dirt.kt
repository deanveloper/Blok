package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

class Dirt(val dirtType: DirtType = Dirt.DirtType.NORMAL) : BlockData, ItemData {
	override val id = "dirt"
	override val intId = 3
	override val extraData: Nybble
		get() = dirtType.ordinal.toNybble()

	override fun clone(): Dirt = Dirt(dirtType)


	enum class DirtType {
		NORMAL,
		COARSE,
		PODZOL
	}
}