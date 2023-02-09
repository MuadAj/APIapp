package com.example.apiapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiapp.util.Provider
import com.example.apiapp.model.Post
import com.example.apiapp.model.PostsApi
import com.example.apiapp.model.PostsApiImpl
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel(){

    private var postsApi: PostsApi = PostsApiImpl(Provider.client)
    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>> get() = _posts

    init {
        loadPostsFromApi()
    }

    fun loadPostsFromApi(){
        viewModelScope.launch {
            _posts.value = postsApi.getPosts()
        }
    }
}