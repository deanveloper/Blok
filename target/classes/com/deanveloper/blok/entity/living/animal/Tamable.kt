package com.deanveloper.blok.entity.living.animal

import com.deanveloper.blok.entity.Entity
import com.deanveloper.blok.entity.misc.CanTarget

/**
 * A tamable mob
 *
 * @author Dean B
 */
interface Tamable : CanTarget {
    var owner: Entity?

    var percentTamed: Float
}
