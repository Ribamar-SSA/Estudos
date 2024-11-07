package MaratonaJava.optional.repository;

import MaratonaJava.optional.dominio.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {

    public static List<Manga> listManga = List.of(new Manga(1,"overlord",50),
            new Manga(2,"nanatsu",27),
            new Manga(7,"garfield",31),
            new Manga(8,"lima barreto",25),
            new Manga(3,"naruto",42));

    public static Optional<Manga> pesquisarId(int id){
        Optional<Manga> mangaOptional = searchBy(x ->x.getId().equals(id));
        //mangaOptional.ifPresent(x -> System.out.println(x));
        return mangaOptional;
    }

    public static Optional<Manga> pesquisarTitle(String title){
        Optional<Manga> mangaOptional = searchBy(x ->x.getTitle().equals(title));
        mangaOptional.ifPresent(x -> System.out.println(x));
        return mangaOptional;
    }

    private static Optional<Manga> searchBy(Predicate<Manga> mangaPredicate){
        Manga mangaRetornado = null;
        for(Manga m : listManga){
            if(mangaPredicate.test(m)){
                mangaRetornado = m;
            }
        }
        return Optional.ofNullable(mangaRetornado);
    }



}
