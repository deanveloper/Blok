package com.deanveloper.blok.util

/**
 * @author Dean B
 */
open class ImmutableVector(
        override final val x: Double,
        override final val y: Double,
        override final val z: Double
) : Vector(x, y, z) {
    companion object {
        val ZERO = ImmutableVector(0.0, 0.0, 0.0)
    }

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
