package com.deanveloper.blok.block

import com.deanveloper.blok.placeholders.Note

class Noteblock(
		var powered: Boolean = false,
		var note: Note = Note.F_SHARP
) : ItemData, BlockData {
	override val id = "noteblock"
	override val intId = 25
	override val extraData: Byte = 0

	override fun clone() = Noteblock(powered, note)
}