package br.com.igormartinssilverio.forum.model.view

import java.time.LocalDate
import java.time.LocalDateTime

class ErrorView(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String

)