package com.example.tasty_advisor.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import coil.load
import com.example.tasty_advisor.R
import com.example.tasty_advisor.models.Result
import com.example.tasty_advisor.util.Constants.Companion.RECIPE_RESULT_KEY
import kotlinx.android.synthetic.main.fragment_overview.view.*
import org.jsoup.Jsoup


class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_overview, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        view.main_imageView.load(myBundle?.image)
        view.title_textView.text = myBundle?.title
        view.time_textView.text = myBundle?.readyInMinutes.toString()
        myBundle?.summary.let {
            val summary = Jsoup.parse(it).text()
            view.summary_textView.text = summary
        }

        if(myBundle?.vegetarian == true){
            view.vegetarian_imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            view.vegetarian_textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }
        if(myBundle?.veryHealthy == true){
            view.healthy_imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            view.healthy_textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }
        if(myBundle?.cheap== true){
            view.cheap_imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            view.cheap_textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }
        return view
    }

}