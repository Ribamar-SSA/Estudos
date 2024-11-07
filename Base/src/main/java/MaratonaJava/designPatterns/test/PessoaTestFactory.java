package MaratonaJava.designPatterns.test;

import MaratonaJava.designPatterns.dominio.PessoaFactory;

public class PessoaTestFactory {
    public static void main(String[] args) {

        PessoaFactory build =  PessoaFactory.PessoaFactoryBuilder
                .builder()
                .firstName("ribamar")
                .username("garfieldd")
                .lastName("sousa")
                .email("ribamar.cssa@gmail.com")
                .build();


        System.out.println(build);

    }
}
