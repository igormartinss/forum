package br.com.igormartinssilverio.forum.model.form

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicEditForm (
        @field:NotEmpty
        @field:Size(min = 5)
        val title: String,

        @field:NotEmpty
        val message: String,
        )
