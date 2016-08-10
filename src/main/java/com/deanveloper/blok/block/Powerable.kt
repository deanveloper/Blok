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
    var output: Byte
}

interface BinaryPowerSource : PowerSource {
    var powering: Boolean

    override var output: Byte
        get() = if (powering) 15 else 0
        set(value) {
            powering = value > 0
        }
}
