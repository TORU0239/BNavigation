package my.toru.bnavigation.fragment.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import my.toru.bnavigation.R

/**
 * A simple [Fragment] subclass.
 */
class HomeDealsFragment : Fragment() {

    init {
        Log.w("TORU", "HomeDealsFragment")
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_home_deal, container, false)
    }
}