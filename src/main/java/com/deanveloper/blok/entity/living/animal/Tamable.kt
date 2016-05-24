package com.deanveloper.blok.entity.living.animal

import com.deanveloper.blok.entity.Entity
import com.deanveloper.blok.entity.misc.Targets

/**
 * A tamable mob
 *
 * @author Dean B
 */
interface Tamable : Targets {
    var owner: Entity?

    var percentTamed: Float
}
