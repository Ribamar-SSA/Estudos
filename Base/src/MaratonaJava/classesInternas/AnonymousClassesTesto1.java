package MaratonaJava.classesInternas;


import org.w3c.dom.ls.LSOutput;

class Animal{
    public void walk(){
        System.out.println("animal walking");
    }
}

//trocar o comportamento, que poderia ser evitado usando classe anônima
class cachorro extends Animal{
    @Override
    public void walk() {
        super.walk();
    }
}
public class AnonymousClassesTesto1 {
    //classes que existirão brevimente e que não podem ser reutilizadas em nenhum outro lugar


    public static void main(String[] args) {

        //criando uma subclasse de animal
        Animal animal = new Animal(){
            @Override
            public void walk() {
                System.out.println("walking anonimous ");;
            }
        };

        animal.walk();
    }
}
