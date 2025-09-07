Modelo de datos

Definimos una clase de datos empleado que representa la información básica de un trabajador:

data class empleado(
    val nombre : String,
    val edad : Int,
    var salario : Int,
    var departamento : Int
)

Colección principal

Creamos una lista de empleados de ejemplo:

val empleados = listOf(
    empleado("david", 46, 1000, 1841),
    empleado("daniela", 23, 2340, 2861),
    empleado("juan", 20, 2991, 1842),
    empleado("enrique", 70, 2332, 1021),
    empleado("pablo", 17, 2999, 3211),
    empleado("joahn", 23, 1299, 1011)
)

Operaciones realizadas
1. Filtrar empleados mayores de 30 años
val mayores = empleados.filter { it.edad >= 30 }

- Devuelve una lista con los empleados cuya edad es mayor o igual a 30.

2. Agrupar empleados por nombre y departamento
val personaDepartamento = empleados.groupBy { it.nombre to it.departamento }



- groupBy genera un mapa donde la clave es un par (nombre, departamento) y el valor es la lista de empleados que cumplen con esa clave.

3. Calcular salario promedio por departamento
val salarioPromedioPorEdad = empleados
    .groupBy { it.departamento }
    .mapValues { (_, lista) -> lista.map { it.salario }.average() }

groupBy → Agrupa empleados por departamento.

mapValues → Transforma la lista de empleados en el promedio de sus salarios.

(_, lista) → Destructuring: ignoramos la clave (departamento) y usamos solo la lista.

4. Crear un mapa nombre → salario
val nombreSalario = empleados.associate { it.nombre to it.salario }



-associate genera un mapa donde la clave es el nombre y el valor el salario.

Ejecución del programa
fun main() {
    for ((departamento, promedio) in salarioPromedioPorEdad) {
        println("departamento: $departamento -> Salario promedio: $promedio")
    }
    println(nombreSalario)
}
