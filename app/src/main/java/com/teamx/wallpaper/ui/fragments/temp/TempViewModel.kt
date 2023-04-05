package com.teamx.wallpaper.ui.fragments.temp


import com.teamx.wallpaper.baseclasses.BaseViewModel
import com.teamx.wallpaper.data.remote.reporitory.MainRepository
import com.teamx.wallpaper.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TempViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel()