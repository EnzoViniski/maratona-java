package academy.devdojo.maratonajava.javacore.Ycolecoes.domain;

public class Smartphone {
    private String cerealNumber;
    private String marca;

    public Smartphone(String cerealNumber, String marca) {
        this.cerealNumber = cerealNumber;
        this.marca = marca;
    }

    public String getCerealNumber() {
        return cerealNumber;
    }

    public void setCerealNumber(String cerealNumber) {
        this.cerealNumber = cerealNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
