package com.deanveloper.blok.item

import com.deanveloper.blok.block.*
import com.deanveloper.blok.util.Data

/**
 * Represents the default list of Minecraft Materials
 * @author Dean B
 */
enum class Material {

	AIR(SimpleBlock("air")),
	STONE(Stone()),
	GRASS(),
	DIRT(Dirt()),
	COBBLESTONE(),
	PLANKS(BaseWood.PlankData()),
	SAPLING(BaseWood.Sapling()),
	BEDROCK(),
	FLOWING_WATER(Fluid(FLOWING_WATER)),
	STILL_WATER(SimpleBlock("water")),
	FLOWING_LAVA(Fluid(FLOWING_LAVA)),
	STILL_LAVA(SimpleBlock("lava")),
	SAND(Sand()),
	GRAVEL(),
	GOLD_ORE(),
	IRON_ORE(),
	COAL_ORE(),
	LOG(BaseWood.BaseDoubleWood.Log()),
	LEAVES(BaseWood.BaseDoubleWood.Leaves()),
	SPONGE(Sponge()),
	GLASS(),
	LAPIS_ORE(),
	LAPIS_BLOCK(),
	DISPENSER(Dispenser()),
	SANDSTONE(Sandstone()),
	NOTE_BLOCK(Noteblock()),
	BED(Bed()),
	POWERED_RAIL(BaseRail.PoweredRail()),
	DETECTOR_RAIL(BaseRail.DetectorRail()),
	STICKY_PISTON(StickyPiston()),
	COBWEB(),
	TALL_GRASS(TallGrass()),
	DEAD_BUSH("deadbush"),
	PISTON(Piston()),
	PISTON_HEAD(PistonHead()),
	WOOL(maxDataVal = 15),
	PISTON_EXTENSION(PistonExtension()),
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
	COCOA_BLOCK("cocoa", MaterialType.BLOCK, maxDataVal = 15),
	SANDSTONE_STAIRS(OAK_STAIRS),
	EMERALD_ORE(),
	ENDER_CHEST(maxDataVal = 5),
	TRIPWIRE_HOOK(MaterialType.BLOCK, maxDataVal = 15),
	TRIPWIRE(MaterialType.BLOCK, maxDataVal = 15),
	EMERALD_BLOCK(),
	SPRUCE_STAIRS(OAK_STAIRS),
	BIRCH_STAIRS(OAK_STAIRS),
	JUNGLE_STAIRS(OAK_STAIRS),
	COMMAND_BLOCK(maxDataVal = 15),
	BEACON(),
	COBBLESTONE_WALL(maxDataVal = 1),
	FLOWER_POT_BLOCK("flower_pot", MaterialType.BLOCK, maxDataVal = 13),
	CARROT_BLOCK("carrots", MaterialType.BLOCK, 7),
	POTATO_BLOCK("potatoes", MaterialType.BLOCK, 7),
	WOODEN_BUTTON(STONE_BUTTON),
	SKULL_BLOCK()
	;

	val id: String
	val data: Data?
		get() = field?.clone()

	constructor(data: Data) {
		this.id = data.id
		this.data = data
	}

	constructor(id: String) {
		this.id = id
		this.data = SimpleItemBlock(id)
	}

	constructor() {
		this.id = name.toLowerCase()
		this.data = SimpleItemBlock(id)
	}
}



