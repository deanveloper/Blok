package com.deanveloper.blok.block

/**
 * Describes a sand block
 *
 * @author Dean B
 */
class Sand(val red: Boolean = false) : BlockData, ItemData {
	override val id = "sand"
	override val intId = 12
	override val extraData: Byte
		get() = if (red) 1 else 0

	override fun clone() = Sand(red)

}