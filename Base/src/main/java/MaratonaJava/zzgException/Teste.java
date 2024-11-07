package MaratonaJava.zzgException;

public class Teste {

    public static void main(String[] args){

        try {
            int a = 0;
            int b = 0;
            int res = a/b;
            System.out.println(res);
        }
        catch (Exception e) {
            System.out.println("Erro.");
        }
        finally {
            System.out.println("Finally");
        }

    }

}