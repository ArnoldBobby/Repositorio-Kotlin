package com.example.programafiguras

class TEquilatero: Triangulo {

    constructor(){
    }

    constructor(ladoA: Float, ladoB: Float, ladoC: Float):super(ladoA, ladoB, ladoC){
    }

    fun verificarEquilatero(): Boolean{
        return ladoA == ladoB && ladoB == ladoC
    }


    override fun area(): Float {
        return ((ladoA * ladoA) * Math.sqrt(3.0).toFloat())/4
    }

    override fun perimetro(): Float {
        return 3*ladoA
    }

    override fun toString(): String {
        return "T. Equilátero - Area ${area()} Perimetro ${perimetro()}"
    }

}