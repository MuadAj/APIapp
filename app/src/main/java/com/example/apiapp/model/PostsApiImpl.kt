package com.example.apiapp.model

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

class PostsApiImpl( private val client: HttpClient
): PostsApi {

    override suspend fun getPosts(): List<Post> {
        return try {
//             val wellcom:Welcome=
          val postData : Data =   client.get {
                url(Routes.POSTS)
            }.body()
            postData.data
//            wellcom.results
        } catch (e: RedirectResponseException) {
            Log.e("PostsApi", "3XX Error: ${e.message}")
            emptyList()
        } catch (e: ClientRequestException) {
            Log.e("PostsApi", "4XX Error: ${e.message}")
            emptyList()
        } catch (e: ServerResponseException) {
            Log.e("PostsApi", "5XX Error: ${e.message}")
            emptyList()
        } catch (e: Exception) {
            Log.e("PostsApi", "Error: ${e.message}")
            emptyList()
        }
    }
}
