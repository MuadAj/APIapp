package com.example.apiapp.model

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class Data (
    val data: List<Post>
)

@Serializable
data class Post (
    val id: String,
    val name: String,

    @SerialName("min_size")
    val minSize: String
)

//import kotlinx.serialization.*
//import kotlinx.serialization.json.*
//import kotlinx.serialization.descriptors.*
//import kotlinx.serialization.encoding.*
//
//@Serializable
//data class Welcome (
//    val results: List<Post>
//)
//
//@Serializable
//@SerialName("Result")
//data class Post (
//    val gender: String,
//    val name: Name,
//)
//
//@Serializable
//data class Name (
//    val title: String,
//    val first: String,
//    val last: String
//)