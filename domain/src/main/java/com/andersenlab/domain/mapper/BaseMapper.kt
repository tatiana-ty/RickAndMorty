package com.andersenlab.domain.mapper

interface BaseMapper<in A, out B> {

    fun map(type: A?): B
}