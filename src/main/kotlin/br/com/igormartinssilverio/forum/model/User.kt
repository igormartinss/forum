package br.com.igormartinssilverio.forum.model

import javax.persistence.*

@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val username: String = "",
    val email: String = "",
    val password: String = ""
)
