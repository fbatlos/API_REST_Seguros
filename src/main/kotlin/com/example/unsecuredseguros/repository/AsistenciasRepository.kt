package com.example.unsecuredseguros.repository

import com.example.unsecuredseguros.model.AsistenciaMedica
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface AsistenciasRepository : JpaRepository<AsistenciaMedica, Long> {
}