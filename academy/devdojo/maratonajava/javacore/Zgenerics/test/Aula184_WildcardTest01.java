package academy.devdojo.maratonajava.javacore.Zgenerics.test;

    abstract class Animals {
        public abstract void consulta();
    }

    class Cachorro extends Animals {
        @Override
        public void consulta() {
            System.out.println("Adicionando cachorro");
        }
    }

    class Gato extends Animals {
        @Override
        public void consulta() {
            System.out.println("Adicionando Gato");
        }
    }
public class Aula184_WildcardTest01 {

    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};
        printConsulta(cachorros);
        printConsulta(gatos);
    }

    public static void printConsulta(Animals[] animals){
        for (Animals animal : animals) {
            animal.consulta();
        }

//        animals[1] = new Gato();

    }
}
