package com.deanveloper.blok.entity.misc

import java.time.LocalDateTime

/**
 * A damageable entity
 *
 * @author Dean B
 */
interface Damageable {
	/**
	 * The health the entity has
	 */
	var health: Float

	/**
	 * The max health of the entity
	 */
	var customMaxHealth: Float

	/**
	 * The default max health of the entity
	 */
	val maxHealth: Float

	/**
	 * Damage the entity
	 *
	 * @param[damage]           The amount to damage it by
	 * @param[cause]            The cause for the damage
	 * @param[ignoreCooldown]   Whether to ignore the entity's "cooldown" or not
	 */
	fun damage(damage: Float, cause: DamageCause, ignoreCooldown: Boolean = false)

	/**
	 * The last time the entity was damaged
	 */
	var lastDamaged: LocalDateTime

	enum class DamageCause {
		;
		init {
			TODO()
		}
	}

}