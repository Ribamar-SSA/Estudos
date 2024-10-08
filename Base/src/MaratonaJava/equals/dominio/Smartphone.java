package MaratonaJava.equals.dominio;

import java.util.Objects;

public class Smartphone {
    private String serialNumber;
    private String marca;

    //if x.hashCode == y.hashCode,  não necessariamente x.equals(y) tem que ser verdade
    //if x.equals(y), x.hashCode==y.hashCode deve ser verdadeiro
    //if x.hashCode != y.hashCode, x.equals(y) deve ser false

    @Override
    public int hashCode() {
        return serialNumber == null ? 0: serialNumber.hashCode() ;
    }

    //Reflexivo
    //Simétrico
    //Transitividade
    //Consistência

    @Override
    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;

        Smartphone smartphone = (Smartphone) obj;
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    public Smartphone(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
