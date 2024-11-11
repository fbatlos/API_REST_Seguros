package com.example.unsecuredseguros.controller

import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.services.SeguroServicios
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/seguros")
class SeguroController {

    @Autowired
    private lateinit var seguroService:SeguroServicios

    @GetMapping("/")
    fun getAll(): List<Seguro>{
        return  seguroService.getAll()
    }


    @GetMapping("/{id}")
    fun getById(
        @PathVariable("id") id:Int
    ): Seguro? {
        return seguroService.getById(id)
    }

    @PostMapping("/")
    fun insert(
        @RequestBody seguro: Seguro
    ):Boolean?{
      return  seguroService.insert(seguro)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable("id") id:Int,

        @RequestBody seguro: Seguro
    ):Seguro?{
        return seguroService.update(id, seguro)
    }
}