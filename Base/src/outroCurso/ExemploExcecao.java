package outroCurso;

import java.text.NumberFormat;
import java.text.ParseException;

public class ExemploExcecao {
    public static void main(String[] args) {
        Number valor = Double.valueOf(("a1.75"));
        //essa seria uma unchecked exception
        /*
        valueOf
        numberFormatException, extends
        IllegalArgumentException,extends
        RuntimeException,extends
        Exception,extends
        Throwable

         */

        try {
            valor = NumberFormat.getInstance().parse("a1.75");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //é uma checked exception, porque ele te obriga a resolver
        /*
        parse
        ParseException extends Exception
        Exception extends Throwable
         */
        System.out.println(valor);
    }
}
