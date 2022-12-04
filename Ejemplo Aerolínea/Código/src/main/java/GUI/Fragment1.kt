package GUI



import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.programaaerolinea.*
import com.google.android.material.tabs.TabLayout


class Fragment1 : Fragment() {

    lateinit var actividad: Activity
    var aeropuerto: Aerolínea = Aerolínea()


    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_fragment1, container, false)

        val tabla: TableLayout = view.findViewById(R.id.tablaUsuarios)



        val comboTipo: Spinner = view.findViewById(R.id.box_Tipo)
        val options:Array<String> = arrayOf("Empleado", "Cliente")
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(actividad, android.R.layout.simple_spinner_dropdown_item, options)
        comboTipo.adapter =adapter

        val cedulaText: EditText = view.findViewById(R.id.txt_Cedula)
        val nombreText: EditText = view.findViewById(R.id.txt_Nombre)

        //Configuración tabla
            var layour: TableRow.LayoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT)


        @SuppressLint("ResourceAsColor")
        fun setDatos(){
            val tableRow0 = TableRow(requireContext())

            tableRow0.setBackgroundResource(R.color.Orange2)
            tableRow0.layoutParams = layour
            tableRow0.setPadding(60,10,10,10)
            //Crear Headers para la tabla
            val textView0 = TextView(requireContext())
            textView0.text=" Cédula "
            textView0.setTextColor(Color.BLACK)

            //Agregar textView a la fila de la tabla:
            tableRow0.addView(textView0)
            val textView1 = TextView(requireContext())
            textView1.text=" Nombres y Apellidos "
            textView1.setTextColor(Color.BLACK)

            //Agregar textView a la fila de la tabla:
            tableRow0.addView(textView1)

            //Agregar fila al tableLayout
            tabla.addView(tableRow0)


            for (i in 0..aeropuerto.usuarios.size){

                val tblRow = TableRow(requireContext())
                val tv0 = TextView(requireContext())
                val tv1 = TextView(requireContext())
                val number = TextView(requireContext())

                tblRow.layoutParams = layour
                tblRow.setBackgroundResource(R.color.Yellow2)
                tblRow.setPadding(30,10,30,10)

                tv0.text="${aeropuerto.usuarios[i].getCedulaPersona()}"
                tv0.layoutParams = layour
                tv0.textSize = 16F
                tv0.setTextColor(Color.BLACK)
                tv0.gravity= Gravity.CENTER
                tblRow.addView(tv0)

                tv1.text="${aeropuerto.usuarios[i].getNombrePersona()}"
                tv1.setTextColor(Color.BLACK)
                tv1.textSize = 16F
                tv1.layoutParams = layour
                tv1.gravity=Gravity.CENTER
                tblRow.addView(tv1)

                //binding.tableLayout.addView(tblRow)
                tabla.addView(tblRow)
            }

        }


        val btm_agregar: Button = view.findViewById(R.id.btm_Agregar)
        btm_agregar.setOnClickListener { //Función para el botón agregar
            try {
                var cedulaString: String = cedulaText.text.toString()
                var nombreString: String = nombreText.text.toString()

                if(!cedulaString.isNullOrBlank() && !nombreString.isNullOrBlank()) {

                    if (comboTipo.selectedItem.toString() == "Empleado") {
                        if(agregarUsuario(cedulaString, nombreString, "Empleado")){
                            tabla.removeAllViews()
                            setDatos()
                        }

                    }
                    if (comboTipo.selectedItem.toString() == "Cliente") {
                        if(agregarUsuario(cedulaString, nombreString, "Cliente")){
                            tabla.removeAllViews()
                            setDatos()
                        }

                    }

                }

                else{
                    Toast.makeText(actividad, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                }
            }

            catch (e: java.lang.Exception){
                //Toast.makeText(actividad, "Ocurrió un error", Toast.LENGTH_SHORT).show()
            }

        }

        val btm_eliminar: Button = view.findViewById(R.id.btm_Eliminar)
        btm_eliminar.setOnClickListener { //Función para el botón elimnar
            try {
            var cedulaString: String = cedulaText.text.toString()
            var nombreString: String = nombreText.text.toString()

            if(!cedulaString.isNullOrBlank() && !nombreString.isNullOrBlank()) {

                if (comboTipo.selectedItem.toString() == "Empleado") {
                    if(elimnarUsuario(cedulaString, nombreString, "Empleado")){
                        tabla.removeAllViews()
                        setDatos()
                    }
                }
                if (comboTipo.selectedItem.toString() == "Cliente") {
                    if(elimnarUsuario(cedulaString, nombreString, "Cliente")){
                        tabla.removeAllViews()
                        setDatos()
                    }
                }
            }

            else{
                Toast.makeText(actividad, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        catch (e: java.lang.Exception){
            //Toast.makeText(actividad, "Datos incorrectos", Toast.LENGTH_SHORT).show()
        }

        }

        val btm_buscar: Button = view.findViewById(R.id.btm_Buscar)
        btm_buscar.setOnClickListener {
            try {
                var cedulaString: String = cedulaText.text.toString()
                var nombreString: String = nombreText.text.toString()

                if(!cedulaString.isNullOrBlank() && !nombreString.isNullOrBlank()) {
                        buscarUsuario(cedulaString)
                }

                else{
                    Toast.makeText(actividad, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                }
            }

            catch (e: java.lang.Exception){
                //Toast.makeText(actividad, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }

        }




        return view
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is Activity){
            this.actividad = context
        }
    }

    fun agregarUsuario(cedula: String?, nombre: String?, tipo: String): Boolean{

        var verify: Boolean = false
        if(tipo == "Empleado"){
            var empleado: Persona = Empleado(cedula, nombre)
            if(aeropuerto.agregarUsuario(empleado)){
                verify = true
            }
        }
        if(tipo == "Cliente"){
            var cliente: Persona = Cliente(cedula, nombre)
            if(aeropuerto.agregarUsuario(cliente)){
                verify = true
            }
        }

        if(verify){
            Toast.makeText(actividad, "El usuario se agregó correctamente", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(actividad, "El usuario ya se encuentra agregado", Toast.LENGTH_SHORT).show()
        }

        return verify
    }

    fun elimnarUsuario(cedula: String?, nombre: String?, tipo: String?): Boolean{

        var verify: Boolean = false
        if(tipo == "Empleado"){
            var empleado: Persona = Empleado(cedula, nombre)
            if(aeropuerto.eliminarUsuario(empleado)){
                verify = true
            }
        }
        if(tipo == "Cliente"){
            var cliente: Persona = Cliente(cedula, nombre)
            if(aeropuerto.eliminarUsuario(cliente)){
                verify = true
            }


        }

        if(verify){
            Toast.makeText(actividad, "El usuario se eliminó correctamente", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(actividad, "El usuario no existe", Toast.LENGTH_SHORT).show()
        }
        return verify
    }

    @SuppressLint("SuspiciousIndentation")
    fun buscarUsuario(cedula: String){

        var verify: Boolean = false

            if(aeropuerto.buscarUsuario(cedula) != null){
                verify = true
            }

        if(verify){
            Toast.makeText(actividad, "El usuario existe", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(actividad, "El usuario no existe", Toast.LENGTH_SHORT).show()
        }
    }



    }




