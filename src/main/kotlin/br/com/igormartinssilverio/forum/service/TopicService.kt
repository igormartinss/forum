package br.com.igormartinssilverio.forum.service

import br.com.igormartinssilverio.forum.model.Topic
import br.com.igormartinssilverio.forum.model.form.TopicCreateForm
import br.com.igormartinssilverio.forum.model.form.TopicEditForm
import br.com.igormartinssilverio.forum.model.mapper.TopicFormMapper
import br.com.igormartinssilverio.forum.model.mapper.TopicViewMapper
import br.com.igormartinssilverio.forum.model.view.TopicView
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    fun findAll(): List<TopicView> {
        return topics.stream().map {
            t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic = topics.stream().filter{
            it.id == id
        }.findFirst().get()

        return topicViewMapper.map(topic)
    }

    fun create(topicToAdd: TopicCreateForm): TopicView {
        val topic: Topic = topicFormMapper.map(topicToAdd)
        topics = topics.plus(topic)

        return topicViewMapper.map(topic)
    }

    fun edit(topicToEdit: TopicEditForm, id: Long): TopicView {
        val topic: Topic = topics.stream().filter {
            it.id == id
        }.findFirst().get()

        val topicEdited = Topic(
            id = topic.id,
            title = topicToEdit.title,
            message = topicToEdit.message,
            createdAt = topic.createdAt,
            status = topic.status,
            author = topic.author,
            course = topic.course
        )

        topics = topics.minus(topic).plus(topicEdited)

        return topicViewMapper.map(topicEdited)
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter{
            it.id == id
        }.findFirst().get()
        topics = topics.minus(topic)
    }
}
