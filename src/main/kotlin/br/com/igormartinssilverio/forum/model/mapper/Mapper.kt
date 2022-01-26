package br.com.igormartinssilverio.forum.model.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}