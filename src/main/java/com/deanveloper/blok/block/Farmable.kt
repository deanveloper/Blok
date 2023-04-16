package com.deanveloper.blok.block

/**
 * Represents farmable blocks
 *
 * @author Dean B
 */
interface Farmable {
    var growth: Growth

    enum class Growth {
        JUST_PLANTED,
        VERY_SMALL,
        SMALL,
        HALFWAY,
        TALL,
        VERY_TALL,
        ALMOST_GROWN,
        GROWN
    }
}
