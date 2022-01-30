package br.com.igormartinssilverio.forum.repository

import br.com.igormartinssilverio.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {
}