package com.deanveloper.blok.entity.living

import com.deanveloper.blok.entity.Entity
import com.deanveloper.blok.placeholders.ArmorData
import com.deanveloper.blok.placeholders.EntityAI
import com.deanveloper.blok.placeholders.PotionEffect
import com.deanveloper.blok.placeholders.PotionType

/**
 * @author Dean B
 */
interface LivingEntity : Entity {
	/**
	 * All of the potion effects on the mob
	 */
	val potionEffects: MutableMap<PotionType, PotionEffect>

	/**
	 * The list of entity AIs (in order of priority)
	 */
	val entityAi: MutableList<EntityAI>

	/**
	 * Whether the entity can pickup items or not
	 */
	var canPickup: Boolean

	/**
	 * Data to store armor
	 */
	var armor: ArmorData

	/**
	 * The height of the entity's eyes
	 */
	var eyeHeight: Float

	/**
	 * The entity that has this entity on a leash (null if none)
	 */
	var leashedBy: Entity?

	/**
	 * If this entity is able to despawn
	 */
	var despawns: Boolean

	/**
	 * Whether or not this entity will push other entities
	 */
	var pushes: Boolean

	/**
	 * Whether or not this entity will be pushed by other entities
	 */
	var isPushed: Boolean

	/**
	 * If the entity is gliding with an elytra
	 */
	var gliding: Boolean
}

