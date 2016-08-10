package com.deanveloper.blok.block

/**
 * @author Dean B
 */
interface Rotatable<T : DirectionRepresentation> {
    var facing: T
}

interface DirectionRepresentation {
    val asInt: Int
}

enum class Direction : DirectionRepresentation {
    DOWN,
    UP,
    NORTH,
    SOUTH,
    WEST,
    EAST;

    override val asInt = ordinal
}

enum class BiDirection : DirectionRepresentation {
    UP_DOWN,
    EAST_WEST,
    NORTH_SOUTH;

    override val asInt = ordinal
}

enum class SidewaysDirection(override val asInt: Int) : DirectionRepresentation {
    NORTH(2),
    SOUTH(3),
    WEST(4),
    EAST(5);

    companion object {
        fun fromInt(i: Int): SidewaysDirection {
            return when(i) {
                2 -> NORTH
                3 -> SOUTH
                4 -> WEST
                5 -> EAST

                else -> throw IllegalArgumentException("Int $i does not map to a SidewaysDirection")
            }
        }
    }
}

enum class ManyDirection : DirectionRepresentation {
    SOUTH,
    SOUTH_SOUTH_WEST,
    SOUTH_WEST,
    WEST_SOUTH_WEST,
    WEST,
    WEST_NORTH_WEST,
    NORTH_WEST,
    NORTH_NORTH_WEST,
    NORTH,
    NORTH_NORTH_EAST,
    NORTH_EAST,
    EAST_NORTH_EAST,
    EAST,
    EAST_SOUTH_EAST,
    SOUTH_EAST,
    SOUTH_SOUTH_EAST;

    override val asInt = ordinal
}

interface RailDirection : DirectionRepresentation

enum class RigidRailDirection : RailDirection {
    NORTH_SOUTH,
    EAST_WEST,
    ASCENDING_NORTH,
    ASCENDING_SOUTH,
    ASCENDING_EAST,
    ASCENDING_WEST;

    override val asInt = ordinal
}

enum class BendableRailDirection : RailDirection {
    NORTH_SOUTH,
    EAST_WEST,
    ASCENDING_EAST,
    ASCENDING_WEST,
    ASCENDING_NORTH,
    ASCENDING_SOUTH,
    SOUTH_EAST,
    SOUTH_WEST,
    NORTH_WEST,
    NORTH_EAST;

    override val asInt = ordinal
}
