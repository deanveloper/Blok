package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a sign
 *
 * @author Dean B
 */
class Sign(
    val signType: SignType,
    override var facing: ManyDirection = ManyDirection.SOUTH
) : ItemData, BlockData, Rotatable<ManyDirection> {
    override val id: String
        get() = signType.id
    override val intId: Int
        get() = signType.intId
    override val extraData: Nybble
        get() {
            when (signType) {
                SignType.ITEM -> {
                    return 0.toNybble()
                }

                SignType.STANDING -> {
                    return facing.asInt.toNybble()
                }

                SignType.WALL -> {
                    if (facing.name in SidewaysDirection.values().map { it.name }) {
                        return SidewaysDirection.valueOf(facing.name).asInt.toNybble()
                    } else {
                        return SidewaysDirection.NORTH.asInt.toNybble()
                    }
                }
            }
        }

    override fun clone() = Sign(signType, facing)

    enum class SignType(val id: String, val intId: Int) {
        ITEM("sign", 323),
        STANDING("standing_sign", 63),
        WALL("wall_sign", 68)
    }
}
