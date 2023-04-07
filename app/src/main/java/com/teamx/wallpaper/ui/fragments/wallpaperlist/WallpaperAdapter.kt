package com.teamx.wallpaper.ui.fragments.wallpaperlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamx.wallpaper.databinding.ItemWallpaperListBinding
import com.teamx.wallpaper.dummyData.WallpaperListData

class WallpaperAdapter(
    val orderArrayList: ArrayList<WallpaperListData>,var callback: CallBack
) : RecyclerView.Adapter<FaqViewHolder>() {

    interface CallBack{
        fun onItemClickFavourite(i: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        return FaqViewHolder(
            ItemWallpaperListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {

        val imgList: WallpaperListData = orderArrayList[position]

        holder.bind.imageView3.setImageResource(imgList.Img)

        holder.itemView.setOnClickListener {
         callback.onItemClickFavourite(position)

        }

    }

    override fun getItemCount(): Int {
        return orderArrayList.size
    }
}

class FaqViewHolder(private var binding: ItemWallpaperListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val bind = binding

}
