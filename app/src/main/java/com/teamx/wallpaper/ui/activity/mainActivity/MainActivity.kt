package com.teamx.wallpaper.ui.activity.mainActivity


import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.teamx.wallpaper.BR
import com.teamx.wallpaper.R
import com.teamx.wallpaper.baseclasses.BaseActivity
import com.teamx.wallpaper.databinding.ActivityMainBinding
import com.teamx.wallpaper.utils.FragHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {


    override val viewModel: Class<MainViewModel>
        get() = MainViewModel::class.java

    override val layoutId: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel


    private var navController: NavController? = null


    //    override fun onResumeFragments() {
//        super.onResumeFragments()
//    }
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

    //    private var mFbHelper: FacebookHelper? = null
//    override fun onResume() {
//        super.onResume()
//        Log.d("321321", "onResume:${navController!!.currentDestination!!.id} ")
//        navController!!.navigate(navController!!.currentDestination!!.id)

//    }

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

//        if (savedInstanceState == null) {
//            idN = R.id.tempFragment
//        } else {
//
//
//            val helperState = savedInstanceState.getBundle(STATE_HELPER)
//            stateHelper.restoreHelperState(helperState!!)
//        }






    }



    private fun initialising() {
        progress_bar = findViewById(R.id.progress_bar)
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
    override fun onSaveInstanceState(outState: Bundle) {
        // Make sure we save the current tab's state too!
        saveCurrentState()
//
//        outState.putInt("asdf",navController!!.currentDestination!!.id)
        outState.putBundle(STATE_HELPER, stateHelper.saveHelperState())

        super.onSaveInstanceState(outState)
    }

    private fun saveCurrentState() {
        Log.d("321321", "saveCurrentState:$idN ")
        fragments[navController!!.currentDestination!!.id]?.let { oldFragment ->
            stateHelper.saveState(oldFragment, navController!!.currentDestination!!.id)
        }
    }

}