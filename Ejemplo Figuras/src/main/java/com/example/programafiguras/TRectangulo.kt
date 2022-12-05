package com.example.programafiguras

class TRectangulo: Triangulo {

    constructor(){
    }

    constructor(ladoA: Float, ladoB: Float, ladoC: Float):super(ladoA, ladoB, ladoC){
    }

    fun verificarRectangulo(): Boolean{
        var rta: Boolean = false
        if((ladoA*ladoA) == (ladoB*ladoB)+(ladoC*ladoC)){
            rta = true
        }
        if((ladoB*ladoB) == (ladoA*ladoA)+(ladoC*ladoC)){
            rta = true
        }
        if((ladoC*ladoC) == (ladoA*ladoA)+(ladoB*ladoB)){
            rta = true
        }

        return rta
    }

    override fun area(): Float {
        if((ladoA*ladoA) == (ladoB*ladoB)+(ladoC*ladoC)){
            return (ladoB * ladoC)/2
        }
        if((ladoB*ladoB) == (ladoA*ladoA)+(ladoC*ladoC)){
            return (ladoA * ladoC)/2
        }
        if((ladoC*ladoC) == (ladoA*ladoA)+(ladoB*ladoB)){
            return (ladoA * ladoB)/2
        }
        else{
            return 0f
        }
    }

    override fun perimetro(): Float {
        return ladoA + ladoB + ladoC
    }

    override fun toString(): String {
        return "T. Rectángulo - Area ${area()} Perimetro ${perimetro()}"
    }
}