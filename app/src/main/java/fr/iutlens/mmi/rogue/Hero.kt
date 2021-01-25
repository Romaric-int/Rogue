package fr.iutlens.mmi.rogue

import android.graphics.Canvas
import android.graphics.Paint
import android.widget.TextView
import fr.iutlens.mmi.rogue.util.Coordinate
import fr.iutlens.mmi.rogue.util.SpriteSheet

/**
 * Created by dubois on 24/12/2019.
 */
class Hero(tileset: Int, id: Int, x: Int, y: Int) {
    private val spriteSheet: SpriteSheet? = SpriteSheet.get(tileset)
    private val id: Int = id
    var x: Int
        private set
    var y: Int
        private set

    var hp: Int = 100

    var lvl: Int = 1
    var xp: Int = 0
    var xpreach: Int = 6


    fun paint(canvas: Canvas) {
        spriteSheet!!.paint(canvas, id, x * spriteSheet.w.toFloat(), y * spriteSheet.h.toFloat(), 0xffc1b5)
    }


    val hpRect = Paint().apply {
        color = 0xffffffff.toInt()
        style = Paint.Style.FILL
    }

    val resumeRect = Paint().apply {
        color = 0xffffffff.toInt()
        style = Paint.Style.FILL
    }










    val mobility: Int
        get() = Tile.F_WALK or Tile.F_SWIM

    fun move(dir: Int) {
        x += Coordinate.dir_coord.get(dir).get(0)
        y += Coordinate.dir_coord.get(dir).get(1)
    }

    fun fight(id: Int) {
        hp -= 3
        xp += 3
        if (xp >= xpreach) {
            lvl += 1
            xpreach *= 2
            xp = 0
        }
    }

    fun heal(id: Int) {
        hp += 3
    }



    init {
        this.x = x
        this.y = y
    }
}