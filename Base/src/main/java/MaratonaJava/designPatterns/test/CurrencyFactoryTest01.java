package MaratonaJava.designPatterns.test;

import MaratonaJava.designPatterns.dominio.Country;
import MaratonaJava.designPatterns.dominio.Currency;
import MaratonaJava.designPatterns.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {

        Currency currency =  CurrencyFactory.novaCurrency(Country.BRAZIL);
        currency.getSymbol();
    }

}
