package com.deanveloper.blok.block

import com.deanveloper.blok.item.ItemData
import com.deanveloper.blok.util.BOOLEAN_MAPPER
import com.deanveloper.blok.util.Nybble
import com.deanveloper.blok.util.NybbleStorage

/**
 * Represents a rail
 *
 * @author Dean B
 *
 * @property[rotation]  The direction the rail is going
 * @property[rising]    The direction the rail is rising, [Rotatable.DirectionRepresentation.DOWN] if none
 */
sealed class BaseRail<T : RailDirection>(
        facing: T
) : ItemData, BlockData, Rotatable<T> {

    class PoweredRail(
            facing: RigidRailDirection = RigidRailDirection.NORTH_SOUTH,
            powered: Boolean = false
    ) : BaseRail<RigidRailDirection>(facing) {
        override val id = "golden_rail"
        override val intId = 27
        override var rawData = Nybble()

        var powered: Boolean by NybbleStorage(0b1000, powered, BOOLEAN_MAPPER)

        override var facing: RigidRailDirection by NybbleStorage(0b0111, facing) { RigidRailDirection.values()[it] }

        override fun clone() = PoweredRail(facing, powered)
    }

    class DetectorRail(
            facing: RigidRailDirection = RigidRailDirection.NORTH_SOUTH,
            pressed: Boolean = false
    ) : BaseRail<RigidRailDirection>(facing) {
        override val id = "detector_rail"
        override val intId = 28
        override var rawData = Nybble()

        var pressed: Boolean by NybbleStorage(0b1000, pressed, BOOLEAN_MAPPER)

        override var facing: RigidRailDirection by NybbleStorage(0b0111, facing) { RigidRailDirection.values()[it] }

        override fun clone() = DetectorRail(facing, pressed)
    }

    class Rail(
            facing: BendableRailDirection = BendableRailDirection.NORTH_SOUTH
    ) : BaseRail<BendableRailDirection>(facing) {
        override val id = "rail"
        override val intId = 66
        override var rawData = Nybble()

        override var facing by NybbleStorage(0b1111, facing) { BendableRailDirection.values()[it] }

        override fun clone() = Rail(facing)

    }
}
