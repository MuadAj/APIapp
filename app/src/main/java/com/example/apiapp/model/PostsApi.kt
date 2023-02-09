package com.example.apiapp.model

import com.example.apiapp.model.Post

interface PostsApi {
    suspend fun getPosts(): List<Post>
}