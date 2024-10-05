package MaratonaJava.classesInternas;

public class OuterClass {

    String name = "monkey";

    class InnerClass {
        int numero = 5;
    }

    public static void main(String[] args) {



    OuterClass clasefora1 = new OuterClass();
    //InnerClass innerClass = new InnerClass(); não é estático


    InnerClass inner = clasefora1.new InnerClass();


    }
}

