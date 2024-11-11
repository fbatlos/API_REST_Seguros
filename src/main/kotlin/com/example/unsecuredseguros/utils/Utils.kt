package com.example.unsecuredseguros.utils

import com.example.unsecuredseguros.model.Seguro

object Utils {

    fun checkSeguro(seguro: Seguro): Boolean {
        checkNIF(seguro.nif)?:return false
        vacioString(seguro.nombre) ?:return false
        vacioString(seguro.ape1)?:return false
        checkEdad(seguro.edad)?:return false
        seguro.sexo ?: return false
        numHijos(seguro.numHijos)?:return false
        if (!seguro.casado){seguro.numHijos = 0}
        embarazada(seguro.embarazada,seguro.sexo)?:return false
        return true
    }

    private fun checkNIF(nif:String): Boolean? {
        if (nif.length != 9) return null
        val letras = "TRWAGMYFPDXBNJZSQVHLCKE"
        val numero = nif.substring(0, 8).toIntOrNull() ?: return null
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
        sexo.uppercase()
        if (embarazada && sexo == "MUJER"){return true}
        return null
    }

}