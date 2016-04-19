package com.deanveloper.blok.util

import com.deanveloper.blok.placeholders.World

abstract class Location(
		open val world: World,
		x: Double,
		y: Double,
		z: Double
) : Vector(x, y, z) {
	override fun toString(): String = "${javaClass.simpleName}[x:$x,y:$y,z:$z]"
}