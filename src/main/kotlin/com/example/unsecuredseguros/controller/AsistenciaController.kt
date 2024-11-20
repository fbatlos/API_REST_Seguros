package com.example.unsecuredseguros.controller

import com.example.unsecuredseguros.exception.NotFoundException
import com.example.unsecuredseguros.exception.ValidationException
import com.example.unsecuredseguros.model.AsistenciaMedica
import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.services.AsistenciaServicios
import com.example.unsecuredseguros.services.SeguroServicios
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/asistencias")
class AsistenciaController {
    @Autowired
    private lateinit var asistenciasService:AsistenciaServicios

    @GetMapping("/")
    fun getAll(): ResponseEntity<List<AsistenciaMedica>> {
        val asistencias =  asistenciasService.getAll()
        return ResponseEntity.ok(asistencias)
    }



    @GetMapping("/{idAsistencia}")
    fun getById(
        @PathVariable("idAsistencia") id:String
    ): ResponseEntity<AsistenciaMedica> {

        if (id.isBlank()){
            //Lanzamos la exception
            throw ValidationException("id no puede estar vacio")
        }
        val asistencia = asistenciasService.getById(id)?: throw NotFoundException("Seguro not found")

        return ResponseEntity.ok(asistencia)
    }



    @PostMapping("/seguros/{idSeguro}/asistencias")
    fun insert(
        @RequestBody seguro: Seguro
    ): ResponseEntity<Seguro> {
        val seguro = seguroService.insert(seguro)?: throw ValidationException("El seguro ya existente")

        return ResponseEntity.ok(seguro)
    }



    @PutMapping("/{idAsistencia}")
    fun update(
        @PathVariable("idAsistencia") id:Int,

        @RequestBody asistenciaMedica: AsistenciaMedica
    ): ResponseEntity<Seguro> {
        val asistencia = asistenciasService.update(id, asistenciaMedica)?: throw ValidationException("La asistencia no existe")

        return ResponseEntity.ok(asistencia)
    }



    @DeleteMapping("/{idAsistencia}")
    fun delete(
        @PathVariable("idAsistencia") id:Int
    ): ResponseEntity<Boolean> {
        val asistencia =  asistenciasService.delete(id)?:throw NotFoundException("Asistencia medica not found")

        return ResponseEntity.ok(asistencia)
    }

}