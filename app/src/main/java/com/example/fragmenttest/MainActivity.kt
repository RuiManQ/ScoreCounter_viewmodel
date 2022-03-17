package com.example.fragmenttest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.google.android.material.chip.Chip
import androidx.lifecycle.ViewModelProvider




class MainActivity : AppCompatActivity() {
    var fragmentManager: FragmentManager? = null
    var chip1: Chip? = null
    var chip2: Chip? = null
    var chip3: Chip? = null
    var chip4: Chip? = null
    var scoreButton: Button? =null

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager
        chip1 = findViewById(R.id.Local)
        chip2 = findViewById(R.id.net)
        chip3 = findViewById(R.id.test1)
        chip4 = findViewById(R.id.test2)
        scoreButton = findViewById(R.id.score)
        scoreButton!!.setOnClickListener{
            goToScoreActivity()
        }
        initView()
//        val model = ViewModelProvider(this).get(MyViewModel::class.java)
//        model.getUsers().observe(this, { users ->
//            Log.e(
//                TAG,
//                "onChange $users",
//
//            ) })
        chip1!!.setOnCheckedChangeListener { _, _ ->
            initView()
        }
        chip2!!.setOnCheckedChangeListener { _, _ ->
            initView()
        }
        chip3!!.setOnCheckedChangeListener { _, _ ->
            initView()
        }
        chip4!!.setOnCheckedChangeListener { _, _ ->
            initView()
        }
    }

    private fun initView() {

        val transaction = fragmentManager!!.beginTransaction()
        val fragmentToChoose: Fragment = when (getChipState()) {
            1 -> Fragment1()
            2 -> Fragment2()
            3 -> Fragment3()
            else -> Fragment4()
        }
        transaction.replace(R.id.fragment, fragmentToChoose)
        transaction.commit()
    }

    private fun getChipState(): Int {
        return if (chip1!!.isChecked && chip3!!.isChecked)
            1
        else if (chip1!!.isChecked && chip4!!.isChecked)
            2
        else if (chip2!!.isChecked && chip3!!.isChecked)
            3
        else 4

    }

    class Fragment1 : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val targetView = inflater.inflate(R.layout.fragment1, container, false)
            val layout = targetView.findViewById<ConstraintLayout>(R.id.layout1)
            return targetView
        }
    }

    class Fragment2 : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val targetView = inflater.inflate(R.layout.fragment2, container, false)
            val layout = targetView.findViewById<ConstraintLayout>(R.id.layout2)
            return targetView
        }
    }

    class Fragment3 : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val targetView = inflater.inflate(R.layout.fragment3, container, false)
            val layout = targetView.findViewById<ConstraintLayout>(R.id.layout3)
            return targetView
        }
    }

    class Fragment4 : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val targetView = inflater.inflate(R.layout.fragment4, container, false)
            val layout = targetView.findViewById<ConstraintLayout>(R.id.layout4)
            return targetView
        }
    }
    private fun  goToScoreActivity() {
        val scoreIntent = Intent(this,ScoreActivity::class.java)
        startActivity(scoreIntent)
    }
}


