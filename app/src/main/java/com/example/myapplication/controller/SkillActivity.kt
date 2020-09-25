package com.example.myapplication.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.utilities.EXTRA_PLAYER
import com.example.myapplication.R
import com.example.myapplication.model.Player

import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

   lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player= intent.getParcelableExtra(EXTRA_PLAYER)!!

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState!=null){
            player= savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    fun onBallerClick(view: View){
        beginnerSkillBtn.isChecked=false
        player.skill="baller"
    }

    fun onBeginnerClick(view: View){
        ballerSkillBtn.isChecked=false
        player.skill="beginner"
    }

    fun onSkillFinishClicked(view: View){
       if (player.skill!=""){
           val finishActivity=Intent(this,FinishActivity::class.java)
           finishActivity.putExtra(EXTRA_PLAYER,player)

           startActivity(finishActivity)
       } else{
           Toast.makeText(this, "Please select a skill level",Toast.LENGTH_SHORT).show()
       }
    }
}