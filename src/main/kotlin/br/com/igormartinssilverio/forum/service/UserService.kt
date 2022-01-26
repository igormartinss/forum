package br.com.igormartinssilverio.forum.service

import br.com.igormartinssilverio.forum.model.User
import org.springframework.stereotype.Service
import java.util.Arrays.asList

@Service
class UserService(private var users: List<User>) {

    init {
        val user: User = User(
            username = "Igor",
            password = "1234",
            id = 1,
            email = "teste@teste.com"
        )
        users = asList(user)
    }

    fun findById(id: Long): User {
        return users.stream().filter{
            it.id == id
        }.findFirst().get()
    }
}
