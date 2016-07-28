package com.deanveloper.blok.util

import java.time.Duration

/**
 * Created by Dean on 7/28/2016.
 */
val Double.seconds: Duration
	get() = Duration.ofSeconds(this.toLong())
val Float.seconds: Duration
	get() = Duration.ofSeconds(this.toLong())
val Long.seconds: Duration
	get() = Duration.ofSeconds(this)
val Int.seconds: Duration
	get() = Duration.ofSeconds(this.toLong())
val Short.seconds: Duration
	get() = Duration.ofSeconds(this.toLong())
val Byte.seconds: Duration
	get() = Duration.ofSeconds(this.toLong())

val Double.minutes: Duration
	get() = Duration.ofMinutes(this.toLong())
val Float.minutes: Duration
	get() = Duration.ofMinutes(this.toLong())
val Long.minutes: Duration
	get() = Duration.ofMinutes(this)
val Int.minutes: Duration
	get() = Duration.ofMinutes(this.toLong())
val Short.minutes: Duration
	get() = Duration.ofMinutes(this.toLong())
val Byte.minutes: Duration
	get() = Duration.ofMinutes(this.toLong())

val Double.hours: Duration
	get() = Duration.ofHours(this.toLong())
val Float.hours: Duration
	get() = Duration.ofHours(this.toLong())
val Long.hours: Duration
	get() = Duration.ofHours(this)
val Int.hours: Duration
	get() = Duration.ofHours(this.toLong())
val Short.hours: Duration
	get() = Duration.ofHours(this.toLong())
val Byte.hours: Duration
	get() = Duration.ofHours(this.toLong())