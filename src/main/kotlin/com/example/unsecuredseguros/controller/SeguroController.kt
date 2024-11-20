package com.example.unsecuredseguros.controller

import com.example.unsecuredseguros.exception.NotFoundException
import com.example.unsecuredseguros.exception.ValidationException
import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.services.SeguroServicios
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/seguros")
class SeguroController {

    @Autowired
    private lateinit var seguroService:SeguroServicios

    @GetMapping("/")
    fun getAll(): ResponseEntity<List<Seguro>>{
        val seguros =  seguroService.getAll()
        return ResponseEntity.ok(seguros)
    }



    @GetMapping("/{id}")
    fun getById(
        @PathVariable("id") id:String
    ): ResponseEntity<Seguro> {

        if (id.isBlank()){
            //Lanzamos la exception
            throw ValidationException("id no puede estar vacio")
        }
        val seguro = seguroService.getById(id)?: throw NotFoundException("Seguro not found")

        return ResponseEntity.ok(seguro)
    }



    @PostMapping("/")
    fun insert(
        @RequestBody seguro: Seguro
    ):ResponseEntity<Seguro>{
        val seguro = seguroService.insert(seguro)?: throw ValidationException("El seguro ya existente")

        return ResponseEntity.ok(seguro)
    }



    @PutMapping("/{id}")
    fun update(
        @PathVariable("id") id:Int,

        @RequestBody seguro: Seguro
    ):ResponseEntity<Seguro>{
        val seguro = seguroService.update(id, seguro)?: throw ValidationException("El seguro no existe")

        return ResponseEntity.ok(seguro)
    }



    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable("id") id:Int
    ):ResponseEntity<Boolean>{
        val seguro =  seguroService.delete(id)?:throw NotFoundException("Seguro not found")

        return ResponseEntity.ok(seguro)
    }

}