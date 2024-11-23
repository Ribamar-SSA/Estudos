package MaratonaJava.zzcrud.service;

import MaratonaJava.zzcrud.dominio.Producer;
import MaratonaJava.zzcrud.repository.ProduceRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProducerService {
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
        ProduceRepository.findByName(nomePedido).forEach(p -> System.out.printf("%d - %s", p.getIdautor(), p.getName()));
    }

    public static void delete() {
        System.out.println("type the id of you want to delete");
        int idautor = Integer.parseInt(SCANNER.nextLine());
        System.out.println("are you sure?");
        String choice = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(choice)) {
            ProduceRepository.delete(idautor);
        }
    }

    public static void save() {
        System.out.println("type the name of producer");
        String name = SCANNER.nextLine();
        System.out.println("are you sure?");
        String choice = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(choice)) {
            Producer producer = Producer.builder().name(name).build();
            ProduceRepository.save(producer);
        }
    }

    public static void update() {
        System.out.println("type the id of producer that you want update:");
        Integer idautor = Integer.parseInt(SCANNER.nextLine());
        System.out.println("type the new name of producer that you want update or enter to keep the same:");
        String name = SCANNER.nextLine();
        System.out.println("are you sure?");
        String choice = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(choice)) {
            Optional<Producer> producerToModify = ProduceRepository.findById(idautor);
            if (producerToModify.isEmpty()) {
                System.out.println("producers not found");
                return;
            }
            Producer producer = producerToModify.get();
            name = name.isEmpty() ? producer.getName() : name;
            //esse producer é imutável(é necessário criar um novo)
            Producer producerNovo = Producer
                    .builder()
                    .name(name)
                    .idautor(producerToModify.get().getIdautor()).build();
            ProduceRepository.update(producerNovo);

        }
    }


}
