package fr.iutlens.mmi.romaric.rogue

import fr.iutlens.mmi.romaric.rogue.Hero as Hero1

/**
 * Created by dubois on 30/12/2019.
 */



class Sprite {
    var prob: Float
    var id: Int
    var x: Int
    var y: Int

    constructor(tileId: Int, x: Int, y: Int) {
        id = tileId
        this.x = x
        this.y = y
        prob = 1f
    }

    constructor(id: Int, x: Int, y: Int, prob: Float) {
        this.id = id
        this.x = x
        this.y = y
        this.prob = prob
    }

    fun clone(): Sprite {
        return Sprite(id, x, y, prob)
    }

    fun getProb(): Boolean {
        return if (prob == 1f) true else Math.random() <= prob
    }

    fun block(): Boolean {
        return Tile[id]!!.hasOneFlag(Tile.F_BLOCK)
    }

    fun effect(level: Level?, hero: Hero1?) {
        if (Tile[id]!!.hasOneFlag(Tile.F_MONSTER or Tile.F_CONSOMMABLE or Tile.F_TRAP)) {
            level!!.removeContent(x, y)
            if (Tile[id]!!.hasOneFlag(Tile.F_MONSTER)) hero?.fight(id)
            if (Tile[id]!!.hasOneFlag(Tile.F_CONSOMMABLE)) hero?.heal(id)

            if (Tile[id]!!.hasOneFlag(Tile.F_TRAP)) hero?.trap(id)

        }
        if (Tile[id]!!.hasOneFlag(Tile.F_STAIR)) {
            //level?.generate()
            hero?.exitlvl = true


        }

    }
}