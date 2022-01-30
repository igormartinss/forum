package br.com.igormartinssilverio.forum.model.mapper

import br.com.igormartinssilverio.forum.model.Topic
import br.com.igormartinssilverio.forum.model.form.TopicCreateForm
import br.com.igormartinssilverio.forum.service.CourseService
import br.com.igormartinssilverio.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
): Mapper<TopicCreateForm, Topic> {

    override fun map(t: TopicCreateForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.courseId),
            author = userService.findById(t.authorId)
        )
    }

}
