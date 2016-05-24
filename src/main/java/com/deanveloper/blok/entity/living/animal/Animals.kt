package com.deanveloper.blok.entity.living.animal

import com.deanveloper.blok.entity.living.LivingEntity

/**
 * An animal
 *
 * @author Dean B
 */
interface Animal : LivingEntity

interface Chicken : Animal

interface Cow : Animal

interface Horse : Animal, Tamable

interface MushroomCow : Animal

interface Ocelot : Animal, Tamable

interface Pig : Animal

interface Rabbit : Animal

interface Sheep : Animal

interface Wolf : Animal, Tamable
