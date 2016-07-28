package com.deanveloper.blok.util

/**
 * @author Dean B
 */
open class MutableVector(
        override var x: Double,
        override var y: Double,
        override var z: Double
) : Vector(x, y, z) {

    /** @see [Vector.unaryMinus] */
    override operator fun unaryMinus(): MutableVector {
        x *= 1
        y *= 1
        z *= 1

        return this
    }

    /** @see [Vector.times] */
    override operator fun times(o: Vector): MutableVector {
        x *= o.x
        y *= o.y
        z *= o.z

        return this
    }

    /** @see [Vector.div] */
    override operator fun div(o: Vector): MutableVector {
        x /= o.x
        y /= o.y
        z /= o.z

        return this
    }


    /** @see [Vector.plus] */
    override operator fun plus(o: Vector): MutableVector {
        x += o.x
        y += o.y
        z += o.z

        return this
    }

    fun toImmutable() = ImmutableVector(x, y, z)

    /** @see [Vector.clone] */
    override fun clone() = MutableVector(x, y, z)
}
