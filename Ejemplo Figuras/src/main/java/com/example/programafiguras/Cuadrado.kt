package com.example.programafiguras

class Cuadrado : Cuadrilatero{

    constructor(){

    }

    constructor(ladoA: Float, ladoB: Float):super(ladoA,ladoB){

    }

    override fun area(): Float {
        return ladoA * ladoB
    }

    override fun perimetro(): Float {
        return (2)*(ladoA + ladoB)
    }

    override fun toString(): String {
        return "Cuadrado - Area ${area()} Perimetro ${perimetro()}"
    }
}