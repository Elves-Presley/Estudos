package beecrowd;
import java.util.Scanner;

public class PositivosMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numeros = new int[6];
        int qtdPositivos = 0, somaPositivos = 0;
        double media;
        
        for(int i = 0; i < numeros.length; i++){
            numeros[i] = sc.nextInt();
        }

        for (int i : numeros) {
            if (i > 0) {
                qtdPositivos++;
                somaPositivos += i;
            }
        }
        
        media = (double)somaPositivos / qtdPositivos;

        System.out.printf("%d numeros positivos\n", qtdPositivos);
        System.out.printf("%.1f",media);

        sc.close();
    }
}
