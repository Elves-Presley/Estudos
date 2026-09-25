import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[5];

        int qtdPositivos = 0, qtdNegativos = 0,  qtdPares = 0, qtdImpar = 0;

        for(int i = 0; i < numeros.length; i++){

            numeros[i] = sc.nextInt();

            if(numeros[i] > 0){
                qtdPositivos++;

            }else if(numeros[i] != 0){
                qtdNegativos++;
            }

            if(numeros[i] % 2 == 0){
                qtdPares++;

            }else{
                qtdImpar++;
            }  
        }

            System.out.println(qtdPares + " valor(es) par(es)");
            System.out.println(qtdImpar + " valor(es) impar(es)");
            System.out.println(qtdPositivos + " valor(es) positivo(s)");
            System.out.println(qtdNegativos + " valor(es) negativo(s)");

            sc.close();
    }
}