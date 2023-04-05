package com.teamx.wallpaper

import androidx.lifecycle.MutableLiveData
import com.teamx.wallpaper.baseclasses.BaseViewModel
import com.teamx.wallpaper.data.models.ProductModel


/**
 * Shared View Model class for sharing data between fragments
 */
class SharedViewModel : BaseViewModel() {

    val clickOnContinueBtn: MutableLiveData<Boolean>? = null

    val addToCartProduct = MutableLiveData<ArrayList<ProductModel>>()

    fun addProduct(model: ProductModel) {
        val list = addToCartProduct.value;
        if (list != null) {
            list.add(model);
            addToCartProduct.postValue(list!!)
        } else {
            val newList = ArrayList<ProductModel>();
            newList.add(model)
            addToCartProduct.postValue(newList)
        }
    }

}