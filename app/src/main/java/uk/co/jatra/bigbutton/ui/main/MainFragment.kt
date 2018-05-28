package uk.co.jatra.bigbutton.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import uk.co.jatra.bigbutton.R



class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        val button = view.findViewById<Button>(R.id.button)

        val firstLine = "Big."
        val secondLine = "little stuff"
        var text = SpannableString(firstLine + "\n" + secondLine)

        text.setSpan(AbsoluteSizeSpan(16, true), 0, firstLine.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.setSpan(AbsoluteSizeSpan(12, true), firstLine.length+1, firstLine.length+1+secondLine.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        button.setText(text, TextView.BufferType.SPANNABLE)

        val psuedoButton = view.findViewById<LinearLayout>(R.id.pseudoButton)
        val psuedoButton2 = view.findViewById<LinearLayout>(R.id.pseudoButton2)
        psuedoButton.isSelected = true
        psuedoButton.setOnClickListener {
            psuedoButton.isSelected = true
            psuedoButton2.isSelected = false
        }
        psuedoButton2.isSelected = false
        psuedoButton2.setOnClickListener {
            psuedoButton2.isSelected = true
            psuedoButton.isSelected = false
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
