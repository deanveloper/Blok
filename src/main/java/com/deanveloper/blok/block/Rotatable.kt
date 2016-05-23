package com.deanveloper.blok.block

import com.deanveloper.blok.util.VarDelegate
import kotlin.reflect.KProperty

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

class SidewaysRotatable(init: Rotatable.Direction) : VarDelegate<Rotatable.Direction> {
    lateinit var field: Rotatable.Direction

    init {
        when(init) {
            Rotatable.Direction.DOWN,
            Rotatable.Direction.UP -> throw IllegalArgumentException("Sideways Rotatable materials cannot face $init")

            else -> field = init
        }
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Rotatable.Direction) {
        when(value) {
            Rotatable.Direction.DOWN,
            Rotatable.Direction.UP -> throw IllegalArgumentException("Sideways Rotatable materials cannot face $value")

            else -> field = value
        }
        field = value
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): Rotatable.Direction {
        return field
    }

}
