package com.natashaval.futuredatabinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.natashaval.futuredatabinding.ProfileActivity.Companion.FIRST_NAME_KEY
import com.natashaval.futuredatabinding.ProfileActivity.Companion.LAST_NAME_KEY
import com.natashaval.futuredatabinding.model.User

class MainActivity : AppCompatActivity() {

  private var user = User("Natasha", "Santoso")
  private lateinit var score: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val firstName = findViewById<TextView>(R.id.tv_first_name)
    firstName.text = user.firstName

    val lastName = findViewById<TextView>(R.id.tv_last_name)
    lastName.text = user.lastName

    score = findViewById<TextView>(R.id.tv_score)
    score.text = user.score.toString()

    val plusScore = findViewById<Button>(R.id.bt_score_plus)
    plusScore.setOnClickListener {
      updateScore(1)
    }
    val minusScore = findViewById<Button>(R.id.bt_score_minus)
    minusScore.setOnClickListener {
      updateScore(-1)
    }
  }

  fun openActivity(view: View) {
    val intent = Intent(this, ProfileActivity::class.java)
    intent.putExtra(FIRST_NAME_KEY, user.firstName)
    intent.putExtra(LAST_NAME_KEY, user.lastName)
    startActivity(intent)
  }

  fun openFragment(view: View) {
    val fragment = ProfileFragment.newInstance(user.firstName, user.lastName)
    fragment.show(supportFragmentManager, ProfileFragment.TAG)
  }

  private fun updateScore(value: Int) {
    user.score += value
    score.text = user.score.toString()
  }
}