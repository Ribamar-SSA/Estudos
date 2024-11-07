package MaratonaJava.designPatterns.dominio;

public class CurrencyFactory {

    //cria uma currency e acordo com o país

    public static Currency novaCurrency(Country country){

        switch(country){
            case USA:new UsDollar();
            case BRAZIL:new Real();
            default:throw new IllegalArgumentException("no currency found for this country");

        }
    }
}
