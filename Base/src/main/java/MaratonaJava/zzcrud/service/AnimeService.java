package MaratonaJava.zzcrud.service;

import MaratonaJava.zzcrud.dominio.Anime;
import MaratonaJava.zzcrud.dominio.Producer;
import MaratonaJava.zzcrud.repository.AnimeRepository;

import java.util.Optional;
import java.util.Scanner;

public class AnimeService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
            default -> throw new IllegalArgumentException("entrada não aceita");
        }
    }

    private static void findByName() {

        System.out.println("type the name ");
        String nomePedido = SCANNER.nextLine();
        AnimeRepository.findByName(nomePedido).forEach(p -> System.out.printf("%d - %s", p.getId(), p.getName()));
    }

    public static void delete() {
        System.out.println("type the id of you want to delete");
        int idautor = Integer.parseInt(SCANNER.nextLine());
        System.out.println("are you sure?");
        String choice = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(choice)) {
            AnimeRepository.delete(idautor);
        }
    }

    public static void save() {
        System.out.println("type the name of Anime");
        String name = SCANNER.nextLine();

        System.out.println("type the number of episodes");
        Integer episodes = Integer.parseInt(SCANNER.nextLine());

        System.out.println("type the number of autorid");
        Integer autorId = Integer.parseInt(SCANNER.nextLine());

        System.out.println("are you sure?");
        String choice = SCANNER.nextLine();

        if ("s".equalsIgnoreCase(choice)) {
            Anime anime = Anime.builder()
                    .name(name)
                    .episodes(episodes)
                    .producer(Producer.builder().name(name).idautor(autorId).build())
                    .build();
            AnimeRepository.save(anime);
        }
    }

    public static void update() {
        System.out.println("type the id of Anime that you want update:");
        Integer idanime = Integer.parseInt(SCANNER.nextLine());

        System.out.println("type the new name of Anime that you want update or enter to keep the same:");
        String name = SCANNER.nextLine();

        System.out.println("are you sure?");
        String choice = SCANNER.nextLine();

        if ("s".equalsIgnoreCase(choice)) {
            Optional<Anime> animeToModify = AnimeRepository.findById(idanime);
            if (animeToModify.isEmpty()) {
                System.out.println("Animes not found");
                return;
            }
            Anime anime = animeToModify.get();
            name = name.isEmpty() ? anime.getName() : name;
            //esse Anime é imutável(é necessário criar um novo)
            Anime animeNovo = Anime.builder().name(name).id(anime.getId()).episodes(anime.getEpisodes()).producer(anime.getProducer()).build();
            AnimeRepository.update(animeNovo);

        }
    }


}
