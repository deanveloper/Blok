package com.deanveloper.blok.util

import com.deanveloper.blok.placeholders.World

/**
 * @author Dean B
 */
open class MutableLocation(
    override var world: World,
    override var x: Double,
    override var y: Double,
    override var z: Double
) : Location(world, x, y, z) {

    /** @see [Vector.unaryMinus] */
    override fun unaryMinus(): MutableLocation {
        x *= -1
        y *= -1
        z *= -1

        return this
    }

    /** @see [Vector.times] */
    override operator fun times(o: Vector): MutableLocation {
        x *= o.x
        y *= o.y
        z *= o.z

        return this
    }

    /** @see [Vector.div] */
    override operator fun div(o: Vector): MutableLocation {
        x /= o.x
        y /= o.y
        z /= o.z

        return this
    }

    /** @see [Vector.plus] */
    override operator fun plus(o: Vector): MutableLocation {
        x += o.x
        y += o.y
        z += o.z

        return this
    }

    fun toImmutable() = ImmutableLocation(world, x, y, z)

    /** @see [Vector.clone] */
    override fun clone() = MutableVector(x, y, z)
}
