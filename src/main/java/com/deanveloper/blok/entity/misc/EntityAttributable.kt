package com.deanveloper.blok.entity.misc

import com.deanveloper.blok.entity.EntityAttribute

/**
 * @author Dean B
 */
interface EntityAttributable {
	val attributes: MutableMap<EntityAttribute.EntityAttributeType, EntityAttribute>
}

