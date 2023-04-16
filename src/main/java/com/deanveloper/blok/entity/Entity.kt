package com.deanveloper.blok.entity

import com.deanveloper.blok.util.ImmutableLocation
import com.deanveloper.blok.util.ImmutableVector

/**
 * Any entity
 *
 * @author Dean B
 */
interface Entity {
    val attributes: MutableMap<EntityAttribute.EntityAttributeType, EntityAttribute>

    /**
     * The entity's id number
     */
    val entityId: Int

    /**
     * The entity's location
     */
    var location: ImmutableLocation

    /**
     * The distance that the entity has traveled so far within the tick
     */
    var velocity: ImmutableVector

    /**
     * The entity's name (empty if none)
     */
    val name: String

    /**
     * If the entity's name is visible
     */
    var isNameVisible: Boolean

    /**
     * If the entity is dead or not.
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
