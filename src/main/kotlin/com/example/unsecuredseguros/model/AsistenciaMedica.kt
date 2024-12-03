package com.example.unsecuredseguros.model

import com.fasterxml.jackson.annotation.JsonBackReference
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
    var breve_descripcion :String,

    @Column(nullable = false,length = 255)
    var lugar :String,

    @Column(nullable = false)
    var explicacion :String,

    @Column(nullable = false,length = 100)
    var tipo_asistencia :String,

    @Column(nullable = false)
    @Timestamp
    var fecha: LocalDate,
    @Column(nullable = false)
    @Timestamp
    var hora: LocalTime,
    @Column(nullable = false)
    var importe: Double,

    @ManyToOne(optional = false,cascade = [CascadeType.ALL],fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seguro", nullable = false )
    @JsonBackReference
    var id_seguro: Seguro?,
)
