package br.com.igormartinssilverio.forum.service

import br.com.igormartinssilverio.forum.exception.NotFoundException
import br.com.igormartinssilverio.forum.model.User
import br.com.igormartinssilverio.forum.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository): UserDetailsService {
    val notFoundMessage: String = "Usuário não encontrado!"

    fun findById(id: Long): User {
        return repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = repository.findByUsername(username) ?: throw NotFoundException("Usuário não encontrado!")
        return UserDetail(user)
    }
}
