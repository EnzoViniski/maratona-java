package DesafiosRecruta.ecomerce.domain;

public enum Categoria {
    ELETRONICO (0.2){
        public double calcularImposto(double valorProduto){
            return valorProduto * 0.2;
        }
    }, VESTUARIO (0.05) {
        public double calcularImposto(double valorProduto){
            return valorProduto * 0.05;
        }
    }, LIVRO (0.0) {
        public double calcularImposto(double valorProduto){
            return valorProduto * 0.0;
        }
    };
    private double imposto;

    Categoria(double imposto) {
        this.imposto = imposto;
    }

    public abstract double calcularImposto(double valorProduto);
}
