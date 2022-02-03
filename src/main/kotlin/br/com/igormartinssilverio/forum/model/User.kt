package br.com.igormartinssilverio.forum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val username: String = "",

    val email: String = "",

    val password: String = "",

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_role")
    val role: List<Role> = mutableListOf()
)
