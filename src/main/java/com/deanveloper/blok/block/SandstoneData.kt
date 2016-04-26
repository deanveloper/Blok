package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data

/**
 * Represents a Sandstone block
 *
 * @author Dean B
 */
class SandstoneData(var type: SandstoneType = SandstoneData.SandstoneType.NORMAL) : BlockData, ItemData {
	override val id = "sandstone"
	override val intId = 24
	override val extraData: Byte
		get() = type.ordinal.toByte()

	override fun clone(): Data {
		throw UnsupportedOperationException()
	}


	enum class SandstoneType {
		NORMAL,
		CHISELED,
		SMOOTH
	}
}
