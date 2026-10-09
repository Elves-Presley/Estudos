package atividades;
import java.util.Scanner;

public class Calculadora{

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_GREEN = "\u001B[32m";//Código de cores Anssi para estilização

    public static void main(String[] args) {
        //Objects and variavables
        Scanner sc = new Scanner(System.in);
        double operating1, operating2, result;
        int menuOption;
        Operacao operacao = Operacao.SUM;//Apenas um padrão inicial

        //visual Presentation
        System.out.println("\n\nCALCULADORA\n");
        System.out.println("Esse programa simula uma calculadora com as suas principais operações (SOMA, SUBTRAÇÃO, MULTIPLICAÇÃO, DIVISÃO)\n");
        System.out.println("Por favor, digite 2 números para a realização dos cálculos.\n");

        System.out.printf("Operando 1: ");
        operating1 = validateInputOperands(sc);

        System.out.printf("Operando 2: ");
        operating2 = validateInputOperands(sc);

        while (operacao != Operacao.SAIR) {

            System.out.println("\nMENU\n");
            System.out.println("[1] - Soma.");
            System.out.println("[2] - Subtração.");
            System.out.println("[3] - Multiplicação.");
            System.out.println("[4] - Divisão.");
            System.out.println("[5} - Atualizar Operandos.");
            System.out.println("[6] - Sair\n");
            System.out.printf("Que operação deseja realizar? ");

            menuOption = validateInputMenu(sc);
            operacao = chosenOperation(menuOption);

            if(operacao == Operacao.ATUALIZAR){
                System.out.println("\nDigite respectivamente a atualização do operando 1 e 2: ");
                operating1 = setOperands(operating1, sc);
                operating2 = setOperands(operating2, sc);
                System.out.println("Operandos atualizados!\n");
                continue;
            }
            
            result = startCalculator(operacao, operating1, operating2, sc);

            showResult(operacao, result, operating1, operating2);

            System.out.println();//Apenas para pular uma linha

        }


    }

    public static double validateInputOperands(Scanner scanner){
        while (!scanner.hasNextDouble()) {
            System.out.println("\n-> Erro de entrada.\n");
            scanner.next();

            System.out.println("Por favor, digite um valor válido: ");
        }
        return scanner.nextDouble();
    }

    public static int validateInputMenu(Scanner scanner){
        int digitedOption = 0;
        boolean condition = true;
        int menuOptionInterval1 = 1, menuOptionInterval2 = 6;

        while (condition){

            while(!scanner.hasNextInt()){

                System.out.println("\n-> Opção de MENU inválida.\n");
                scanner.next();

                System.out.println("Por favor, digite uma opção válida: ");
            }

            digitedOption = scanner.nextInt();



            condition = !(digitedOption >= menuOptionInterval1 && digitedOption <= menuOptionInterval2);
            
            if(condition){
                continue;
            }
        }
        return digitedOption;
    }

    public static double sum(double n1, double n2){
        double sum = n1 + n2;
        return sum;
    }

    public static double subtraction(double n1, double n2){
        double subtraction = n1 - n2;
        return subtraction;
    }

    public static double multiplication(double n1, double n2){
        double multiplication = n1 * n2;
        return multiplication;
    }

    public static double division(double n1, double n2){
        double division = n1 / n2;
        return division;
    }

    public static double setOperands(double operating, Scanner scanner){
        // scanner.next();//Garantir que está vazio
        operating = validateInputOperands(scanner);
        return operating;
    }

    public enum Operacao{
        SUM,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        ATUALIZAR,
        SAIR,
        INVALIDA
    }

    public static Operacao chosenOperation(int menuOption){

        return switch (menuOption) {

            case 1  -> Operacao.SUM;
            case 2  -> Operacao.SUBTRACTION;
            case 3  -> Operacao.MULTIPLICATION;
            case 4  -> Operacao.DIVISION;
            case 5  -> Operacao.ATUALIZAR;
            case 6  -> Operacao.SAIR;
            default -> Operacao.INVALIDA;
        };
    }

    public static double startCalculator(Operacao operation, double operating1, double operating2, Scanner scanner){
        
        return switch (operation) {

            case SUM -> sum(operating1, operating2);
            case SUBTRACTION -> subtraction(operating1, operating2);
            case MULTIPLICATION -> multiplication(operating1, operating2);
            case DIVISION -> division(operating1, operating2);
            case ATUALIZAR -> 0; //setOperands(operating1, operating2, scanner);
            case SAIR, INVALIDA -> 0;
        };

    }

    public static void showResult(Operacao operation, double result, double operating1, double operating2){
        switch (operation) {

            case SUM            -> System.out.printf(ANSI_GREEN + "%.2f + %.2f = %.2f" + ANSI_RESET, operating1, operating2, result);
            case SUBTRACTION    -> System.out.printf(ANSI_GREEN + "%.2f - %.2f = %.2f" + ANSI_RESET, operating1, operating2, result);
            case MULTIPLICATION -> System.out.printf(ANSI_GREEN + "%.2f * %.2f = %.2f" + ANSI_RESET, operating1, operating2, result);
            case DIVISION       -> System.out.printf(ANSI_GREEN + "%.2f / %.2f = %.2f" + ANSI_RESET, operating1, operating2, result);
            case ATUALIZAR      -> System.out.println("");
            case SAIR           -> System.out.printf("OBRIGADO POR TESTAR O MEU PROGRAMA!");
            case INVALIDA       -> System.out.printf("Erro...");
        };
    }
}