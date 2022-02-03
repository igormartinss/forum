package br.com.igormartinssilverio.forum.repository

import br.com.igormartinssilverio.forum.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username: String?): User?
}