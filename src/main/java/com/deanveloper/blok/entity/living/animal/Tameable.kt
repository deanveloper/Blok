package com.deanveloper.blok.entity.living.animal

import com.deanveloper.blok.entity.Entity

/**
 * @author Dean B
 */
interface Tameable {
	var owner: Entity?

	var percentTamed: Float
}