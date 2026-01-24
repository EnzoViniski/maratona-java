package academy.devdojo.maratonajava.javacore.Dconstrutores.domain;

public class Anime2 {
    private String tipo;
    private int episodios;
    private String nome;
    private String genero;
    private String estudio;

    public Anime2(String nome, String tipo, int episodios, String genero) {
        this();
        // this(); só pode ser chamado dentro de um construtor e deve ser a primeira linha executável
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
        this.genero = genero;
    }

    public Anime2(String nome, String tipo, int episodios, String genero, String estudio) {
        this(nome, tipo, episodios, genero);
        this.estudio = estudio;
    }

    public Anime2(){
        System.out.println("Dentro do construtor sem argumentos");
    }

//    public void init(String nome, String tipo, int episodios) {
//        this.nome = nome;
//        this.tipo = tipo;
//        this.episodios = episodios;
//    }
//
//    public void init(String nome, String tipo, int episodios, String genero) {
//        this.init(nome, tipo, episodios);
//        this.genero = genero;
//    }

    public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.episodios);
        System.out.println(this.tipo);
        System.out.println(this.genero);
        System.out.println(this.estudio);
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return this.genero;
    }
}
