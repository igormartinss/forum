package br.com.igormartinssilverio.forum.service

import br.com.igormartinssilverio.forum.model.Course
import org.springframework.stereotype.Service
import java.util.Arrays.asList

@Service
class CourseService(var courses: List<Course>) {

    init {
        val course = Course (
            id = 1,
            name = "Banco",
            category = "Banco de Dados"
                )
        courses = asList(course)
    }

    fun findById(id: Long): Course {
        return courses.stream().filter {
            it.id == id
        }.findFirst().get()
    }
}
