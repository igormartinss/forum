package br.com.igormartinssilverio.forum.repository

import br.com.igormartinssilverio.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {
}