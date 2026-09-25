package beecrowd;
import java.util.Scanner;

public class QuantosPares {
     public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int qtdNumeros = 5;
        int qtdPares = 0;
        int[] numeros = new int[qtdNumeros];

        for(int i = 0; i < numeros.length; i++){
            numeros[i] = sc.nextInt();
        }

        for (int i : numeros) {
            if (i % 2 == 0) {
                qtdPares++;
            }
        }

        System.err.printf("%d valores pares\n", qtdPares);
        sc.close();
    }
}
