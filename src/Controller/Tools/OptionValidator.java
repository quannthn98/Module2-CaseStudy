package Controller.Tools;

import java.util.Scanner;

public class OptionValidator {
    public static Scanner scanner = new Scanner(System.in);

    public static int getOption(int min,int max){
        int option = scanner.nextInt();
        while (option < min || option > max){
            System.out.println("Please pick valid option from " + min + " - " + max);
            option = scanner.nextInt();
        }
        return option;
    }
}
