import java.util.Arrays;

public class ModificarVariables {
    public static void main(String[] args) {
        // Definir arrays
        int[] arrayA = {1, 2, 3};
        int[] arrayB = {4, 5, 6};
        int[] arrayC = {7, 8, 9};

        // Imprimir arrays iniciales
        System.out.println("Arrays iniciales: A = " + Arrays.toString(arrayA) + ", B = " + Arrays.toString(arrayB) + ", C = " + Arrays.toString(arrayC));

        // Llamar a la función para modificar los arrays
        modificarArrays(arrayA, arrayB, arrayC);

        // Imprimir arrays después de la modificación
        System.out.println("Arrays después de la modificación: A = " + Arrays.toString(arrayA) + ", B = " + Arrays.toString(arrayB) + ", C = " + Arrays.toString(arrayC));
    }

    // Función que modifica los elementos de los arrays
    private static void modificarArrays(int[] x, int[] y, int[] z) {
        // Modificar los elementos de los arrays dentro de la función
        x[0] = 10;
        y[1] = 20;
        z[2] = 30;
    }
}
