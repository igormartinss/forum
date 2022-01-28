package br.com.igormartinssilverio.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Answer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String = "",
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val user: User = User(),
    @ManyToOne
    val topic: Topic = Topic(),
    val solution: Boolean = false
        )

