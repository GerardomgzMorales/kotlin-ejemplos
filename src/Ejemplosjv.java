import java.util.*;
import java.util.stream.Collectors;

public class Ejemplosjv {

    /*public static void main(String[] args) {
        Ejemplos vej = new Ejemplos();

        System.out.println(Ejemplos.NUMEROTE);

        Ejemplos.primerMetodoArreglos();
        Ejemplos.segundaFuncion();

        System.out.println("\n Inicio Arreglos paises\n");
        Ejemplos.primerMetodoArreglos();
        System.out.println("\n Fin Arreglos paises\n");

        System.out.println("\n Hilos inicio \n");
        var hiloPrincipal = new HilosK(20, vej.arregloEnteros());
        hiloPrincipal.start(); // Se lanza El primer Hilos

        System.out.println("\n valores regreso \n");

        vej.nombresPersonas();

        System.out.println("\n valores regreso \n");

        String[] otro = {"Mexico", "España", "Colombia", "Canada"};

        for (int a = 0; a < otro.length / 2; a++) {
            String respaldo = otro[a];
            otro[a] = otro[otro.length - 1 - a];
            otro[otro.length - 1 - a] = respaldo;
        }

        System.out.println(otro);


    }*/


    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        int i, arreglo[];
        arreglo = new int[10];
        for (i = 0; i < 10; i++) {
            System.out.println("Ingrese un numero: ");
            arreglo[i] = scanner.nextInt();
        }

        // como en cada iteración del for se muestran dos números
        // solo necesitaremos recorrer la mitad de iteraciones, con eso es suficiente.
        System.out.println("El resultado es:");
        for (i = 0; i <= 4; i++) {
            System.out.println(arreglo[9 - i]); // y el i-ésimo por el final
            System.out.println(arreglo[i]); // mostramos el i-ésimo número por el principio
        }*/

        histograma();
    }

    public static void arreglodesordenado() {
        Integer[] numeros = new Integer[10];

        for (int a = 0; a < numeros.length; a++) {
            System.out.println("Ingresa el numero " + (a + 1) + ": ");
            numeros[a] = new Scanner(System.in).nextInt();
        }
        System.out.println("\n\n");
        int i = 0;
        for (int a = 0; a < numeros.length; a++) {
            if (a % 2 == 0) {
                System.out.println(numeros[numeros.length - 1 - i++]);
            } else {
                System.out.println(numeros[i - 1]);
            }
        }

        Arrays.sort(numeros);
        System.out.println("\n\n\n");
        for (int a : numeros) {
            System.out.println(a);
        }
    }

    public static void numeroMayor() {
        Integer[] numero = new Integer[7];

        for (int a = 0; a < numero.length; a++) {
            System.out.println("Ingresa el numero " + (a + 1) + ": ");
            numero[a] = new Scanner(System.in).nextInt();
            while (numero[a] < 11 || numero[a] > 99) {
                System.out.println("Ingresa el numero " + (a + 1) + ": ");
                numero[a] = new Scanner(System.in).nextInt();
            }
        }

        Arrays.sort(numero);

        System.out.println("El numero mayor es: " + numero[numero.length - 1]);

    }


    public static void promedios() {
        /*Leer 7 números por teclado para llenar un arreglo y a continuación calcular el promedio de los números positivos,
         el promedio de los negativos y contar el número de ceros.*/

        Integer[] numero = new Integer[7];

        int positivo = 0;
        int negativo = 0;
        int ceros = 0;
        int i = 0;
        int promedioPositivo = 0;
        int promedioNegativo = 0;


        for (int a = 0; a < numero.length; a++) {
            System.out.println("Ingresa calificacion " + (a + 1) + ": ");
            numero[a] = new Scanner(System.in).nextInt();

            if (numero[a] > 0) {
                promedioPositivo += numero[a];
                positivo++;
            } else if (numero[a] == 0) {
                ceros++;
            } else {
                promedioNegativo += numero[a];
                negativo++;
            }
        }

        System.out.println("\nNumero de ceros son: " + ceros);
        System.out.println("\nPromedio enteros: " + ((positivo == 0) ? "No hay promedio" : promedioPositivo / positivo));
        System.out.println("\nPromedio negativos: " + ((negativo == 0) ? "No hay promedio" : promedioNegativo / negativo));


    }

    public static void numeroRepetido() {
        Integer[] numero = new Integer[10];

        for (int a = 0; a < numero.length; a++) {
            System.out.println("Ingresa numero " + (a + 1) + ": ");
            numero[a] = new Scanner(System.in).nextInt();
        }

        Arrays.sort(numero);
        var listaNumero = Arrays.asList(numero).stream().filter(a -> Collections.frequency(Arrays.asList(numero), a) > 1).collect(Collectors.toList());

        HashMap<Integer, Integer> mapa = new HashMap<>();

        for (int x = 0; x < listaNumero.size(); x++) {
            Integer valor = listaNumero.get(x);
            if (mapa.containsKey(valor)) {
                mapa.put(valor, mapa.get(valor) + 1);
            } else {
                mapa.put(valor, 1);
            }
        }

        System.out.println("\nEl numero y su repeticion (Numero = # veces): => " + mapa);

    }


    public static void histograma() {
        Integer[] numeros = new Integer[7];

        for (int a = 0; a < numeros.length; a++) {
            System.out.println((a + 1) + ") Ingresa un numero del 1 a 6: ");
            numeros[a] = new Scanner(System.in).nextInt();
            while (numeros[a] < 1 || numeros[a] > 6) {
                System.out.println((a + 1) + ") Ingresa un numero del 1 a 6: ");
                numeros[a] = new Scanner(System.in).nextInt();
            }
        }

        Arrays.sort(numeros);
        HashMap<Integer, Integer> mapa = new HashMap<>();

        for (int x = 0; x < numeros.length; x++) {
            Integer valor = numeros[x];
            if (mapa.containsKey(valor)) {
                mapa.put(valor, mapa.get(valor) + 1);
            } else {
                mapa.put(valor, 1);
            }
        }

        StringBuilder v = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (mapa.containsKey(i + 1)) {

                for (int h = 0; h < mapa.get(i + 1); h++) {
                    v.append("*");
                }
                System.out.println((i + 1) + " - " + v);
                v.delete(0, v.length());
            } else {
                System.out.println((i + 1) + " - ");
            }
        }
    }

}
