package com.deanveloper.blok.entity.living.animal

import com.deanveloper.blok.entity.living.LivingEntity
import com.deanveloper.blok.entity.misc.EntityAttributable

/**
 * @author Dean B
 */
interface Animal : LivingEntity, EntityAttributable

interface Chicken : Animal

interface Cow : Animal

interface Horse : Animal, Tameable

interface MushroomCow : Animal

interface Ocelot : Animal, Tameable

interface Pig : Animal

interface Rabbit : Animal

interface Sheep : Animal

interface Wolf : Animal, Tameable