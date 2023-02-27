package com.example.instagram.models

data class User(
    val name: String = "",
    val username: String = "",
    val website: String = "",
    val bio: String = "",
    val phone: Long = 0L,
    val email: String = "",
)
