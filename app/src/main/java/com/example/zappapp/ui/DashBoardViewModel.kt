package com.example.zappapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.zappapp.base.BaseViewModel
import com.example.zappapp.ui.model.Photo
import kotlinx.coroutines.launch

class DashBoardViewModel(
    private val savedPhotoRepository: SavedPhotoRepository
):BaseViewModel() {

    var getSavedPhotoItem=MutableLiveData<List<Photo>>()

    fun savePhoto(photo:Photo){
        viewModelScope.launch {
            savedPhotoRepository.savePhoto(photo)
        }
    }

    fun updatePhoto(photo: Photo){
        viewModelScope.launch {
            savedPhotoRepository.updatePhoto(photo)
        }
    }

    fun deletePhoto(id:Int){
        viewModelScope.launch {
            savedPhotoRepository.deletePhoto(id)
        }
    }



    fun getAllPhoto(){

        viewModelScope.launch {
            savedPhotoRepository.getPhoto().let {
                getSavedPhotoItem.value =it
            }
        }

    }
}