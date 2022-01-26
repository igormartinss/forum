package br.com.igormartinssilverio.forum.model.view

import br.com.igormartinssilverio.forum.model.enum.TopicStatus
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime
        )