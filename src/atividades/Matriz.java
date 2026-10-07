package atividades;
import java.util.Random;
import java.util.Scanner;
public class Matriz {

     public static void main(String[] args){

        //Objetos que serão utilizados.
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        //Variáveis principais
        int ordemMatriz;
        int produtoDiagonalPrincipal;
        int produtoDiagonalSecundaria;
        int determinante2x2;
        int determinante3x3;
        
        System.out.println("PROGRAMA PARA CÁLCULO DE MATRIZES\n\n");
        System.out.println("->Por favor, digite um valor entre 2 e 5. Esse valor será corresponderá ao número de linhas e colunas da nossa matriz.\n");
        ordemMatriz = scanner.nextInt();

        //Loop para que seja digitado um valor válido para a matriz
        while(!(ordemMatriz >= 2 && ordemMatriz <= 5)){
            System.out.println("\n->Número inválido. Por favor, digite um valor válido entre 0 e 5.");
            ordemMatriz = scanner.nextInt();
        }

        //Com a ordem da Matriz correta basta criar essa Matriz e preencher
        int[][] matrizQuadrada = new int[ordemMatriz][ordemMatriz];
        
        for (int i = 0; i < ordemMatriz; i++) {
            for (int j = 0; j < ordemMatriz; j++) {
                matrizQuadrada[i][j] = Matriz.chanceZeroMaior();
            }
        }

        System.out.println("\nMATRIZ CRIADA");
        Matriz.exibirMatriz(matrizQuadrada, ordemMatriz);
        System.out.println();

        System.out.println("MATRIZ TRANSPOSTA");
        exibirMatrizTransposta(matrizQuadrada, ordemMatriz);
        System.out.println();

        produtoDiagonalPrincipal = Matriz.produtoDiagonalPrincipal(matrizQuadrada, ordemMatriz);
        System.out.printf("PRODUTO DIAGONAL PRINCIPAL -> %d\n", produtoDiagonalPrincipal);

        produtoDiagonalSecundaria = Matriz.produtoDiagonalSecundaria(matrizQuadrada, ordemMatriz);
        System.out.printf("PRODUTO DIAGONAL SECUNDARIA -> %d\n", produtoDiagonalSecundaria);

        switch (ordemMatriz) {
            case 2:
                determinante2x2 = determinante2x2(matrizQuadrada, ordemMatriz);
                System.out.printf("DETERMINANTE MATRIZ 2X2 -> %d\n", determinante2x2);
                break;

            case 3:
                determinante3x3 = determinante3x3(matrizQuadrada, ordemMatriz);
                System.out.printf("DETERMINANTE MATRIZ 3X3 -> %d\n", determinante3x3);
                break;
            case 4:
                Matriz.criarSubMatriz(matrizQuadrada, 3, 3);
                break;
            case 5:
                break;
            default:
                System.out.println("\nNão conseguimos calcular um determinante para a sua Matriz. Isso será implementado no futuro.");
                break;
        }
        
        scanner.close();
     }
     
     
     
     //Método para exibir a matriz
    public static void exibirMatriz(int[][] matriz, int n){
         for(int i = 0; i < n; i++){
             System.out.println();

                for(int j = 0; j < n; j++){
                    System.out.printf("%4d ",matriz[i][j]);
             }
        }
        System.out.println();
    }
     
    //Exibir a transposta da matrizes
    public static void exibirMatrizTransposta(int[][] matriz, int n){
         for(int i = 0; i < n; i++){
             System.out.println();
                for(int j = 0; j < n; j++){
                    System.out.printf("%4d ",matriz[j][i]);
             }
        }
        System.out.println();
    }
     
    //Produto Diagonal principal
     public static int produtoDiagonalPrincipal(int[][] matriz, int n){
         int produto = 1;
        
        for(int i = 0; i < n; i++){
            produto *= matriz[i][i];
        }
        return produto;
     }
     
     //Produto diagonal secundaria
     public static int produtoDiagonalSecundaria(int[][] matriz, int n){
         int produto = 1;
         int i = 0;
         int j;
        
        for (j = n - 1; j >= 0 ; j--) {
            produto *= matriz[i][j];
            i++;
        }
        return produto;
     }
     
     //Determinante 2x2
     public static int determinante2x2(int[][] matriz, int n){
        int determinante = Matriz.produtoDiagonalPrincipal(matriz, n) - Matriz.produtoDiagonalSecundaria(matriz, n);
        return determinante;
     }
     
     //Determinante 3x3
     public static int determinante3x3(int[][] matriz, int n){

         int determinante;
         int produtoPrincipal1 = 1;
         int produtoPrincipal2 = 1;
         int produtoPrincipal3 = 1;
         
         int produtoSecundario1 = 1;
         int produtoSecundario2 = 1;
         int produtoSecundario3 = 1;

         produtoPrincipal1 = Matriz.produtoDiagonalPrincipal(matriz, n);
         produtoSecundario1 = Matriz.produtoDiagonalSecundaria(matriz, n);
         
         for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(i == 0 && j == 1 || i == 1 && j == 2 || i == 2 && j == 0){
                    produtoPrincipal2 *= matriz[i][j];
                }
                
                if(i == 0 && j == 2 || i == 1 && j == 0 || i == 2 && j == 1){
                    produtoPrincipal3 *= matriz[i][j];
                }


                
                if(i == 0 && j == 0 || i == 1 && j == 2 || i == 2 && j == 1){
                    produtoSecundario2 *= matriz[i][j];
                }
                
                if(i == 0 && j == 1 || i == 1 && j == 0 || i == 2 && j == 2){
                    produtoSecundario3 *= matriz[i][j];
                }
            }
        }
        
         determinante = (produtoPrincipal1 + produtoPrincipal2 + produtoPrincipal3) - (produtoSecundario1 + produtoSecundario2 + produtoSecundario3);
         return determinante;
     }
     
<<<<<<< HEAD
     public static int determinante4x4(int[][] matriz, int n){

        int[] numerosZeroLinha = new int[n];
        int[] numerosZeroColuna = new int[n];

        int indiceMaiorLinha = 0, indiceMaiorColuna = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (matriz[i][j] == 0) {
                    numerosZeroLinha[i]++;
                    numerosZeroColuna[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(numerosZeroLinha[i] > numerosZeroColuna[indiceMaiorLinha]){
                indiceMaiorLinha = i;
            }

            if(numerosZeroColuna[i] > numerosZeroColuna[indiceMaiorColuna]){
                indiceMaiorColuna = i;
            }
        }

        if(numerosZeroLinha[indiceMaiorLinha] > numerosZeroColuna[indiceMaiorColuna]){


        }else{

        }
        
        return 0;
     }

     public static int criarSubMatriz(int[][] matriz, int a, int b){
        int n = matriz.length;
        int[][] subMatriz = new int[n - 1][n - 1];
        int apoio1 = 0, apoio2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != a && j != b){
                    subMatriz[apoio1][apoio2++] = matriz[i][j];

                    if (apoio2 == (n - 1)) {
                        apoio2 = 0;
                        apoio1++;
                    }
                }
            }
        }

        Matriz.exibirMatriz(subMatriz, n-1);
=======
     public static int chanceZeroMaior(){

        int zeroTalvez = (int) (Math.random() * 4);
        if(zeroTalvez == 0) return 0;

        int esseNaoEZero = (int)(Math.random() * 21) - 10;
        return esseNaoEZero; 

     }

     public static int determinante4x4(int[][] matriz, int n){
        
        int[] zeroLinhas = new int[n]; //Iniciou com zeros por padrão?
        int[] zeroColunas = new int[n];
        int posLinhaMaior = 0, posColunaMaior = 0;

        //primeiro saber qual a linha ou coluna com mais zeros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == 0) {
                    zeroLinhas[i]++;
                    zeroColunas[j]++;
                }
            }

            for (int k = 0; k < (n - 1); k++) { //até o antepen´ltimo para comparar 2 a 2
                posLinhaMaior = (zeroLinhas[k] > zeroLinhas[k + 1]) ? k : posLinhaMaior;
                posColunaMaior = (zeroColunas[k] > zeroColunas[k + 1]) ? k : posLinhaMaior;
            }

            //Agora eu sei a posição da maior linha e maior coluna, enão basta verificar que dos dois é maior de fato e segui o processamento em vista disso

            if(zeroLinhas[posLinhaMaior] > zeroColunas[posColunaMaior]){
                int[] matrizElementoAij = new int[n];
                int[] colunaElementoAij = new int[n];
                int aux1 = 0;
                int aux2 = 0;
                int aux3 = 0;

                for (int r = 0; r < n; r++) {
                    if(matriz[posLinhaMaior][r] != 0){ 
                        matrizElementoAij[aux1++] = matriz[posLinhaMaior][r];
                        colunaElementoAij[aux2++] = r;
                    }
                }

                //Preciso da matriz de ordem 3 agora para calcular o cofator
                int[][][] matrizParaCofator = new int[n][n-1][n-1]; //Matriz de 3 dimensões em que a primeira indica o "Indice" da matriz
                
                aux1 = 0;
                aux2 = 0; //Resentando o auxiliar
                aux3 = 0;

                //Vamos descobrir que são as nossas matrizes para calcular o cofator
                for (int s = 0; s < n; s++) { //aqui são as linhas
                    for (int t= 0; t < n; t++) { //Aqui colunas
                        if (colunaElementoAij[aux1] == t) {continue;}
                        // int[aux3][s][]
                            
                        
                    }
                }
            }else{

            }
            
        }
>>>>>>> 7086cebdf4982f2d9781d67773e58d79ad0656d4
        return 0;
     }
}
