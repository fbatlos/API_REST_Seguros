package com.example.unsecuredseguros.model

import jakarta.persistence.*
import jdk.jfr.Timestamp
import java.time.LocalDate
import java.time.LocalTime


@Entity
@Table(name = "asistencias_medicas")
data class AsistenciaMedica(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_asistencia_medica: Int,

    @Column(nullable = false,length = 255)
    val breve_descripcion :String,

    @Column(nullable = false,length = 255)
    val lugar :String,

    @Column(nullable = false)
    val explicacion :String,

    @Column(nullable = false,length = 100)
    val tipo_asistencia :String,

    @Column(nullable = false)
    @Timestamp
    val fecha: LocalDate,
    @Column(nullable = false)
    @Timestamp
    val hora: LocalTime,
    @Column(nullable = false)
    val importe: Double,

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_seguro", nullable = false)
    val id_seguro: Seguro,
)
