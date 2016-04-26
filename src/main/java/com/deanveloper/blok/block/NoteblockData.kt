package com.deanveloper.blok.block

import com.deanveloper.blok.block.BlockData
import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.placeholders.Note

class NoteblockData(
		var powered: Boolean = false,
		var note: Note = Note.F_SHARP
) : ItemData, BlockData {
	override val id = "noteblock"
	override val intId = 25
	override val extraData: Byte = 0

	override fun clone() = NoteblockData(powered, note)
}