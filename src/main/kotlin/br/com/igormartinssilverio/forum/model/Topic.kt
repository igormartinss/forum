package br.com.igormartinssilverio.forum.model

import br.com.igormartinssilverio.forum.model.enum.TopicStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topic (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String = "",
    val message: String = "",
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: User = User(),
    @ManyToOne
    val course: Course = Course(),
    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.NOT_SOLVED,
    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList()
        )