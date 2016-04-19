package com.deanveloper.blok.entity

import com.deanveloper.blok.util.ImmutableVector
import com.deanveloper.blok.util.Location

/**
 * @author Dean B
 */
interface Entity {
	/**
	 * The entity's id number
	 */
	val entityId: Int

	/**
	 * The entity's location
	 */
	val location: Location

	/**
	 * The entity's name (null if none)
	 */
	val name: String?

	/**
	 * If the entity's name is visible
	 */
	var isNameVisible: Boolean

	/**
	 * If the entity is dead or not
	 */
	var isDead: Boolean

	/**
	 * The bounding box for the entity
	 */
	val boundingBox: ImmutableVector

	/**
	 * If the entity is glowing
	 */
	var isGlowing: Boolean

	/**
	 * If the entity can get hurt
	 */
	var isInvincible: Boolean
}