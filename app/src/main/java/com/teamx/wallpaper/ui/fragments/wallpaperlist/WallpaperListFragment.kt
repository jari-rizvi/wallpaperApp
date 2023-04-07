package com.teamx.wallpaper.ui.fragments.wallpaperlist


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
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

@AndroidEntryPoint
class WallpaperListFragment : BaseFragment<FragmentWallpaperListBinding, WallpaperListViewModel>(), WallpaperAdapter.CallBack {

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


//        mViewDataBinding.btnMenu.setOnClickListener {
//            val popupMenu = PopupMenu(requireContext(), mViewDataBinding.btnMenu)
//
//            // Inflating popup menu from popup_menu.xml file
//            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
//            popupMenu.setOnMenuItemClickListener { menuItem ->
//                // Toast message on menu item clicked
//                Toast.makeText(
//                    requireContext(), "You Clicked " + menuItem.title, Toast.LENGTH_SHORT
//                ).show()
//                true
//            }
//            popupMenu.show()
//        }

        listAdapter()

    }

    private fun listAdapter() {
        wallpaperlistArrayList = ArrayList()
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.dummy_img))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.dummy_img))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.dummy_img))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.dummy_img))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.dummy_img))
        wallpaperlistArrayList.add(WallpaperListData(R.drawable.dummy_img))


        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        mViewDataBinding.recyclerList.layoutManager = linearLayoutManager

        wallpaperlistAdapter = WallpaperAdapter(wallpaperlistArrayList,this)
        mViewDataBinding.recyclerList.adapter = wallpaperlistAdapter

    }

    override fun onItemClickFavourite(i: Int) {

        setWallpaperFromUrl(requireContext(), "https://www.w3schools.com/css/img_5terre.jpg")
        setLockScreenWallpaperFromUrl(requireContext(), "https://www.w3schools.com/css/img_5terre.jpg")


//        val bundle = Bundle()
//        bundle.putInt(
//            "imageId", i
//        ).toString()
//        navController =
//            Navigation.findNavController(
//                requireActivity(),
//                R.id.nav_host_fragment
//            )
//        navController.navigate(R.id.previewWallpaperFragment, bundle, options)
    }


    @RequiresApi(Build.VERSION_CODES.ECLAIR_MR1)
    fun setWallpaperFromUrl(context: Context, imageUrl: String) {
        Thread {
            var bitmap: Bitmap? = null
            var connection: HttpURLConnection? = null
            try {
                val url = URL(imageUrl)
                connection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input: InputStream = connection.inputStream
                bitmap = BitmapFactory.decodeStream(input)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }
            if (bitmap != null) {
                val wallpaperManager = WallpaperManager.getInstance(context)
                try {
                    wallpaperManager.setBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }


    @RequiresApi(Build.VERSION_CODES.N)
    fun setLockScreenWallpaperFromUrl(context: Context, imageUrl: String) {
        Thread {
            var bitmap: Bitmap? = null
            var connection: HttpURLConnection? = null
            try {
                val url = URL(imageUrl)
                connection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input: InputStream = connection.inputStream
                bitmap = BitmapFactory.decodeStream(input)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }
            if (bitmap != null) {
                val wallpaperManager = WallpaperManager.getInstance(context)
                try {
                    wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

}