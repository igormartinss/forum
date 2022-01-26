package br.com.igormartinssilverio.forum.model

data class User (
    val id: Long? = null,
    val username: String,
    val email: String,
    val password: String
)
