package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.domain;

public class Anime4 {
    private String nome;
    private static int[] episodios ;
        // Bloco de inicializacao (executado antes do construtor)
        // 0 - Bloco de inicialização é executado quando a JVM carregar a classe
        // 1 - Alocado em espaco de memória pro objeto
        // 2 - Cada atributo de classe é criado e inicializado com valores default ou o que for passada
        // 3 - O bloco de inicialização é executado
        // 4 - Construtor é executado

    static {
        System.out.println("Dentro do bloco de inicializacao estático");
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++){
            episodios[i] = i + 1;
        }
    }
    static {
        System.out.println("Dentro do bloco de inicializacao estático 2");

    }
    static {
        System.out.println("Dentro do bloco de inicializacao estático 3");

    }
    {
        System.out.println("Dentro do bloco de inicializacao não estático");
    }
    public Anime4(String nome) {

    }
    public Anime4( ) {
//        episodios = new int[100];
//        for (int i = 0; i < episodios.length; i++){
//            episodios[i] = i + 1;
//        }
        for(int episodios : Anime4.episodios){
            System.out.print(episodios + " ");
        }
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public int[] getEpisodios() {
        return episodios;
    }
}
