package com.example.unsecuredseguros.utils

import com.example.unsecuredseguros.exception.ValidationException
import com.example.unsecuredseguros.model.Seguro

object Utils {

    fun checkSeguro(seguro: Seguro): Boolean {
        checkNIF(seguro.nif)?:throw ValidationException("El campo NIF no tiene un formato válido.")

        vacioString(seguro.nombre) ?:throw ValidationException("El campo nombre no puede estar vacío.")

        vacioString(seguro.ape1)?:throw ValidationException("El apelledo no puede estar vacio.")

        checkEdad(seguro.edad)?:throw ValidationException("No es posible ser menor de edad para hacer un seguro.")

        seguro.sexo
        numHijos(seguro.numHijos)?:throw ValidationException("Un seguro no puede registrar hijos si no está casado.")

        if (!seguro.casado){seguro.numHijos = 0}
        embarazada(seguro.embarazada,seguro.sexo)?:throw ValidationException("El campo embarazada no puede ser true si el asegurado es hombre.")
        return true
    }

    private fun checkNIF(nif:String): Boolean? {
        if (nif.length != 9) return null
        val letras = "TRWAGMYFPDXBNJZSQVHLCKE"
        val numero = nif.substring(0, 8).toInt()
        val letra = nif.last()
        val letraCalculada = letras[numero % 23]
        if(letra == letraCalculada){return true}else{return null}
    }

    private fun checkEdad(edad: Int): Boolean? {
        if (edad <= 17) return null
        return true
    }

    private fun vacioString(string: String): Boolean? {
        if(string.isEmpty()){return null}
        return true
    }

    private fun numHijos(hijos:Int): Boolean? {
        if (hijos<0)return null
        return true
    }

    private fun embarazada(embarazada:Boolean,sexo:String):Boolean? {
        val sexoUpper= sexo.uppercase()
        if (sexoUpper == "HOMBRE" && embarazada){return null}
        return true
    }

}