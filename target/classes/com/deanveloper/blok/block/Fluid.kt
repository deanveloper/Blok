package com.deanveloper.blok.block

import com.deanveloper.blok.item.Material
import com.deanveloper.blok.util.*

/**
 * @author Dean B
 */
class Fluid(
        val type: Material,
        distance: Byte = 0,
        downward: Boolean = false
) : BlockData {
    override val id = when (type) {
        Material.FLOWING_WATER, Material.FLOWING_LAVA -> type.name.toLowerCase()
        else -> throw IllegalStateException("[type] is not flowing water/lava (is $type)")
    }

    override val intId: Int
        get() = when (type) {
            Material.FLOWING_WATER -> 8
            Material.FLOWING_LAVA -> 10
            else -> throw IllegalStateException("[type] is not flowing water/lava (is $type)")
        }

    override var rawData = Nibble()

    var distance: Byte by NibbleStorage(0b0111, distance, BYTE_MAPPER)

    var downward: Boolean by NibbleStorage(0b0111, downward, BOOLEAN_MAPPER)

    override fun clone() = Fluid(type, distance, downward)

}
