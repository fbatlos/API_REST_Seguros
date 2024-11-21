package com.example.unsecuredseguros.services

import com.example.unsecuredseguros.model.AsistenciaMedica
import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.repository.AsistenciasRepository
import com.example.unsecuredseguros.repository.SegurosRepository
import com.example.unsecuredseguros.utils.Utils
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

    fun update(id: Int,nuevaAsistencia: AsistenciaMedica): AsistenciaMedica? {

        val idL = id.toLong()
        var asistencia = asistenciaRepository.findByIdOrNull(idL)

        if (!Utils.checkAsistencia(nuevaAsistencia)){
            return null
        }

        if (asistencia != null) {
            asistencia.breve_descripcion = nuevaAsistencia.breve_descripcion
            asistencia.lugar = nuevaAsistencia.lugar
            asistencia.explicacion = nuevaAsistencia.explicacion
            asistencia.tipo_asistencia = nuevaAsistencia.tipo_asistencia
            asistencia.fecha = asistencia.fecha
            asistencia.hora = nuevaAsistencia.hora
            asistencia.importe = asistencia.importe


            return asistenciaRepository.save(asistencia)
        }

        return null
    }

    fun delete(id: Int): Boolean? {
        val idL = id.toLong()
        asistenciaRepository.findByIdOrNull(idL)?:return null
        asistenciaRepository.deleteById(idL)

        return true
    }
}