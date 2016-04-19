package com.deanveloper.blok.item

/**
 * Represents the default list of Minecraft Materials
 * @author Dean B
 */
enum class Materials(
		id: String?,
		intId: Int,
		materialType: MaterialType,
		maxDataVal: Byte
) {

	AIR(MaterialType.BLOCK),
	STONE(maxDataVal = 6),
	GRASS(),
	DIRT(maxDataVal = 2),
	COBBLESTONE(),
	PLANKS(maxDataVal = 5),
	SAPLING(maxDataVal = 5),
	BEDROCK(),
	FLOWING_WATER(MaterialType.BLOCK),
	STILL_WATER("water", FLOWING_WATER),
	FLOWING_LAVA(MaterialType.BLOCK),
	STILL_LAVA("lava", FLOWING_LAVA),
	SAND(maxDataVal = 1),
	GRAVEL(),
	GOLD_ORE(),
	IRON_ORE(),
	COAL_ORE(),
	LOG(maxDataVal = 15),
	LEAVES(maxDataVal = 3),
	SPONGE(maxDataVal = 1),
	GLASS(),
	LAPIS_ORE(),
	LAPIS_BLOCK(),
	DISPENSER(maxDataVal = 15),
	SANDSTONE(maxDataVal = 2),
	NOTE_BLOCK("noteblock"),
	BED_BLOCK("bed", MaterialType.BLOCK, maxDataVal = 15),
	POWERED_RAIL("golden_rail", maxDataVal = 15),
	DETECTOR_RAIL(POWERED_RAIL),
	STICKY_PISTON(),
	COBWEB(),
	TALL_GRASS("tallgrass", maxDataVal = 2),
	DEAD_BUSH("deadbush"),
	PISTON(),
	PISTON_HEAD(MaterialType.BLOCK),
	WOOL(maxDataVal = 15),
	PISTON_EXTENSION(MaterialType.BLOCK),
	DANDELION("yellow_flower"),
	FLOWER("red_flower", maxDataVal = 8),
	BROWN_MUSHROOM(),
	RED_MUSHROOM(),
	GOLD_BLOCK(),
	IRON_BLOCK(),
	DOUBLE_STONE_SLAB(maxDataVal = 15),
	STONE_SLAB(maxDataVal = 15),
	BRICK_BLOCK(),
	TNT(),
	BOOKSHELF(),
	MOSSY_COBBLESTONE(),
	OBSIDIAN(),
	TORCH(maxDataVal = 5),
	FIRE(MaterialType.BLOCK),
	MOB_SPAWNER(),
	OAK_STAIRS(maxDataVal = 7),
	CHEST(),
	REDSTONE_WIRE(MaterialType.BLOCK, maxDataVal = 15),
	DIAMOND_ORE(),
	DIAMOND_BLOCK(),
	CRAFTING_TABLE(),
	WHEAT(MaterialType.BLOCK, maxDataVal = 7),
	FARMLAND(MaterialType.BLOCK, maxDataVal = 7),
	FURNACE(maxDataVal = 5),
	FURNACE_LIT("lit_furnace", MaterialType.BLOCK, maxDataVal = 5),
	STANDING_SIGN(MaterialType.BLOCK, maxDataVal = 15),
	WOODEN_DOOR(MaterialType.BLOCK, maxDataVal = 15),
	LADDER(maxDataVal = 5),
	RAIL(maxDataVal = 9),
	COBBLESTONE_STAIRS("stone_stairs", OAK_STAIRS),
	WALL_SIGN(maxDataVal = 5),
	LEVER(maxDataVal = 15),
	STONE_PRESSURE_PLATE(maxDataVal = 1),
	IRON_DOOR(WOODEN_DOOR),
	WOODEN_PRESSURE_PLATE(STONE_PRESSURE_PLATE),
	REDSTONE_ORE(),
	REDSTONE_ORE_LIT("lit_redstone_ore", MaterialType.BLOCK),
	REDSTONE_TORCH_UNLIT("unlit_redstone_torch", MaterialType.BLOCK, 5),
	REDSTONE_TORCH(maxDataVal = 5),
	STONE_BUTTON(maxDataVal = 13),
	SNOW_LAYER(maxDataVal = 7),
	ICE(),
	SNOW_BLOCK("snow"),
	CACTUS(),
	CLAY(),
	SUGAR_CANE("reeds"),
	JUKEBOX(maxDataVal = 1),
	OAK_FENCE(),
	PUMPKIN(maxDataVal = 7),
	NETHERRACK(),
	SOUL_SAND(),
	GLOWSTONE(),
	NETHER_PORTAL("portal", MaterialType.BLOCK, maxDataVal = 1),
	JACK_O_LANTERN("lit_pumpkin", PUMPKIN),
	CAKE_BLOCK("cake", MaterialType.BLOCK, maxDataVal = 6),
	REPEATER_BLOCK_UNLIT("unpowered_repeater", MaterialType.BLOCK, maxDataVal = 15),
	REPEATER_BLOCK_LIT("powered_repeater", REPEATER_BLOCK_LIT),
	STAINED_GLASS(WOOL),
	WOODEN_TRAPDOOR("trapdoor", maxDataVal = 15),
	MONSTER_EGG(maxDataVal = 5),
	STONE_BRICK("stonebrick", maxDataVal = 3),
	//named "HUGE" instead of "BLOCK" so that these isn't mistaken as a block-only form of X_MUSHROOM
	BROWN_MUSHROOM_HUGE("brown_mushroom_block", maxDataVal = 15),
	RED_MUSHROOM_HUGE("red_mushroom_block", BROWN_MUSHROOM_HUGE),
	IRON_BARS(),
	GLASS_PANE(),
	MELON_BLOCK(),
	PUMPKIN_STEM(MaterialType.BLOCK, maxDataVal = 7),
	MELON_STEM(PUMPKIN_STEM),
	VINES(maxDataVal = 15),
	OAK_FENCE_GATE(maxDataVal = 7),
	BRICK_STAIRS(OAK_STAIRS),
	STONE_BRICK_STAIRS(OAK_STAIRS),
	MYCELIUM(),
	LILY_PAD("waterlily"),
	NETHER_BRICK_BLOCK("nether_brick"),
	NETHER_BRICK_FENCE(),
	NETHER_BRICK_STAIRS(OAK_STAIRS),
	NETHER_WART_BLOCK("nether_wart", MaterialType.BLOCK, maxDataVal = 3),
	ENCHANTING_TABLE(),
	BREWING_STAND_BLOCK("brewing_stand", MaterialType.BLOCK, maxDataVal = 7),
	CAULDRON_BLOCK("cauldron", MaterialType.BLOCK, maxDataVal = 3),
	END_PORTAL(MaterialType.BLOCK),
	END_PORTAL_FRAME(maxDataVal = 3),
	END_STONE(),
	DRAGON_EGG(),
	REDSTONE_LAMP(),
	REDSTONE_LAMP_LIT("lit_redstone_lamp"),
	DOUBLE_WOOD_SLAB(maxDataVal = 5),
	WOODEN_SLAB(maxDataVal = 11),
	COCOA_BLOCK("cocoa", MaterialType.BLOCK, 15)
	;
	val owner = "minecraft"
	val id: String;
	val intId: Int;
	val materialType: MaterialType;
	val maxDataVal: Byte

	init {
		this.id = (id ?: name).toLowerCase()
		this.intId = if (intId < 0) ordinal else intId
		this.materialType = materialType;
		this.maxDataVal = maxDataVal
	}

	constructor(materialType: MaterialType = MaterialType.BOTH, maxDataVal: Byte = 0) : this(
			null,
			-1,
			materialType,
			maxDataVal
	)

	constructor(id: String? = null, materialType: MaterialType = MaterialType.BOTH, maxDataVal: Byte = 0) : this(
			id,
			-1,
			materialType,
			maxDataVal
	)

	constructor(id: String, inheritFrom: Materials) : this(
			id,
			inheritFrom.materialType,
			inheritFrom.maxDataVal
	)

	constructor(inheritFrom: Materials) : this(
			inheritFrom.materialType,
			inheritFrom.maxDataVal
	)

	fun createMaterial(data: Byte = 0): MaterialData {
		return object : MaterialData() {
			override val owner = this@Materials.owner
			override val id = this@Materials.id
			override val materialType = this@Materials.materialType
			override val dataValue = data
			override val intId = this@Materials.intId
		}
	}
}