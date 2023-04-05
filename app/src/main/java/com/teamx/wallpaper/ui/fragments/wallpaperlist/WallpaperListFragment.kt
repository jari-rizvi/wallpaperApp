package com.teamx.wallpaper.ui.fragments.wallpaperlist


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teamx.wallpaper.R
import com.teamx.wallpaper.baseclasses.BaseFragment
import com.teamx.wallpaper.databinding.FragmentTempBinding
import com.teamx.wallpaper.databinding.FragmentWallpaperListBinding
import com.teamx.wallpaper.dummyData.WallpaperListData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WallpaperListFragment : BaseFragment<FragmentWallpaperListBinding, WallpaperListViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_wallpaper_list
    override val viewModel: Class<WallpaperListViewModel>
        get() = WallpaperListViewModel::class.java
    override val bindingVariable: Int
        get() = 1

    private lateinit var options: NavOptions
    lateinit var wallpaperlistAdapter: WallpaperAdapter
    lateinit var wallpaperlistArrayList: ArrayList<WallpaperListData>


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


        mViewDataBinding.btnMenu.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(), mViewDataBinding.btnMenu)

            // Inflating popup menu from popup_menu.xml file
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                // Toast message on menu item clicked
                Toast.makeText(
                    requireContext(), "You Clicked " + menuItem.title, Toast.LENGTH_SHORT
                ).show()
                true
            }
            popupMenu.show()
        }

        listAdapter()

    }

    private fun listAdapter() {
        wallpaperlistArrayList = ArrayList()
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.dummy_img))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.dummy_img))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.dummy_img))


        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        mViewDataBinding.recyclerList.layoutManager = linearLayoutManager

        wallpaperlistAdapter = WallpaperAdapter(wallpaperlistArrayList)
        mViewDataBinding.recyclerList.adapter = wallpaperlistAdapter

    }

}