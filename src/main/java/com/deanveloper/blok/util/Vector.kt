package com.deanveloper.blok.util

/**
 * A location
 *
 * @author Dean B
 */
abstract class Vector(
		open val x: Double,
		open val y: Double,
		open val z: Double
) : Cloneable, Comparable<Vector> {
	/**
	 * Compare to another vector (judged by whichever has a larger magnitude)
	 *
	 * @param[other] The other [Vector] you are comparing to
	 */
	override operator fun compareTo(other: Vector) = this.magnitudeSquared().toInt() - other.magnitudeSquared().toInt()

	/**
	 * Negates each value of the vector
	 */
	abstract operator fun unaryMinus(): Vector

	/**
	 * Multiply the values by another [Vector]
	 *
	 * @param[o] The other [Vector] to multiply by
	 */
	abstract operator fun times(o: Vector): Vector

	/**
	 * Add the values to another [Vector]
	 *
	 * @param[o] The other [Vector] to add
	 */
	abstract operator fun plus(o: Vector): Vector

	/**
	 * Divides the values by another [Vector]
	 *
	 * @param[o] The other [Vector] to divide by
	 */
	abstract operator fun div(o: Vector): Vector

	/**
	 * @see [clone]
	 */
	open operator fun unaryPlus() = clone()

	/**
	 * Subtract this by another [Vector]
	 *
	 * @param[o] The other [Vector] to subtract
	 */
	open operator fun minus(o: Vector) = plus(-o)

	/**
	 * The magnitude squared.
	 *
	 * The reasoning behind this method is that it is slightly
	 * more efficient than finding the raw magnitude as it doesn't
	 * require to do a square root, an inefficient operation.
	 */
	open fun magnitudeSquared(): Double = x * x + y * y + z * z

	/**
	 * The magnitude.
	 *
	 * Note that it is best to use [magnitudeSquared] whenever
	 * you can. This method performs a square root operation which
	 * can be pretty hard on a system if done too much. It is much
	 * better to compare [magnitudeSquared] to a squared number than
	 * to compare [magnitude] to the number itself.
	 */
	open fun magnitude(): Double = Math.sqrt(magnitudeSquared())

	/**
	 * The distance squared between two [Vector]s.
	 *
	 * @see [magnitudeSquared]
	 */
	open fun distanceFromSquared(o: Vector) = (this - o).magnitudeSquared()

	/**
	 * The magnitude of this [Vector].
	 *
	 * @see [magnitude]
	 */
	open fun distanceFrom(o: Vector) = Math.sqrt(distanceFromSquared(o))

	/**
	 * Clones the [Vector]
	 */
	override public abstract fun clone(): Vector

	override fun hashCode(): Int {
		return x.toInt() or y.toInt();
	}

	override fun toString(): String = "${javaClass.simpleName}[x:$x,y:$y,z:$z]"
}