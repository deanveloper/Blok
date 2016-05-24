package com.deanveloper.blok.block

/**
 * Represents a powerable block
 *
 * @author Dean B
 */
interface Powerable {
    var powered: Boolean
}

/**
 * Represents a power source
 *
 * @author Dean B
 */
interface PowerSource {
    val output: Int
}

interface BinaryPowerSource : PowerSource {
    val powering: Boolean

    override val output: Int
        get() = if(powering) 15 else 0
}
