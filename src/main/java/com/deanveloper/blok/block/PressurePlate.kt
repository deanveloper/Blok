package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.BYTE_MAPPER
import com.deanveloper.blok.util.Data
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage

/**
 * Represents a pressure plate
 *
 * @author Dean B
 */
class PressurePlate(
        val type: PlateType = PressurePlate.PlateType.STONE,
        output: Byte = 0
) : ItemData, BlockData, PowerSource {
    override val id = type.id
    override val intId = type.intId
    override var rawData = Nibble()

    override var output: Byte by NibbleStorage(0b1111, output, BYTE_MAPPER)

    override fun clone(): PressurePlate = PressurePlate(type, output)

    enum class PlateType(val id: String, val intId: Int) {
        STONE("stone_pressure_plate", 70),
        WOOD("stone_pressure_plate", 72),
        IRON("heavy_weighted_pressure_plate", 148),
        GOLD("light_weighted_pressure_plate", 147)
    }
}
