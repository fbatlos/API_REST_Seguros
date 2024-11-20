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
    var nif: String,

    @Column(nullable = false,length = 100)
    var nombre: String,

    @Column(nullable = false,length = 100)
    var ape1: String,

    @Column(length = 100)
    var ape2: String?,

    @Column(nullable = false)
    var edad: Int,

    @Column(nullable = false)
    var numHijos: Int,

    @Column(nullable = false)
    @Timestamp
    var fechaCreacion: Date,

    @Column(nullable = false,length = 10 )
    var sexo: String,

    @Column(nullable = false)
    var casado: Boolean,

    @Column(nullable = false)
    var embarazada: Boolean,

    @OneToMany(mappedBy = "id_seguro", cascade = [CascadeType.ALL], orphanRemoval = true)
    val asistenciasMedicas:List<AsistenciaMedica>?=null
)