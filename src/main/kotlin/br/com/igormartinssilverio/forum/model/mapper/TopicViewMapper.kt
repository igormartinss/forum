package br.com.igormartinssilverio.forum.model.mapper

import br.com.igormartinssilverio.forum.model.Topic
import br.com.igormartinssilverio.forum.model.view.TopicView
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {
    override fun map(topic: Topic): TopicView {
        return TopicView(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            status = topic.status,
            createdAt = topic.createdAt)
    }
}