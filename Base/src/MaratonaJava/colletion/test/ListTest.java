package MaratonaJava.colletion.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>(16);

        nomes.add("ribamar");


        for (String nome : nomes){
            System.out.println(nome);
            //ao tentar adicionar, é lançada uma exceção
            nomes.add("sousa");
        }
    }







}
