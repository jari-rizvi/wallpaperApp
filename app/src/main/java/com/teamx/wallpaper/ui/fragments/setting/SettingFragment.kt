package com.teamx.wallpaper.ui.fragments.setting


import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teamx.wallpaper.R
import com.teamx.wallpaper.baseclasses.BaseFragment
import com.teamx.wallpaper.databinding.FragmentWallpaperListBinding
import com.teamx.wallpaper.dummyData.WallpaperListData
import dagger.hilt.android.AndroidEntryPoint
import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import com.teamx.wallpaper.databinding.FragmentSettingsBinding
import com.teamx.wallpaper.ui.fragments.wallpaperlist.WallpaperListViewModel
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingsBinding, WallpaperListViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_settings
    override val viewModel: Class<WallpaperListViewModel>
        get() = WallpaperListViewModel::class.java
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



    }


}