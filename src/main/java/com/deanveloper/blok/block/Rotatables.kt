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
