package com.deanveloper.blok.entity

import com.deanveloper.blok.util.ImmutableVector
import com.deanveloper.blok.util.Location
import java.time.LocalDateTime

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
	 * The current health of the entity
	 */
	var health: Float

	/**
	 * The entity's name (empty if none)
	 */
	val name: String

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

	/**
	 * The last time the entity was damaged
	 */
	var lastDamaged: LocalDateTime
}