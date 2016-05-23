package com.deanveloper.blok.util

import kotlin.reflect.KProperty

/**
 * Util function for Delegates
 *
 * @param[T]    The type that this delegate sets/returns
 * @author Dean B
 */
interface VarDelegate<T> : ValDelegate<T> {
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T)
}

interface ValDelegate<T> {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T
}
