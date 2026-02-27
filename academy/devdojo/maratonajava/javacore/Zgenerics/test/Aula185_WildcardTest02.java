package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aula185_WildcardTest02 {

//    public static void main(String[] args) {
//        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
//        List<Gato> gatos = List.of(new Gato(), new Gato());
//        printConsulta(cachorros);
//        printConsulta(gatos);
//    }
//    // Type erasure, o tipo do generic é apagado apos a compilacao
//    // Quando estamos trabalhando com listas, o tipo dessa lista deve ser exatamente o definido na sintaxe
//    public static void printConsulta(List<Animals> animals) {
//        for (Animals animal : animals) {
//            animal.consulta();
//        }
//        animals.add(new Cachorro());
//    }

    public static void main(String[] args) {
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());
        printConsulta(cachorros);
        printConsulta(gatos);
        List<Animals> animals = new ArrayList<>();

        printConsultaAnimal(animals);
    }
    // Wildcard sintaxze : <? extens AlgumaClasse>
    // O "extends" sempre deve aparecer, independente de a classe ser uma classe abstrata ou uma interface, a não ser que seja usado o super. Ela serve para implementar todas as classes após a classe definida (nesse caso Animals, Cachorro e Gato) porém apenas para leitura e não para instanciacao
    public static void printConsulta(List<? extends Animals> animals) {
        for (Animals animal : animals) {
            animal.consulta();
        }
    }

    // O "super" serve para quando queremos adicionar um novo objeto por exemplo no metodo, nesse caso a lista implementará para todas as classes mais abstratas (nesse caso: Animals e Objects)
    public static void printConsultaAnimal(List<? super Animals> animals) {
        Animals animal1 = new Cachorro();
        Animals animal2 = new Gato();
        animals.add(new Gato());
        animals.add(new Cachorro());
        // Com o super , consehuimos manipular tranquilamente os objetos que extendem a classe definida no metodo, mesmo que eles sejam classes filhas
    }
}
