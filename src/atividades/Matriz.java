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
        int determinante4x4;
        int determinante5x5;

        
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
                matrizQuadrada[i][j] = Matriz.randomProbabilidadeZero();
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
                determinante4x4 = determinanteGeral(matrizQuadrada, ordemMatriz);
                System.out.printf("DETERMINANTE MATRIZ 4X4 -> %d\n", determinante4x4);
                break;
            case 5:
                determinante5x5 = determinanteGeral(matrizQuadrada, ordemMatriz);
                System.out.printf("DETERMINANTE MATRIZ 5X5 -> %d\n", determinante5x5);
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
     
     public static int determinanteGeral(int[][] matriz, int n){

        int determinante;
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
            if(numerosZeroLinha[i] > numerosZeroLinha[indiceMaiorLinha]){
                indiceMaiorLinha = i;
            }

            if(numerosZeroColuna[i] > numerosZeroColuna[indiceMaiorColuna]){
                indiceMaiorColuna = i;
            }
        }

        if(numerosZeroLinha[indiceMaiorLinha] > numerosZeroColuna[indiceMaiorColuna]){
            int resultado = 0;

            for (int j = 0; j < n; j++) {
                if (matriz[indiceMaiorLinha][j] != 0) {
                    resultado += matriz[indiceMaiorLinha][j] * Matriz.cofator(indiceMaiorLinha, j, Matriz.criarSubMatriz(matriz, indiceMaiorLinha, j));
                }
            }

            determinante = resultado;

        }else{
            int resultado = 0; //Escopo diferente.

            for (int i = 0; i < n; i++) {

                if (matriz[i][indiceMaiorColuna] != 0) {
                    resultado += matriz[i][indiceMaiorColuna] * Matriz.cofator(i, indiceMaiorColuna, Matriz.criarSubMatriz(matriz, i, indiceMaiorColuna));
                }
            }

            determinante = resultado;

        }

        
        
        return determinante;
     }

     public static int[][] criarSubMatriz(int[][] matriz, int a, int b){
        int n = matriz.length;
        int[][] subMatriz = new int[n - 1][n - 1];

        int apoio1 = 0;
        for (int i = 0; i < n; i++) {
            if (i == a) { continue; }
            
            int apoio2 = 0;
            for (int j = 0; j < n; j++) {
                if (j == b) { continue; }

                subMatriz[apoio1][apoio2] = matriz[i][j];
                apoio2++;
                }
                apoio1++;
            }
            return subMatriz;
        }

     public static int cofator(int i, int j, int[][] subMatriz){
        int cofator;

        if(subMatriz.length == 3){
            cofator = (int) Math.pow(-1, i + j) * Matriz.determinante3x3(subMatriz, subMatriz.length);
        }else{
            cofator = (int) Math.pow(-1, i + j) * Matriz.determinanteGeral(subMatriz, subMatriz.length);
        }

        return cofator;
     }
     
     public static int randomProbabilidadeZero(){

        int chance = (int)(Math.random() * 4); 

        if (chance == 0) return 0;

        int n = (int)(Math.random() * 21) - 10;
        return n;
    }
}
