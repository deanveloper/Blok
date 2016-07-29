package com.deanveloper.blok.item

import com.deanveloper.blok.util.BYTE_MAPPER
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NybbleStorage
import com.deanveloper.blok.util.SeparatedData

/**
 * @author Dean B
 */
class Redstone(power: Byte = 0) : SeparatedData(331, 55) {
    constructor(power: Int) : this(power.toByte())

    override val id: String
        get() = if (isItem) "redstone" else "redstone_wire"
    override var rawData = Nibble()

    var power: Byte by NybbleStorage(0b1111, power, BYTE_MAPPER)

    override fun clone() = Redstone(power)

}
