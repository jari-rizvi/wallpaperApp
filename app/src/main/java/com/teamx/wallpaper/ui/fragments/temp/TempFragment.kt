package com.teamx.wallpaper.ui.fragments.temp


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import com.teamx.wallpaper.R
import com.teamx.wallpaper.baseclasses.BaseFragment
import com.teamx.wallpaper.databinding.FragmentTempBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TempFragment : BaseFragment<FragmentTempBinding, TempViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_temp
    override val viewModel: Class<TempViewModel>
        get() = TempViewModel::class.java
    override val bindingVariable: Int
        get() = 1

    private lateinit var options: NavOptions


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        options = navOptions {
            anim {
                enter = R.anim.enter_from_left
                exit = R.anim.exit_to_left
                popEnter = R.anim.enter_from_left
                popExit = R.anim.exit_to_left
            }
        }

        Log.d("Databsae Token ", "start working")

        Handler(Looper.getMainLooper()).postDelayed({
            if (isAdded) {

                navController =
                    Navigation.findNavController(
                        requireActivity(),
                        R.id.nav_host_fragment
                    )
                navController.navigate(R.id.wallpaperListFragment, null, options)
            }

        }, 2000)

        clickListener()
    }


    private fun clickListener() {

    }

}