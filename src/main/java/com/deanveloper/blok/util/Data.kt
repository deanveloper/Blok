package com.deanveloper.blok.util

/**
 * @author Dean B
 */
interface Data : Cloneable {
	val id: String
	val intId: Int

	override public fun clone(): Data
}