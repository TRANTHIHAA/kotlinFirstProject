
package com.example.kotlin.transformer


interface Transformer <A, B> {
    fun transform(source: A): B
}
