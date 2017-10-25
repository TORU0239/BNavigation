package my.toru.bnavigation.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import my.toru.bnavigation.R
import my.toru.bnavigation.fragment.home.HomeDealsFragment
import my.toru.bnavigation.fragment.home.HomeHotSellingFragment
import my.toru.bnavigation.fragment.home.HomePromoFragment
import my.toru.bnavigation.fragment.home.HomeSellingFragment

class HomeFragment : Fragment() {

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewPager.adapter = PagerAdapter(activity.supportFragmentManager)
        homeTabBar.setupWithViewPager(homeViewPager)
    }
}

class PagerAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return HomeSellingFragment()
            1 -> return HomeDealsFragment()
            2 -> return HomeHotSellingFragment()
            3 -> return HomePromoFragment()
            else-> return Fragment()
        }
    }

    override fun getCount() = 4

    override fun getPageTitle(position: Int): CharSequence {
        when(position){
            0 -> return "HOME"
            1 -> return "DEALS"
            2 -> return "HOT SELLING"
            3 -> return "PROMO"
            else-> return ""
        }
    }
}