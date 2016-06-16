package com.deanveloper.blok.block

import com.deanveloper.blok.item.Material
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * @author Dean B
 */
class Fluid(
    val type: Material,
    var distance: Int = 0,
    var downward: Boolean = false
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

    override val rawData: Nybble
        get() {
            val data = distance.toNybble()
            data[0b1000] = downward

            return data
        }

    override fun clone() = Fluid(type, distance, downward)

}
