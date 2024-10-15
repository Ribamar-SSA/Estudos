package MaratonaJava.optional.test;

import MaratonaJava.optional.dominio.Manga;
import MaratonaJava.optional.repository.MangaRepository;

import java.util.function.Consumer;

public class OptionalTest03 {
    public static void main(String[] args) {
        //usar programação funcional deixa a leitura do código muito melhor

        //procurar por titulo e caso  exista,modificar

        //usei uma classe anônima para variar
        MangaRepository.pesquisarTitle("overlord")
                .ifPresent(new Consumer<Manga>() {
                    @Override
                    public void accept(Manga manga) {
                        manga.setTitle("high 2");
                    }
                });
        //testando se realamente trocou o valor
        MangaRepository.pesquisarTitle("high 2");
        MangaRepository.pesquisarTitle("overlord");


        //procurar por id e caso não exista, lançar uma exceção
        MangaRepository.pesquisarId(2).orElseThrow(() -> new IllegalArgumentException());



        //buscar pelo titulo e caso não exista um com o título, eu quero criar um com esse titulo
        Manga newManga = MangaRepository.pesquisarTitle("sousaAnime")
                .orElseGet(() -> new Manga(52,"sousaAnime",29));

        System.out.println("new manga");
        System.out.println(newManga);



    }
}
