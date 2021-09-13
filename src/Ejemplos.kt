import java.util.*
import java.util.stream.Collectors

class Ejemplos {


    companion object {

        const val NUMEROTE = 2222

        @JvmStatic
        fun primerMetodoArreglos() {
            val paisesNombres: Array<String?> = arrayOfNulls(3)
            paisesNombres[0] = "Mexico"
            paisesNombres[1] = "España"
            paisesNombres[2] = "Canada"
            paisesNombres.sort()
            for (str in paisesNombres) {
                println(str)
            }

        }

        @JvmStatic
        fun segundaFuncion() {
            val numeros = IntArray(2)
            numeros[0] = 1
            numeros[1] = 22

            for (nu in numeros) {
                println(nu)
            }

        }
    }

    fun arregloEnteros(): IntArray {
        val arregloEnteros = IntArray(5)
        arregloEnteros[0] = 20393
        arregloEnteros[1] = 2323
        arregloEnteros[2] = 3234
        arregloEnteros[3] = 322
        arregloEnteros[4] = "334".toInt()
        return arregloEnteros
    }

    fun arregloCadena(): Array<String?> {
        val paises = arrayOfNulls<String>(3)
        paises[0] = "Mexico"
        paises[1] = "Canada"
        paises[2] = "España"
        return paises
    }

    fun arregloDecimal() {
        val pesosPersonas = DoubleArray(3)
        pesosPersonas[0] = 223.33
        pesosPersonas[1] = 322.22
        pesosPersonas[2] = 2311.11
    }

    private fun mostrarDatos(arregloCualquiera: DoubleArray) {
        println("\n\n\n")
        for (arrC in arregloCualquiera) {
            println(arrC)
        }
    }

    fun nombresPersonas(): Array<String?> {
        val personasNombre = arrayOfNulls<String>(4)

        personasNombre[0] = "Pedro Martinez"
        personasNombre[1] = "Catalina Sanchez"
        personasNombre[2] = "Carlos Cartina"
        personasNombre[3] = "Ñañez Soto"

        personasNombre.sort()

        for (a in personasNombre.size - 1 downTo 0) {
            println(personasNombre[a])
        }

        val otro = arrayOf("Mexico", "España", "Colombia", "Canada")

        for (a in 0 until otro.size / 2) {
            val respaldo = otro[a]
            otro[a] = otro[otro.size - 1 - a]
            otro[otro.size - 1 - a] = respaldo
        }

        println(otro)


        return personasNombre
    }


    fun arreglodesordenado() {
        val numeros = arrayOfNulls<Int>(10)
        for (a in numeros.indices) {
            println("Ingresa el numero " + (a + 1) + ": ")
            numeros[a] = Scanner(System.`in`).nextInt()
        }
        println("\n\n")
        var i = 0
        for (a in numeros.indices) {
            if (a % 2 == 0) {
                println(numeros[numeros.size - 1 - i++])
            } else {
                println(numeros[i - 1])
            }
        }
    }


    fun numeroMayor() {
        val numero = arrayOfNulls<Int>(7)
        for (a in numero.indices) {
            println("Ingresa el numero " + (a + 1) + ": ")
            numero[a] = Scanner(System.`in`).nextInt()
            while (numero[a]!! < 11 || numero[a]!! > 99) {
                println("Ingresa el numero " + (a + 1) + ": ")
                numero[a] = Scanner(System.`in`).nextInt()
            }
        }
        Arrays.sort(numero)
        println("El numero mayor es: " + numero[numero.size - 1])
    }


    fun promedios() {
        /*Leer 7 números por teclado para llenar un arreglo y a continuación calcular el promedio de los números positivos,
         el promedio de los negativos y contar el número de ceros.*/
        val numero = arrayOfNulls<Int>(7)
        for (a in numero.indices) {
            println("Ingresa calificacion " + (a + 1) + ": ")
            numero[a] = Scanner(System.`in`).nextInt()
        }
        var positivo = 0
        var negativo = 0
        var ceros = 0
        var i = 0
        var promedioPositivo = 0
        var promedioNegativo = 0
        do {
            if (numero[i]!! > 0) {
                promedioPositivo += numero[i]!!
                positivo++
            } else if (numero[i] == 0) {
                ceros++
            } else {
                promedioNegativo += numero[i]!!
                negativo++
            }
            i++
        } while (i < numero.size)
        println("\nNumero de ceros son: $ceros")
        println(
            """
            
            Promedio enteros: ${if (positivo == 0) "No hay promedio" else promedioPositivo / positivo}
            """.trimIndent()
        )
        println(
            """
            
            Promedio negativos: ${if (negativo == 0) "No hay promedio" else promedioNegativo / negativo}
            """.trimIndent()
        )
    }


    fun numeroRepetido() {
        val numero = arrayOfNulls<Int>(6)
        for (a in numero.indices) {
            println("Ingresa numero " + (a + 1) + ": ")
            numero[a] = Scanner(System.`in`).nextInt()
        }
        Arrays.sort(numero)
        val listaNumero = Arrays.asList(*numero)
        val nlista = listaNumero.stream().filter { a: Int? ->
            Collections.frequency(
                listaNumero,
                a
            ) > 1
        }.collect(Collectors.toList())
        println(nlista)
    }

    fun histograma() {
        val numeros = arrayOfNulls<Int>(7)
        for (a in numeros.indices) {
            println("${(a + 1)}) Ingresa un numero del 1 a 6: ")
            numeros[a] = Scanner(System.`in`).nextInt()
            while (numeros[a]!! < 1 || numeros[a]!! > 6) {
                println("${(a + 1)}) Ingresa un numero del 1 a 6: ")
                numeros[a] = Scanner(System.`in`).nextInt()
            }
        }
        numeros.sort()
        val mapa = HashMap<Int?, Int>()
        for (x in numeros.indices) {
            val valor = numeros[x]
            if (mapa.containsKey(valor)) {
                mapa[valor] = mapa[valor]!! + 1
            } else {
                mapa[valor] = 1
            }
        }
        val v = StringBuilder()
        for (i in 0..5) {
            if (mapa.containsKey(i + 1)) {
                for (h in 0 until mapa[i + 1]!!) {
                    v.append("*")
                }
                println("${(i + 1)} - $v")
                v.delete(0, v.length)
            } else {
                println("${(i + 1)} - ")
            }
        }
    }

}

