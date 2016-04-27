package com.deanveloper.blok.block

import com.deanveloper.blok.util.Data

/**
 * Represents a Sandstone block
 *
 * @author Dean B
 */
class Sandstone(var type: SandstoneType = Sandstone.SandstoneType.NORMAL) : BlockData, ItemData {
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
