package GUIApp

import Historiales.HTriangulo
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
import com.example.programafiguras.R
import com.example.programafiguras.TEquilatero
import com.example.programafiguras.TRectangulo
import com.example.programafiguras.Triangulo


class Fragmento2 : Fragment() {

    lateinit var actividad: Activity
    var historial: HTriangulo = HTriangulo()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_fragmento2,container,false)

        val ladoA: EditText = view.findViewById(R.id.ladoA)
        val ladoB: EditText = view.findViewById(R.id.ladoB)
        val ladoC: EditText = view.findViewById(R.id.ladoC)
        val tabla: TableLayout = view.findViewById(R.id.tabla)

        val comboDatos: Spinner = view.findViewById(R.id.spinnerTipo)
        val options:Array<String> = arrayOf("Triángulo Rectángulo", "Triángulo Equilátero")
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(actividad, android.R.layout.simple_spinner_dropdown_item, options)
        comboDatos.adapter =adapter

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



            for (i in (0 until historial.triangulos.size)){

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

                tv1.text="${historial.triangulos[i]} "
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

        val btm_calcular: Button = view.findViewById(R.id.btm_calcular)
        btm_calcular.setOnClickListener {
            try{
                val ladoA: Float = ladoA.text.toString()!!.toFloat()
                val ladoB: Float = ladoB.text.toString()!!.toFloat()
                val ladoC: Float = ladoC.text.toString()!!.toFloat()

                val t0: TRectangulo = TRectangulo(ladoA, ladoB, ladoC)
                val t1: TEquilatero = TEquilatero(ladoA, ladoB, ladoC)


                if(comboDatos.selectedItem.toString() == "Triángulo Rectángulo" && t0.verificarRectangulo()){
                        area.text = "El área es: " + calcularAreaRectangulo(ladoA, ladoB, ladoC).toString()
                        perimetro.text = "El perímetro es: " + calcularPerimetroRectangulo(ladoA, ladoB, ladoC).toString()
                        tabla.removeAllViews()
                        setDatos()
                        Toast.makeText(actividad, "Los datos se calcularon correctamente", Toast.LENGTH_SHORT).show()
                }
                else if(comboDatos.selectedItem.toString() == "Triángulo Rectángulo"){
                    Toast.makeText(actividad, "El triángulo no es rectángulo", Toast.LENGTH_SHORT).show()
                }

                if(comboDatos.selectedItem.toString() == "Triángulo Equilátero" && t1.verificarEquilatero()){
                        area.text = "El área es: " + calcularAreaEquilatero(ladoA, ladoB, ladoC).toString()
                        perimetro.text = "El perímetro es: " + calcularPerimetroEquilatero(ladoA, ladoB, ladoC).toString()
                        tabla.removeAllViews()
                        setDatos()
                        Toast.makeText(actividad, "Los datos se calcularon correctamente", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(actividad, "El triángulo no es equilátero", Toast.LENGTH_SHORT).show()
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

    fun calcularAreaRectangulo(ladoA: Float, ladoB: Float, ladoC: Float): Float{
        var t1: Triangulo = TRectangulo(ladoA, ladoB, ladoC)
        historial.triangulos.add(t1)
        return t1.area()
    }

    fun calcularPerimetroRectangulo(ladoA: Float, ladoB: Float, ladoC: Float): Float{
        var t1: Triangulo = TRectangulo(ladoA, ladoB, ladoC)
        return t1.perimetro()
    }

    fun calcularAreaEquilatero(ladoA: Float, ladoB: Float, ladoC: Float): Float{
        var t2: Triangulo = TEquilatero(ladoA, ladoB, ladoC)
        historial.triangulos.add(t2)
        return t2.area()
    }

    fun calcularPerimetroEquilatero(ladoA: Float, ladoB: Float, ladoC: Float): Float{
        var t2: Triangulo = TEquilatero(ladoA, ladoB, ladoC)
        return t2.perimetro()
    }

}