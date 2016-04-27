package com.deanveloper.blok.item

/**
 * @author Dean B
 */
class ItemDoesntExistException(type: Material) : RuntimeException("Cannot get item for $type")
class BlockDoesntExistException(type: Material) : RuntimeException("Cannot get block for $type")