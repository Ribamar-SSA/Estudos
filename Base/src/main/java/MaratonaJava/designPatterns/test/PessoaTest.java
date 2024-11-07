package MaratonaJava.designPatterns.test;

import MaratonaJava.designPatterns.dominio.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        //Pessoa pessoa = new Pessoa("nome", "sousa", "garfield", "ribamar.cssa");
        Pessoa build = new Pessoa.PessoaBuilder()
                .firstName("ribamar")
                .username("garfieldd")
                .lastName("sousa")
                .email("ribamar.cssa@gmail.com")
                .build();


        System.out.println(build);

    }
}
