package com.example.programafiguras

fun main(){
        //Prueba Cuadrilateros
    var figuras: ArrayList<Figura> = ArrayList<Figura>()

    var figura1: Cuadrilatero = Cuadrado(2f,4f)
    var figura2: Cuadrilatero = Trapecio(2f,3f,5f,4f,4f)

    figuras.add(figura1)
    figuras.add(figura2)
    println("${figura1.area()} - ${figura1.perimetro()}")

    println("${figuras[1].area()} - ${figuras[1].perimetro()}")

    var figura3: Triangulo = TEquilatero(3f,3f,3f)
    var figura4: Triangulo = TRectangulo(4f,3f,5f)

    figuras.add(figura3)
    figuras.add(figura4)

    for(i in (2 until figuras.size)){
        println("Figura ${i+1}: ${figuras[i].area()} - ${figuras[i].perimetro()}")
    }

}