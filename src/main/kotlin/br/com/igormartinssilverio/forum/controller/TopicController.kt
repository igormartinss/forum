package br.com.igormartinssilverio.forum.controller

import br.com.igormartinssilverio.forum.model.form.TopicCreateForm
import br.com.igormartinssilverio.forum.model.form.TopicEditForm
import br.com.igormartinssilverio.forum.model.view.TopicView
import br.com.igormartinssilverio.forum.service.TopicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private var service: TopicService) {

    @GetMapping
    fun find(@PageableDefault(
        size = 5,
        sort = ["createdAt"],
        direction = Sort.Direction.DESC
    )pageable: Pageable): Page<TopicView> {
        return service.findAll(pageable)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return service.findById(id)
    }

    @PostMapping
    fun create(
        @RequestBody @Valid topicToCreate: TopicCreateForm,
        uriComponent: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicCreated = service.create(topicToCreate)
        val uri = uriComponent.path("/topics/${topicCreated.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicCreated)
    }

    @PutMapping("/{id}")
    fun edit(@RequestBody @Valid topicToEdit: TopicEditForm, @PathVariable id: Long): ResponseEntity<TopicView> {
        val topicView = service.edit(topicToEdit, id)

        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}