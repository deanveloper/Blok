package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData


sealed class WoodData(var type: WoodType) : ItemData, BlockData {
	class PlankData(type: WoodType = WoodType.OAK) : WoodData(type) {
		override fun clone() = PlankData(type)

		override val id = "planks"
		override val intId = 5
		override val extraData: Byte
			get() = type.ordinal.toByte()
	}

	class SaplingData(
			type: WoodType = WoodType.OAK,
			var ready: Boolean = false
	) : WoodData(type) {
		override fun clone() = PlankData(type)

		override val id = "sapling"
		override val intId = 5
		override val extraData: Byte
			get() {
				if (ready) {
					return (type.ordinal or 0x8).toByte()
				} else {
					return type.ordinal.toByte()
				}
			}
	}

	sealed class DoubleWoodData(
			type: WoodType,
			val id1: String,
			val id2: String,
			val intId1: Int,
			val intId2: Int
	) : WoodData(type) {

		//region Variables/Values
		val isFirst: Boolean
			get() = when (type) {
				WoodType.OAK, WoodType.SPRUCE,
				WoodType.BIRCH, WoodType.JUNGLE -> true

				else -> false
			}

		final override val id: String
			get() = if (isFirst) id1 else id2

		final override val intId: Int
			get() = if(isFirst) intId1 else intId2
		//endregion

		class LogData(
				type: WoodType = WoodType.OAK,
				override var rotation: Rotatable.Direction = Rotatable.Direction.NORTH
		) : DoubleWoodData(type, "log", "log2", 17, 162), Rotatable {
			override fun clone() = LogData(type)

			override val extraData: Byte
				get() {
					var data: Int = type.ordinal
					if (!isFirst) data = type.ordinal - 4

					data = data and (0x1 or 0x2)

					data = data or (rotation.biDirection shl 2 and (0x4 or 0x8))

					return data.toByte()
				}
		}

		class LeafData(
				type: WoodType = WoodType.OAK,
				var noDecay: Boolean = false,
				var checkDecay: Boolean = true
		) : DoubleWoodData(type, "leaves", "leaves2", 17, 162) {
			override val extraData: Byte
				get() {
					var data: Int = type.ordinal

					if (!isFirst) {
						data = type.ordinal - 4
					}

					if (noDecay) data = data or 0x4
					if (checkDecay) data = data or 0x8

					return data.toByte()
				}

			override fun clone() = LeafData(type, noDecay, checkDecay);
		}
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