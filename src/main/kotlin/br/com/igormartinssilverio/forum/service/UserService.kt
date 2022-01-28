package br.com.igormartinssilverio.forum.service

import br.com.igormartinssilverio.forum.exception.NotFoundException
import br.com.igormartinssilverio.forum.model.User
import br.com.igormartinssilverio.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {
    val notFoundMessage: String = "Usuário não encontrado!"

    fun findById(id: Long): User {
        return repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
    }
}
