package academy.devdojo.maratonajava.javacore.Eblocosinicializacao.domain;

public class Anime {
    private String nome;
    private int[] episodios ;
    {
        // Bloco de inicializacao (executado antes do construtor)
        // 1 - Alocado em espaco de memória pro objeto
        // 2 - Cada atributo de classe é criado e inicializado com valores default ou o que for passada
        // 3 - O bloco de inicialização é executado
        // 4 - Construtor é executado

        System.out.println("Dentro do bloco de inicializacao");
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++){
            episodios[i] = i + 1;
        }
    }
    public Anime(String nome) {

    }
    public Anime( ) {
//        episodios = new int[100];
//        for (int i = 0; i < episodios.length; i++){
//            episodios[i] = i + 1;
//        }
        for(int episodios : this.episodios){
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
