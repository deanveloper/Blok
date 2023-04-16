package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nibble
import com.deanveloper.blok.util.NibbleStorage
import com.deanveloper.blok.util.toNybble

/**
 * Represents a sign
 *
 * @author Dean B
 */
class Sign(
        val signType: SignType,
        facing: ManyDirection = ManyDirection.SOUTH
) : ItemData, BlockData, Rotatable<ManyDirection> {
    override val id: String
        get() = signType.id
    override val intId: Int
        get() = signType.intId
    override var rawData = Nibble()

    override var facing: ManyDirection by NibbleStorage(0b1111, facing) {
        when(signType) {
            SignType.ITEM -> ManyDirection.SOUTH
            SignType.STANDING -> ManyDirection.values()[it]
            SignType.WALL -> ManyDirection.valueOf(SidewaysDirection.values()[it].name)
        }
    }

    override fun clone() = Sign(signType, facing)

    enum class SignType(val id: String, val intId: Int) {
        ITEM("sign", 323),
        STANDING("standing_sign", 63),
        WALL("wall_sign", 68)
    }
}
