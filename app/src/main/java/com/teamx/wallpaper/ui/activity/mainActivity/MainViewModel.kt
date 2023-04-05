package com.teamx.wallpaper.ui.activity.mainActivity

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.teamx.wallpaper.baseclasses.BaseViewModel
import com.teamx.wallpaper.data.remote.reporitory.MainRepository
import com.teamx.wallpaper.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {

    var bundleB = MutableLiveData<Bundle>(Bundle())
    val getBundle: LiveData<Bundle>
        get() = bundleB

}
