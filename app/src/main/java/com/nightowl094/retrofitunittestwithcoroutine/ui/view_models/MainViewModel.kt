package com.nightowl094.retrofitunittestwithcoroutine.ui.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nightowl094.retrofitunittestwithcoroutine.data.CommentDTOItem
import com.nightowl094.retrofitunittestwithcoroutine.data.GetCommentsService
import com.nightowl094.retrofitunittestwithcoroutine.data.JSONPlaceholderRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.create

class MainViewModel : ViewModel() {

    private val jsonPlaceholderRetrofit = JSONPlaceholderRemoteSource.jsonPlaceholderRemoteSource
    private val getDummyCommentsService = jsonPlaceholderRetrofit.create<GetCommentsService>()

    val comments by lazy { MutableLiveData<List<CommentDTOItem>>() }

    fun getComments() =
        viewModelScope.launch(Dispatchers.IO) {
            getDummyCommentsService.fetchDummyCommentData().also {
                comments.postValue(it)
            }
        }
}