package com.deanveloper.blok.entity.living

import com.deanveloper.blok.placeholders.*
import com.deanveloper.blok.util.ImmutableLocation
import com.deanveloper.blok.util.Location
import com.deanveloper.blok.util.Title
import java.net.InetSocketAddress

/**
 * A connected player
 *
 * @author Dean B
 */
interface Player : Human {

	/**
	 * Sends a chat message
	 */
	fun chat(message: String)

	/**
	 * Executes a command
	 */
	fun execute(command: String)

	/**
	 * Their ip address
	 */
	val ip: InetSocketAddress

	/**
	 * If they are allowed to fly
	 */
	var allowedToFly: Boolean

	/**
	 * If they are currently flying
	 */
	var flying: Boolean

	/**
	 * Their spawn location
	 */
	var spawnLocation: ImmutableLocation

	/**
	 * Their compass target
	 */
	var compassTarget: Location

	/**
	 * Their exhaustion level (how fast their hunger will drop
	 */
	var exhaustion: Float

	/**
	 * Their saturation level (how many "hunger bars" until their hunger actually drops)
	 */
	var saturation: Float

	/**
	 * Their food level
	 */
	var foodLevel: Float

	/**
	 * Their experience
	 */
	var exp: Experience

	/**
	 * Their fly speed
	 */
	var flySpeed: Float

	/**
	 * Their walk speed
	 */
	var walkSpeed: Float

	/**
	 * The amount of health to multiply by to be interpreted by the client
	 *
	 * ie: If your health is 20.0 and the health scale is 2, the client sees it as 40.0
	 */
	var healthScale: Double

	/**
	 * The scoreboard that the player sees
	 */
	var scoreboard: Scoreboard

	/**
	 * Sends a block change to this player only
	 */
	fun localBlockChange(loc: Location, block: Block)

	/**
	 * The block at this location for the player
	 */
	fun blockAt(loc: Location)

	/**
	 * Play a sound
	 */
	fun playSound(loc: Location, sound: Sound, volume: Float = 1.0f, pitch: Float = 1.0f)

	/**
	 * Play a sound
	 */
	fun playSound(loc: Location, sound: String, volume: Float = 1.0f, pitch: Float = 1.0f)

	/**
	 * Play a note
	 */
	fun playNote(loc: Location, note: Note, noteType: NoteType)

	/**
	 * Show a title
	 */
	fun showTitle(title: Title)

	/**
	 * Reset the title
	 */
	fun resetTitle()
}

