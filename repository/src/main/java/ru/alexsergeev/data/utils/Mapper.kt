package ru.alexsergeev.data.utils

interface Mapper<in I, out O> {
    fun map(input: I): O
}