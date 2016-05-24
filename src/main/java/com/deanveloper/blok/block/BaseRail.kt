package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.toNybble

/**
 * Represents a rail
 *
 * @author Dean B
 *
 * @property[rotation]  The direction the rail is going
 * @property[rising]    The direction the rail is rising, [Rotatable.DirectionRepresentation.DOWN] if none
 */
sealed class BaseRail(
    var shape: RailShape
) : ItemData, BlockData {

    class PoweredRail(
        shape: RailShape = RailShape.NORTH_SOUTH,
        var powered: Boolean = false
    ) : BaseRail(shape) {
        override val id = "golden_rail"
        override val intId = 27
        override val extraData: Nybble
            get() {
                var data = shape.ordinal.toNybble()
                data[0b1000] = powered

                return data
            }

        override fun clone() = PoweredRail(shape, powered)
    }

    class DetectorRail(
        shape: RailShape = RailShape.NORTH_SOUTH,
        var pressed: Boolean = false
    ) : BaseRail(shape) {
        override val id = "detector_rail"
        override val intId = 28
        override val extraData: Nybble
            get() {
                var data = shape.ordinal.toNybble()
                data[0b1000] = pressed

                return data
            }

        override fun clone() = DetectorRail(shape, pressed)
    }

    enum class RailShape {
        NORTH_SOUTH,
        EAST_WEST,
        ASCENDING_NORTH,
        ASCENDING_SOUTH,
        ASCENDING_EAST,
        ASCENDING_WEST
    }
}
