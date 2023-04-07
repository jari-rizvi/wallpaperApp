package com.teamx.wallpaper.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import com.teamx.wallpaper.R

class DialogHelperClass {
    companion object {

        fun loadingDialog(context: Context): Dialog {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.dialog_layout_loading)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            return dialog
        }


        fun errorDialog(context: Context, errorMessage: String) {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.dialog_layout_error)
            val errorTextMessage = dialog.findViewById<TextView>(R.id.tv_error_message)
            val tv_title_text = dialog.findViewById<TextView>(R.id.tv_title_text)
            tv_title_text.visibility = View.GONE
            if (errorMessage.contains("job was cancelled",true)) {
                return
            }
            errorTextMessage.text = errorMessage
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }

        interface setWallpaperDialog {
            fun onHomeScreenButton()
            fun onLockScreenButton()
            fun onbothButton()
        }

        fun setWallpaper(context: Context, dialogCallBack: setWallpaperDialog) {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.dialog_set_wallpaper)
            dialog.window!!.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT
            )

            val HomeBtn = dialog.findViewById<TextView>(R.id.btnHome)
            HomeBtn.text = "btnHome"
            HomeBtn.setOnClickListener {
                dialogCallBack.onHomeScreenButton()
            }

             val btnLock = dialog.findViewById<TextView>(R.id.btnLock)
            btnLock.text = "btnHome"
            btnLock.setOnClickListener {
                dialogCallBack.onLockScreenButton()
            }

              val btnLockHome = dialog.findViewById<TextView>(R.id.btnLockHome)
            btnLockHome.text = "btnHome"
            btnLockHome.setOnClickListener {
                dialogCallBack.onbothButton()
            }


            val cancelBtn = dialog.findViewById<TextView>(R.id.btncncl)

            cancelBtn.setOnClickListener {
                dialog.dismiss()
            }

            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }


    }


}