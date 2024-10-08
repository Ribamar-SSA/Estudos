package outroCurso;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;


public class TryCatch {
    public static  void main(String[] args) {
    try {

        Scanner input = new Scanner(System.in).useLocale(Locale.US);


        System.out.println("Name:");
        String name = input.next();

        System.out.println("Last name:");
        String lastName = input.next();

        System.out.println("height:");
        double height = input.nextDouble();

    }catch (InputMismatchException e){

        System.out.println("erro");

    }



    }
}
