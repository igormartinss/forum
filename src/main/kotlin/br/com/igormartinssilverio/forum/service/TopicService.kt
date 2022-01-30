package br.com.igormartinssilverio.forum.service

import br.com.igormartinssilverio.forum.exception.NotFoundException
import br.com.igormartinssilverio.forum.model.Topic
import br.com.igormartinssilverio.forum.model.form.TopicCreateForm
import br.com.igormartinssilverio.forum.model.form.TopicEditForm
import br.com.igormartinssilverio.forum.model.mapper.TopicFormMapper
import br.com.igormartinssilverio.forum.model.mapper.TopicViewMapper
import br.com.igormartinssilverio.forum.model.view.TopicView
import br.com.igormartinssilverio.forum.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    val notFoundMessage: String = "Tópico não encontrado!"

    fun findAll(pageable: Pageable): Page<TopicView> {
        return repository.findAll(pageable).map {
            t -> topicViewMapper.map(t)
        }
    }

    fun findById(id: Long): TopicView {
        return topicViewMapper.map(repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) } )
    }

    fun create(topicToAdd: TopicCreateForm): TopicView {
        val topic = topicFormMapper.map(topicToAdd)
        repository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun edit(topicToEdit: TopicEditForm, id: Long): TopicView {
        val topic: Topic = repository.findById(id).orElseThrow{ NotFoundException(notFoundMessage) }

        val topicEdited = Topic(
            id = topic.id,
            title = topicToEdit.title,
            message = topicToEdit.message,
            createdAt = topic.createdAt,
            status = topic.status,
            author = topic.author,
            course = topic.course
        )

        return topicViewMapper.map(repository.save(topicEdited))
    }

    fun delete(id: Long) {
        repository.delete(repository.findById(id).orElseThrow{ NotFoundException(notFoundMessage) })
    }
}
