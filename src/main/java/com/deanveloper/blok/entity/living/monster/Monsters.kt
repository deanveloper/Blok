package com.deanveloper.blok.entity.living.monster

import com.deanveloper.blok.entity.living.LivingEntity
import com.deanveloper.blok.entity.misc.CanTarget

/**
 * A monster
 *
 * @author Dean B
 */
interface Monster : LivingEntity, CanTarget

interface Blaze : Monster

interface CaveSpider : Monster

interface Creeper : Monster

interface Enderman : Monster

interface Endermite : Monster

interface Giant : Monster

interface Guardian : Monster

interface PigZombie : Monster

interface Silverfish : Monster

interface Skeleton : Monster

interface Spider : Monster

interface Witch : Monster

interface Wither : Monster

interface Zombie : Monster