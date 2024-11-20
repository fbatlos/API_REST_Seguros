package com.example.unsecuredseguros.services

import com.example.unsecuredseguros.model.AsistenciaMedica
import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.repository.AsistenciasRepository
import com.example.unsecuredseguros.repository.SegurosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class AsistenciaServicios {

    @Autowired
    private lateinit var asistenciaRepository: AsistenciasRepository


    fun getAll(): List<AsistenciaMedica> {
        return asistenciaRepository.findAll()
    }


    fun getById(id: String): AsistenciaMedica? {
        val idL = id.toLong()
        return asistenciaRepository.findByIdOrNull(idL)
    }
}