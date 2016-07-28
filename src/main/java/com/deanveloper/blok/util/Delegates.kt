package com.deanveloper.blok.util

import com.deanveloper.blok.block.DirectionRepresentation
import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


val BOOLEAN_MAPPER: (Int) -> Boolean = { if (it == 1) true else false }

val BYTE_MAPPER: (Int) -> Byte = { it.toByte() }

val DIRECTION_MAPPER: (Int) -> DirectionRepresentation = { }

class NybbleStorage<R : Data, T>(
        val mask: Int,
        init: T,
        mapper: (Int) -> T
) : ReadWriteProperty<R, T> {
    val mapped: BiMap<Int, T>

    init {
        val maskWidth = mask.msbPos - mask.lsbPos + 1
        val max = maskWidth * maskWidth
        mapped = HashBiMap.create(max)
        for (i in 0..(max - 1)) {
            try {
                mapped.put(i, mapper(i))
            } catch(ignored: Exception) {
                // Ignored because sometimes not all integers map
            }
        }

        mapped.inverse()[init]
    }

    override fun getValue(thisRef: R, property: KProperty<*>): T {
        val data = thisRef.rawData
        return mapped[data[mask]] ?: throw IllegalArgumentException("[$thisRef] ${data[mask]} doesn't map to a value!")
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        val data = thisRef.rawData
        data[mask] = mapped.inverse()[value] ?: throw IllegalArgumentException("[$thisRef] $value doesn't map to an Int!")
    }
}