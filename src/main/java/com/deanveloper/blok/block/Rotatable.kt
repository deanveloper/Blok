package com.deanveloper.blok.block

/**
 * @author Dean B
 */
interface Rotatable {
	var facing: Direction

	enum class Direction(val direction: Int, val biDirection: Int) {
		DOWN(0, 0),
		UP(1, 0),
		NORTH(2, 2),
		SOUTH(3, 2),
		WEST(4, 1),
		EAST(5, 1);
	}
}
