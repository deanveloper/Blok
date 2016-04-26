package com.deanveloper.blok.block

import com.deanveloper.blok.util.Data

/**
 * Represents a block
 *
 * @author Dean B
 */
interface BlockData : Data {
	override fun clone(): BlockData
}