data class empleado(
    val nombre : String,
    val edad : Int,
    var salario : Int,
    var departamento : Int
)

val empleados = listOf(
    empleado("david", 46, 1000, 1841),
    empleado("daniela", 23, 2340, 2861 ),
    empleado("juan", 20, 2991, 1842),
    empleado("enrique", 70, 2332, 1021),
    empleado("pablo", 17, 2999, 3211),
    empleado("joahn", 23, 1299,1011)
)

val mayores = empleados.filter {it.edad >= 30}
val personaDepartamento = empleados.groupBy {it.nombre to  it.departamento}
// to tambine cierve para ¿fucnionar?, creo
val salarioPromedioPorEdad = empleados
    .groupBy { it.departamento }
    .mapValues { (_, lista) -> lista.map { it.salario }.average() }
//mapValues transforma los valores del mapa (las lista) pero deja intacta las claves
// (_,lista) es destruturing.
    // -   : la clave(que en este caso es el departamento,pero no la usamos
    // lista : la lista de empleados de este departamento.
    // lista.map { it.salario } : esto hace que
    // .average() es para  sacar el promedio de los valores numericos de la lista

val nombreSalario = empleados.associate { it.nombre to it.salario }

    fun main(){
    for ((edad, promedio) in salarioPromedioPorEdad) {
        println("departamento: $edad -> Salario promedio: $promedio")
    }
        println(nombreSalario)
}