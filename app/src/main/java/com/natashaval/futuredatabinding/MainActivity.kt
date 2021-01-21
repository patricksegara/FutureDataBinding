package com.natashaval.futuredatabinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.natashaval.futuredatabinding.ProfileActivity.Companion.FIRST_NAME_KEY
import com.natashaval.futuredatabinding.ProfileActivity.Companion.LAST_NAME_KEY
import com.natashaval.futuredatabinding.model.User
import com.natashaval.futuredatabinding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

  private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

  private val user = User("Your", "Name")
  private lateinit var score: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // TODO: A3. change how to inflate with DataBinding
    setContentView(R.layout.activity_main)

    // TODO: A4. bind user and score data with name UI
    val firstNameText = findViewById<TextView>(R.id.tv_first_name)
    firstNameText.text = user.firstName

    val lastNameText = findViewById<TextView>(R.id.tv_last_name)
    lastNameText.text = user.lastName

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

//  TODO: A5. implement event handling Method References when clicking Activity button
  fun openActivity(view: View) {
    val intent = Intent(this, ProfileActivity::class.java)
    intent.putExtra(FIRST_NAME_KEY, user.firstName)
    intent.putExtra(LAST_NAME_KEY, user.lastName)
    startActivity(intent)
  }

  // TODO: A6. implement setOnClickListener to Fragment button
  fun openFragment(view: View) {
    val fragment = ProfileFragment.newInstance(user.firstName, user.lastName)
    fragment.show(supportFragmentManager, ProfileFragment.TAG)
  }

  private fun updateScore(value: Int) {
    user.score += value
    score.text = user.score.toString()
  }
}