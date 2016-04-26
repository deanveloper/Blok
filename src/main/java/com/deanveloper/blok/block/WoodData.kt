package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData

class PlankData(val type: WoodType = WoodType.OAK) : ItemData, BlockData {
	override fun clone() = PlankData(type)

	override val id = "planks"
	override val intId = 5
	override val extraData: Byte
		get() = type.ordinal.toByte()
}

class SaplingData(
		val type: WoodType = WoodType.OAK,
        val ready: Boolean = false
) : ItemData, BlockData {
	override fun clone() = PlankData(type)

	override val id = "sapling"
	override val intId = 5
	override val extraData: Byte
		get() = (if(ready) { type.ordinal or 0x8 } else { type.ordinal } ).toByte()
}

class LogData(
		val type: WoodType = WoodType.OAK,
		override val rotation: Rotatable.Direction = Rotatable.Direction.NORTH
) : ItemData, BlockData, Rotatable {
	override fun clone() = LogData(type)

	override val id: String
		get() = when(type) {
			WoodType.OAK, WoodType.SPRUCE,
			WoodType.BIRCH, WoodType.JUNGLE -> "log"

			WoodType.ACACIA, WoodType.DARK_OAK -> "log2"
		}

	override val intId: Int
		get() = when(id) {
			"log" -> 17
			"log2" -> 162
			else -> throw IllegalStateException("LogData is not a [log] or [log2]")
		}

	override val extraData: Byte
		get() {
			return (type.ordinal and 0x3 or (rotation.biDirection shl 2 and (0x4 or 0x8))).toByte()
		}
}

enum class WoodType {
	OAK,
	SPRUCE,
	BIRCH,
	JUNGLE,
	ACACIA,
	DARK_OAK
}