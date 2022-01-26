package br.com.igormartinssilverio.forum.model

import br.com.igormartinssilverio.forum.model.enum.TopicStatus
import java.time.LocalDateTime

data class Topic (
    val id: Long? = null,
    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val course: Course,
    val status: TopicStatus = TopicStatus.NOT_SOLVED,
    val answers: List<Answer> = ArrayList()
        )