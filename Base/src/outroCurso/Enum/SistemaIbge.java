package outroCurso.Enum;

public class SistemaIbge {
    public static void main(String[] args) {
//        for(EstadoBrasileiro e : EstadoBrasileiro.values()){
//            System.out.println(e.getName() +" "+e.getSigla());
//        }

        //não precisa do new
        EstadoBrasileiro exemplo1 = EstadoBrasileiro.RIO_JANEIRO;

        System.out.println(exemplo1.getName());
        System.out.println(exemplo1.getSigla());

    }

}
