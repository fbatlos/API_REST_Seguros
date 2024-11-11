package com.example.unsecuredseguros.services

import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.repository.SegurosRepository
import com.example.unsecuredseguros.utils.Utils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class SeguroServicios {

    @Autowired
    private lateinit var segurosRepository: SegurosRepository

    fun getAll(): List<Seguro> {
        return segurosRepository.findAll()
    }


    fun getById(id: Int): Seguro? {
        val idL = id.toLong()?:return null
        return segurosRepository.findByIdOrNull(idL)
    }

    fun insert(seguro: Seguro): Boolean {
        if (Utils.checkSeguro(seguro)) {
            segurosRepository.save(seguro)
            return true
        }else{
            return false
        }
    }

    fun update(id: Int,nuevoSeguro: Seguro): Seguro? {

        val idL = id.toLong()
        val seguro = segurosRepository.findByIdOrNull(idL)

        if (Utils.checkSeguro(nuevoSeguro)){
            return null
        }

        if (seguro != null) {
            seguro.nif = nuevoSeguro.nif
            seguro.nombre = nuevoSeguro.nombre
            seguro.ape1 = nuevoSeguro.ape1
            seguro.ape2 = nuevoSeguro.ape2
            seguro.edad = nuevoSeguro.edad
            seguro.numHijos = nuevoSeguro.numHijos
            seguro.fechaCreacion = nuevoSeguro.fechaCreacion
            seguro.sexo = nuevoSeguro.sexo
            seguro.casado = nuevoSeguro.casado
            seguro.embarazada = nuevoSeguro.embarazada

            return segurosRepository.save(seguro)
        }

        return null
    }
}