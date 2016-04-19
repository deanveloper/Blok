package com.deanveloper.blok.item

/**
 * Default data for a block/item
 *
 * @author Dean B
 */
abstract class MaterialData {
	/**
	 * The "owner" of the material (ie all of minecraft's are "minecraft")
	 */
	abstract val owner: String

	/**
	 * The stringy id of the material
	 */
	abstract val id: String

	/**
	 * What kind of material this is
	 */
	abstract val materialType: MaterialType

	/**
	 * The magic data value of the material
	 */
	@Deprecated("Magic value")
	abstract val dataValue: Byte

	/**
	 * The integer aka "network" id of the material
	 */
	@Deprecated("Magic value")
	abstract val intId: Int

	override fun toString() = "${javaClass.simpleName}[id=$owner:$id,data=$dataValue]"
}