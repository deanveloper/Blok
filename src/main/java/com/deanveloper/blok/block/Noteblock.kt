package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.placeholders.Note
import com.deanveloper.blok.util.toNybble

class Noteblock(
		var powered: Boolean = false,
		var note: Note = Note.F_SHARP
) : ItemData, BlockData {
	override val id = "noteblock"
	override val intId = 25
	override val extraData = 0.toNybble()

	override fun clone() = Noteblock(powered, note)
}