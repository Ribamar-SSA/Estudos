package Enum;
//enum é um conjunto de objetos
public enum EstadoBrasileiro {
    //constantes enum
    SAO_PAULO("SP","SAO PAULO", 19),
    RIO_JANEIRO("rj","rio de janeiro", 12);


    private String name;
    private String sigla;
    private int codIbge;



    EstadoBrasileiro(String name, String sigla,int codIbge) {
        this.name = name;
        this.sigla = sigla;
        this.codIbge = codIbge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
