package br.com.igormartinssilverio.forum.service

import br.com.igormartinssilverio.forum.exception.NotFoundException
import br.com.igormartinssilverio.forum.model.Course
import br.com.igormartinssilverio.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val repository: CourseRepository) {
    val notFoundMessage: String = "Curso não encontrado!"

    fun findById(id: Long): Course {
        return repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
    }
}
