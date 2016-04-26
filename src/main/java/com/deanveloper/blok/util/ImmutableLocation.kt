package com.deanveloper.blok.util

import com.deanveloper.blok.placeholders.World

/**
 * @author Dean B
 */
class ImmutableLocation(
		override final val world: World,
		override val x: Double,
		override val y: Double,
		override val z: Double
) : Location(world, x, y, z) {
	/** @see [Vector.unaryMinus] */
	override operator fun unaryMinus() = ImmutableVector(-x, -y, -z)

	/** @see [Vector.times] */
	override operator fun times(o: Vector) = ImmutableVector(x * o.x, y * o.y, z * o.z)

	/** @see [Vector.div] */
	override operator fun div(o: Vector) = ImmutableVector(x / o.x, y / o.y, z / o.z)


	/** @see [Vector.plus] */
	override operator fun plus(o: Vector) = ImmutableVector(x + o.x, y + o.y, z + o.z)

	/** @see [Vector.clone] */
	override fun clone() = ImmutableVector(x, y, z)
}