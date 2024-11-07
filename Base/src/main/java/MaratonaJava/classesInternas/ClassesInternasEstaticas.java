package MaratonaJava.classesInternas;

//classe top-level

public class ClassesInternasEstaticas {
    private String name = "ribamar";

    //como se fosse outra classe top-level
    // a classe nested só vai se comunicar com essa


    //um exemplo é a interface Entry que está dentro da interface Map
    //os methods da interface Entry estão relacionados com a classe Map

    static class Nested{
        private String sobrenome = "sousa";
        void print(){

            //não consigo acessar o nome dessa maneira
            //System.out.println(name);

            System.out.println(new ClassesInternasEstaticas().name+ " " + sobrenome);
        }
    }




    public static void main(String[] args) {
        Nested nested = new Nested();

        nested.print();

    }
}
