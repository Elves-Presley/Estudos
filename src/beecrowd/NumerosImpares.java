package beecrowd;

import java.util.Scanner;

public class NumerosImpares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int final_number = sc.nextInt();

        for (int i = 1; i <= final_number; i++) {

            if (i%2 != 0 || i == 1) {
                System.out.println(i);
            }
        } 
        
        sc.close();
    }
}
