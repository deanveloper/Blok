package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.Data
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
sealed class BaseRail<T : RailDirection>(
    override var facing: T
) : ItemData, BlockData, Rotatable<T> {

    class PoweredRail(
        facing: RigidRailDirection = RigidRailDirection.NORTH_SOUTH,
        var powered: Boolean = false
    ) : BaseRail<RigidRailDirection>(facing) {
        override val id = "golden_rail"
        override val intId = 27
        override val extraData: Nybble
            get() {
                var data = facing.asInt.toNybble()
                data[0b1000] = powered

                return data
            }

        override fun clone() = PoweredRail(facing, powered)
    }

    class DetectorRail(
        facing: RigidRailDirection = RigidRailDirection.NORTH_SOUTH,
        var pressed: Boolean = false
    ) : BaseRail<RigidRailDirection>(facing) {
        override val id = "detector_rail"
        override val intId = 28
        override val extraData: Nybble
            get() {
                val data = facing.asInt.toNybble()
                data[0b1000] = pressed

                return data
            }

        override fun clone() = DetectorRail(facing, pressed)
    }

    class Rail(
        facing: BendableRailDirection = BendableRailDirection.NORTH_SOUTH
    ) : BaseRail<BendableRailDirection>(facing) {
        override val id = "rail"
        override val intId = 66
        override val extraData: Nybble
            get() = facing.asInt.toNybble()

        override fun clone() = Rail(facing)

    }
}
