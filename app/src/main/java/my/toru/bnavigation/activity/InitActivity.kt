package my.toru.bnavigation.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_init.*
import my.toru.bnavigation.R
import my.toru.bnavigation.fragment.*

class InitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        bottomNavigationView.hiding()
        bottomNavigationView.setOnNavigationItemSelectedListener {
            item: MenuItem -> when(item.itemId) {
                R.id.tab1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameForEach, HomeFragment.newInstance()).commit()
                    true
                }
                R.id.tab2 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameForEach, CategoryFragment()).commit()
                    true
                }
                R.id.tab3 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameForEach, SearchFragment()).commit()
                    true
                }
                R.id.tab4 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameForEach, CartFragment()).commit()
                    true
                }
                R.id.tab5 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameForEach, MyPageFragment()).commit()
                    true
                }
                else -> {
                    true
                }
            }
        }

        bottomNavigationView.selectedItemId = R.id.tab1
    }


    // Refered from stackoverflow
    @SuppressLint("RestrictedApi")
    fun BottomNavigationView.hiding(){
        val menuView = this.getChildAt(0) as BottomNavigationMenuView
        with(menuView.javaClass.getDeclaredField("mShiftingMode")){
            isAccessible = true
            setBoolean(menuView, false)
            isAccessible = false

            for(i in 0 until menuView.childCount){
                val item = menuView.getChildAt(i) as BottomNavigationItemView
                item.setShiftingMode(false)
                item.setChecked(item.itemData.isChecked)
            }
        }
    }
}