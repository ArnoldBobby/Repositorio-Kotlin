package GUIApp

import Historiales.HCuadrado
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.programafiguras.Cuadrado
import com.example.programafiguras.Cuadrilatero
import com.example.programafiguras.R
import com.example.programafiguras.Trapecio


class Fragmento1 : Fragment() {

    lateinit var actividad: Activity
    var historial: HCuadrado = HCuadrado()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_fragmento1,container,false)
        val tabla: TableLayout = view.findViewById(R.id.tablaCuadrilatero)

        val comboDatos: Spinner = view.findViewById(R.id.spinnerTipo)
        val options:Array<String> = arrayOf("Cuadrado", "Trapecio")
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(actividad, android.R.layout.simple_spinner_dropdown_item, options)
        comboDatos.adapter =adapter

        val ladoA: EditText = view.findViewById(R.id.ladoA)
        val ladoB: EditText = view.findViewById(R.id.ladoB)
        val ladoC: EditText = view.findViewById(R.id.ladoC)
        val ladoD: EditText = view.findViewById(R.id.ladoD)
        val altura: EditText = view.findViewById(R.id.altura)

        val area: TextView = view.findViewById(R.id.text_Area)
        val perimetro: TextView = view.findViewById(R.id.text_Perimetro)

        //Configuración tabla
        var layour: TableRow.LayoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT)


        @SuppressLint("ResourceAsColor")
        fun setDatos(){
            val tableRow0 = TableRow(requireContext())

            tableRow0.setBackgroundResource(android.R.color.holo_blue_light)
            tableRow0.layoutParams = layour
            tableRow0.setPadding(60,10,10,10)
            //Crear Headers para la tabla
            val textView0 = TextView(requireContext())
            textView0.text=" Número "
            textView0.textSize = 15F
            textView0.setTextColor(Color.BLACK)

            //Agregar textView a la fila de la tabla:
            tableRow0.addView(textView0)
            val textView1 = TextView(requireContext())
            textView1.text=" Tipo y Resultados "
            textView1.textSize = 15F
            textView1.setPadding(20,10,10,10)
            textView1.setTextColor(Color.BLACK)

            //Agregar textView a la fila de la tabla:
            tableRow0.addView(textView1)

            //Agregar fila al tableLayout
            tabla.addView(tableRow0)



            for (i in (0 until historial.cuadrados.size)){

                val tblRow = TableRow(requireContext())
                val tv0 = TextView(requireContext())
                val tv1 = TextView(requireContext())
                val number = TextView(requireContext())

                tblRow.layoutParams = layour
                tblRow.setBackgroundResource(R.color.LightBlue)
                tblRow.setPadding(30,10,30,10)

                tv0.text="${i+1}"
                tv0.layoutParams = layour
                tv0.textSize = 13F
                tv0.setTextColor(Color.BLACK)
                tv0.gravity= Gravity.CENTER
                tblRow.addView(tv0)

                tv1.text="${historial.cuadrados[i]} "
                tv1.setTextColor(Color.BLACK)
                tv1.textSize = 13F
                tv1.setPadding(40 ,10,10,10)
                tv1.layoutParams = layour
                tv1.gravity= Gravity.CENTER
                tblRow.addView(tv1)

                //binding.tableLayout.addView(tblRow)
                tabla.addView(tblRow)
            }

        }

        val btm_Calcular: Button = view.findViewById(R.id.btm_calcular)
        btm_Calcular.setOnClickListener {
            try{
                val ladoA: Float = ladoA.text.toString()!!.toFloat()
                val ladoB: Float = ladoB.text.toString()!!.toFloat()
                val ladoC: Float = ladoC.text.toString()!!.toFloat()
                val ladoD: Float = ladoD.text.toString()!!.toFloat()
                val altura: Float = altura.text.toString()!!.toFloat()

                if((ladoA != 0f ) && (ladoB != 0f )){

                    if(comboDatos.selectedItem.toString() == "Cuadrado"){

                        area.text = "El área es: " + (calcularCuadradoArea(ladoA, ladoB)).toString()
                        perimetro.text = "El perímetro es: "+ (calcularCuadradoPerimetro(ladoA, ladoB)).toString()
                        tabla.removeAllViews()
                        setDatos()
                        Toast.makeText(actividad, "Los datos se calcularon correctamente", Toast.LENGTH_SHORT).show()
                    }

                    if(comboDatos.selectedItem.toString() == "Trapecio"){
                        area.text = "El área es: " + (calcularTrapecioArea(ladoA, ladoB, ladoC, ladoD, altura)).toString()
                        perimetro.text = "El perimetro es: " + (calcularTrapecioPerimetro(ladoA, ladoB, ladoC, ladoD, altura)).toString()
                        tabla.removeAllViews()
                        setDatos()
                        Toast.makeText(actividad, "Los datos se calcularon correctamente", Toast.LENGTH_SHORT).show()
                    }
                }

            }
            catch(e: Exception){
                Toast.makeText(actividad, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
            }

        }


        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is Activity){
            this.actividad = context
        }
    }

    fun calcularCuadradoArea (ladoA: Float, ladoB: Float): Float{
        var cuadrado: Cuadrilatero = Cuadrado(ladoA, ladoB)
        historial.cuadrados.add(cuadrado)
        return cuadrado.area()
    }

    fun calcularCuadradoPerimetro (ladoA: Float, ladoB: Float): Float{
        var cuadrado: Cuadrilatero = Cuadrado(ladoA, ladoB)
        return cuadrado.perimetro()
    }

    fun calcularTrapecioArea(ladoA: Float, ladoB: Float, ladoC: Float, ladoD: Float, altura: Float): Float{
        var trapecio: Cuadrilatero = Trapecio(ladoA, ladoB, altura, ladoC, ladoD)
        historial.cuadrados.add(trapecio)
        return trapecio.area()
    }

    fun calcularTrapecioPerimetro(ladoA: Float, ladoB: Float, ladoC: Float, ladoD: Float, altura: Float): Float{
        var trapecio: Cuadrilatero = Trapecio(ladoA, ladoB, altura, ladoC, ladoD)
        return trapecio.perimetro()
    }

}

