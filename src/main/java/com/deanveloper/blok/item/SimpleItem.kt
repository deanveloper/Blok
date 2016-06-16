package com.deanveloper.blok.item

import com.deanveloper.blok.util.Magic
import com.deanveloper.blok.util.Nybble

/**
 * Data for an item
 *
 * @author Dean B
 */
open class SimpleItem(
    override val id: String
) : ItemData {
    override val intId = Magic.stringIdToInt(id)
    override var rawData = Nybble()
    override fun clone() = SimpleItem(id)
}
