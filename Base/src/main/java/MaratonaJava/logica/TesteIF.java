package MaratonaJava.logica;

public class TesteIF {

    public static void main(String[] args) {
        int x=-1;
        int y =0;

        while( y<10){
            if(x <= 0){
                System.out.println("x é menor que zero");
                continue;
            }
            System.out.println("passou pelo if ");

        }


    }


}
