package com.example.unsecuredseguros.model

import jakarta.persistence.*
import jdk.jfr.Timestamp
import java.util.*

@Entity
@Table(name = "seguros")
data class Seguro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idSeguro: Int,

    @Column(nullable = false , length = 10)
    val nif: String,

    @Column(nullable = false,length = 100)
    val nombre: String,

    @Column(nullable = false,length = 100)
    val ape1: String,

    @Column(length = 100)
    val ape2: String?,

    @Column(nullable = false)
    val edad: Int,

    @Column(nullable = false)
    var numHijos: Int,

    @Column(nullable = false)
    @Timestamp
    val fechaCreacion: Date,

    @Column(nullable = false,length = 10 )
    val sexo: String,

    @Column(nullable = false)
    val casado: Boolean,

    @Column(nullable = false)
    val embarazada: Boolean
)