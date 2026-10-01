import java.util.Random;
import java.util.Scanner;
public class Matriz {

     public static void main(String[] args){
  
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int produtoDiagonalPrincipal;
        int produtoDiagonalSecundaria;
        int determinante2x2;
        
        System.out.println("Digite um valor entre 2 e 5");
        int n = scanner.nextInt();
        

        if(n >= 2 && n <= 5){

            int[][] matrizQuadrada = new int[n][n];

                for(int i = 0; i < n; i++){

                    for(int j = 0; j < n; j++){
                        matrizQuadrada[i][j] = random.nextInt(21) - 10;
                }
            }
            
            System.out.println("MATRIZ CRIADA COM VALORES ALEÁTORIOS:");
            Matriz.printarMatriz(matrizQuadrada, n);
            
            System.out.println("\nMATRIZ TRANSPOSTA:");
            Matriz.printarMatrizTransposta(matrizQuadrada, n);
            
            System.out.println("Produto da Diagonal Principal");
            produtoDiagonalPrincipal = Matriz.produtoDiagonalPrincipal(matrizQuadrada, n);
            System.out.println(produtoDiagonalPrincipal + "\n");
            
            System.out.println("Produto da Diagonal Secundaria");
            produtoDiagonalSecundaria = Matriz.produtoDiagonalSecundaria(matrizQuadrada, n);
            System.out.println(produtoDiagonalSecundaria + "\n");
            
            System.out.println("Determinante 2x2\n");
            
            if(n == 2){
                determinante2x2 = Matriz.determinante2x2(matrizQuadrada, n);
                System.out.println(determinante2x2 + "\n");
            }else{
                System.out.println("Sem determinante pois a matriz não possui ordem 2\n");
            }
            
            System.out.println("Deeterminante 3x3\n");
            
            if(n == 3){
                determinante2x2 = Matriz.determinante3x3(matrizQuadrada, n);
                System.out.println(determinante2x2 + "\n");
            }else{
                System.out.println("Sem determinante pois a matriz não possui ordem 3\n");
            }
                
            
            

        }else{
            System.out.println("Valor fora do intervalo!");

        }

     }
     
     
     
     
     public static void printarMatriz(int[][] matriz, int n){
         for(int i = 0; i < n; i++){
             
             System.out.println();
             
                for(int j = 0; j < n; j++){
                    System.out.printf("%4d ",matriz[i][j]);
             }
        }
        System.out.println();
    }
     
     public static void printarMatrizTransposta(int[][] matriz, int n){
         for(int i = 0; i < n; i++){
             System.out.println();
                for(int j = 0; j < n; j++){
                    System.out.printf("%4d ",matriz[j][i]);
             }
        }
        System.out.println();
    }
     
    
     public static int produtoDiagonalPrincipal(int[][] matriz, int n){
         int produto = 1;
        
        for(int i = 0; i < n; i++){
            produto *= matriz[i][i];
         
        }
        return produto;
         
     }
     
     public static int produtoDiagonalSecundaria(int[][] matriz, int n){
         int produto = 1;
        
        for(int i = 0; i > n; i--){
            for(int j = (n - 1); j >= 0; j--){
                produto *= matriz[i][i];
            }
        }
        return produto;
     }
     
     public static int determinante2x2(int[][] matriz, int n){
         int determinante = Matriz.produtoDiagonalPrincipal(matriz, n) - Matriz.produtoDiagonalSecundaria(matriz, n);
         return determinante;
     }
     
     public static int determinante3x3(int[][] matriz, int n){
         int determinante;
         int produtoPrincipal1 = 1;
         int produtoPrincipal2 = 1;
         int produtoPrincipal3 = 1;
         
         int produtoSecundario1 = 1;
         int produtoSecundario2 = 1;
         int produtoSecundario3 = 1;
         
         for(int i = 0; i > n; i--){
            for(int j = (n - 1); j >= 0; j--){
                produtoPrincipal1 = Matriz.produtoDiagonalPrincipal(matriz, n);
                
                if(i == 0 && j == 1 || i == 1 && j == 2 || i == 2 && j == 0){
                    produtoPrincipal2 *= matriz[i][j];
                }
                
                if(i == 0 && j == 2 || i == 2 && j == 1 || i == 2 && j == 1){
                    produtoPrincipal3 *= matriz[i][j];
                }
                
                
                
                
                produtoSecundario2 = Matriz.produtoDiagonalSecundaria(matriz, n);
                
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
     
     
}
