package fr.iutlens.mmi.romaric.rogue

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity


const val EXTRA_MESSAGE = ".mess"
const val EXTRA_PHOTO = ".photo"
class GameActivity : AppCompatActivity() {
    class GenerateTask(val gameView: GameView) : AsyncTask<Int?, String?, Int>() {
        override fun onPostExecute(integer: Int) {
            super.onPostExecute(integer)
            gameView.invalidate()
        }

        override fun doInBackground(vararg p0: Int?): Int {
            gameView.generate()
            return 0
        }

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gameView = findViewById<GameView>(R.id.gameView)
        gameView.progressBar = findViewById(R.id.viewhp)
        gameView.resumelvl = findViewById(R.id.lvlresume)
        gameView.textwin = findViewById(R.id.textwin)
        gameView.onWin = fun(message : String, photo: Int){
            val intent = Intent(applicationContext, WinWindow::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
                putExtra(EXTRA_PHOTO, photo)
            }
            startActivity(intent)
            finish()
        }




        val task = GenerateTask(gameView)


        task.execute()

    }
}