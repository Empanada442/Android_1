

fun main() {
    println("MENU DE LA SUPER TIENDA VIP")
    println("0- salir")
    println("1- banano")
    println("2- escoba")
    println("3- gato")
    println("4- balon futbol")
    println("5- jabon")
    println("6- silla oficina")
    println("7- celular")
    println("8- perro")

    val listaProductos = mutableListOf<Pair<String, Int>>()

    while (true) {
        try {
            println("Ingrese el producto (1-8) para ingresar productos, 0 para salir:")
            val op1: Int = readLine()?.toIntOrNull() ?: -1

            if (op1 in 1..8) {
                producto(op1)
                println("Ingrese la cantidad:")
                val op2: Int = readLine()?.toIntOrNull() ?: 0
                val op3 = Precio(op1)
                val total = op2 * op3
                println("Total: $$total")
                listaProductos.add(productoNombre(op1) to op2)
            } else if (op1 == 0) {
                break
            } else {
                println("Ingrese un dato válido del 0 al 8.")
            }
        } catch (e: NumberFormatException) {
            println("Ingrese un dato válido del 0 al 8.")
        }
    }

    // Crear factura
    println("Factura:")
    var totalCompra = 0
    for ((nombre, cantidad) in listaProductos) {
        val precioUnitario = Precio(productoID(nombre))
        val subtotal = cantidad * precioUnitario
        println("$nombre x $cantidad = $$subtotal")
        totalCompra += subtotal
    }
    println("Total a pagar: $$totalCompra")
}

fun productoID(nombre: String): Int {
    return when (nombre.toLowerCase()) {
        "banano" -> 1
        "escoba" -> 2
        "gato" -> 3
        "balón de fútbol" -> 4
        "jabón" -> 5
        "silla de oficina" -> 6
        "celular" -> 7
        "perro" -> 8
        else -> 0
    }
}

fun producto(op1: Int) {
    println("Producto seleccionado:")
    println(productoNombre(op1))
}

fun productoNombre(op1: Int): String {
    return when (op1) {
        1 -> "Banano"
        2 -> "Escoba"
        3 -> "Gato"
        4 -> "Balón de fútbol"
        5 -> "Jabón"
        6 -> "Silla de oficina"
        7 -> "Celular"
        8 -> "Perro"
        else -> "Producto no válido"
    }
}

fun Precio(op1: Int): Int {
    return when (op1) {
        1 -> 900
        2 -> 4000
        3 -> 54000
        4 -> 17500
        5 -> 6000
        6 -> 42000
        7 -> 2650000
        8 -> 78000
        else -> 0
    }
}
