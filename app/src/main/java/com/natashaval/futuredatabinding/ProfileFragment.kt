package com.natashaval.futuredatabinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.natashaval.futuredatabinding.ProfileActivity.Companion.FIRST_NAME_KEY
import com.natashaval.futuredatabinding.ProfileActivity.Companion.LAST_NAME_KEY

class ProfileFragment : DialogFragment() {
    private var firstName: String? = null
    private var lastName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            firstName = it.getString(FIRST_NAME_KEY)
            lastName = it.getString(LAST_NAME_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstNameTextView = view.findViewById<TextView>(R.id.tv_first_name)
        firstNameTextView.text = firstName

        val lastNameTextView = view.findViewById<TextView>(R.id.tv_last_name)
        lastNameTextView.text = lastName
    }

    companion object {
        fun newInstance(firstName: String, lastName: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(FIRST_NAME_KEY, firstName)
                    putString(LAST_NAME_KEY, lastName)
                }
            }
        const val TAG = "ProfileFragment"
    }
}