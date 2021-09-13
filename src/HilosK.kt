class HilosK(val id: Int, val arr: IntArray) : Thread() {

    //Para lanzar Hilos se nacen desde el Thead

    override fun run() {
        println("Soy el numero : $id")
        leerArrgelos(arr)
    }

    private fun leerArrgelos(arr: IntArray) {
        println("\n Inicio cilos de Hilos con el for")
        for (nn in arr) {
            println(nn)
        }
    }

}