package com.deanveloper.blok.inventory

import com.deanveloper.blok.placeholders.Item

data class ArmorData constructor(
    var helmet: Item? = null,
    var chestplate: Item? = null,
    var leggings: Item? = null,
    var boots: Item? = null,
    var mainHand: Item? = null,
    var offHand: Item? = null
)
