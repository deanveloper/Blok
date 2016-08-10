package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.placeholders.Note
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.toNybble

class Noteblock(
        var powered: Boolean = false,
        var note: Note = Note.F_SHARP
) : ItemData, BlockData {
    override val id = "noteblock"
    override val intId = 25
    override var rawData = Nibble()

    override fun clone() = Noteblock(powered, note)
}
