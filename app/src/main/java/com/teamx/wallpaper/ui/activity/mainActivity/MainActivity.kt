package com.teamx.wallpaper.ui.activity.mainActivity


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import com.teamx.wallpaper.BR
import com.teamx.wallpaper.R
import com.teamx.wallpaper.baseclasses.BaseActivity
import com.teamx.wallpaper.databinding.ActivityMainBinding
import com.teamx.wallpaper.utils.FragHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {


    override val viewModel: Class<MainViewModel>
        get() = MainViewModel::class.java

    override val layoutId: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel


    private var navController: NavController? = null

    private var mainDrawer: DrawerLayout? = null
    private var sideDrawerMenu: ImageView? = null
    private var toolbarMainAct: ConstraintLayout? = null



    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("321321", "onRestoreInstanceState: ")
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?, persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d("321321", "onRestoreInstanceState: ")
    }

    override fun onStateNotSaved() {
        super.onStateNotSaved()
        Log.d("321321", "onStateNotSaved: ")
    }


    lateinit var progress_bar: ProgressBar
    private var navView: NavigationView? = null


    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onStop() {
        super.onStop()
        Log.d("321321", "onStop: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialising()

        stateHelper = FragHelper(supportFragmentManager)
        addDrawer()



        navController?.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.wallpaperListFragment -> {
                    toolbarMainAct?.visibility = View.GONE
                }

                else -> {
                    toolbarMainAct?.visibility = View.GONE
                    findViewById<TextView>(R.id.categories_title).text = ""


                }
            }


//        if (savedInstanceState == null) {
//            idN = R.id.tempFragment
//        } else {
//
//
//            val helperState = savedInstanceState.getBundle(STATE_HELPER)
//            stateHelper.restoreHelperState(helperState!!)
//        }


        }

        fun addDrawer() {
            sideDrawerMenu!!.setOnClickListener {
                mainDrawer!!.openDrawer(GravityCompat.START)
            }

            val dp1 = 2
            val params = LinearLayout.LayoutParams(
                dp1 * 50,
                dp1 * 35
            )
            params.gravity = Gravity.CENTER
            params.topMargin = 35


            navView!!.setNavigationItemSelectedListener { item ->
                Handler(Looper.getMainLooper()).postDelayed({

                    // Your Code

                    navController =
                        Navigation.findNavController(this, R.id.nav_host_fragment)
                    when (item.itemId) {
                        R.id.home -> {


                            navController!!.navigate(R.id.wallpaperListFragment, null, null)

//                        navigateFragmentMethod(R.id.shippingAddressFragment, true)
                        }
                        R.id.settings -> {


                            navController!!.navigate(R.id.settingFragment, null, null)

//                        navigateFragmentMethod(R.id.shippingAddressFragment, true)
                        }


                    }


                }, 200)
                false
            }
//
        }
    }


    private fun initialising() {
        progress_bar = findViewById(R.id.progress_bar)
        navView = findViewById(R.id.nav_view)
        mainDrawer = findViewById(R.id.mainDrawer)
        sideDrawerMenu = findViewById(R.id.menu)

    }

    open fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }


    open fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }


    companion object {
        private const val STATE_SAVE_STATE = "save_state"
        private const val STATE_KEEP_FRAGS = "keep_frags"
        private const val STATE_HELPER = "helper"
    }

    private lateinit var stateHelper: FragHelper

    private val fragments = mutableMapOf<Int, Fragment>()

    var idN: Int = 0;
//    override fun onSaveInstanceState(outState: Bundle) {
//        // Make sure we save the current tab's state too!
//        saveCurrentState()
////
////        outState.putInt("asdf",navController!!.currentDestination!!.id)
//        outState.putBundle(STATE_HELPER, stateHelper.saveHelperState())
//
//        super.onSaveInstanceState(outState)
//    }
//
//    private fun saveCurrentState() {
//        fragments[navController!!.currentDestination!!.id]?.let { oldFragment ->
//            stateHelper.saveState(oldFragment, navController!!.currentDestination!!.id)
//        }
//    }

}