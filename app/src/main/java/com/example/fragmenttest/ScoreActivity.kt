package com.example.fragmenttest

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class ScoreActivity : AppCompatActivity() {
    private val TAG = "ScoreActivity"
    var plusThreeA: Button? = null
    var plusTwoA: Button? = null
    var plusA: Button? = null
    var plusThreeB: Button? = null
    var plusTwoB: Button? = null
    var plusB: Button? = null
    var teamAText: TextView? = null
    var teamBText: TextView? = null
    var scoreModel: MyViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score)
        teamAText = findViewById(R.id.team_a_score)
        teamBText = findViewById(R.id.team_b_score)
        scoreModel = ViewModelProvider(this).get(MyViewModel::class.java)
        initUI()
//        if (savedInstanceState != null) {
//            Log.e(TAG, "savedInstanceState!=null")
//            teamAText!!.text = savedInstanceState.getCharSequence("teamAscore")
//            teamBText!!.text = savedInstanceState.getCharSequence("teamBscore")
//        }
        plusThreeA = findViewById(R.id.plus3A)
        plusThreeA?.setOnClickListener {
            plusPointToTeamA(3)
        }
        plusTwoA = findViewById(R.id.plus2A)
        plusTwoA?.setOnClickListener {
            plusPointToTeamA(2)
        }
        plusA = findViewById(R.id.plusA)
        plusA?.setOnClickListener {
            plusPointToTeamA(1)
        }
        plusThreeB = findViewById(R.id.plus3B)
        plusThreeB?.setOnClickListener {
            plusPointToTeamB(3)
        }
        plusTwoB = findViewById(R.id.plus2B)
        plusTwoB?.setOnClickListener {
            plusPointToTeamB(2)
        }
        plusB = findViewById(R.id.plusB)
        plusB?.setOnClickListener {
            plusPointToTeamB(1)
        }
    }

    private fun plusPointToTeamA(score: Int) {
        scoreModel!!.teamAScore += score
        teamAText!!.text = scoreModel!!.teamAScore.toString()
    }

    private fun plusPointToTeamB(score: Int) {
        scoreModel!!.teamBScore += score
        teamBText!!.text = scoreModel!!.teamBScore.toString()
    }

    fun initUI(){
        teamAText!!.text = scoreModel!!.teamAScore.toString()
        teamBText!!.text = scoreModel!!.teamBScore.toString()

    }

//    override fun onSaveInstanceState(savedInstanceState: Bundle) {
//        super.onSaveInstanceState(savedInstanceState)
//        savedInstanceState.putCharSequence("teamAscore", teamAText!!.text)
//        savedInstanceState.putCharSequence("teamBscore", teamBText!!.text)
//    }
}