package com.example.wishlist

import java.io.Serializable

class Desejo (var descricao: String, var nota: Int): Serializable{
    override fun toString(): String {
        return "${descricao} - ${nota}"
    }
}