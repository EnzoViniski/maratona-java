package academy.devdojo.maratonajava.javacore.Kenum.test;

import academy.devdojo.maratonajava.javacore.Kenum.domain.Cliente;
import academy.devdojo.maratonajava.javacore.Kenum.domain.TipoCliente;
import academy.devdojo.maratonajava.javacore.Kenum.domain.TipoPagamento;

public class ClienteTest01 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Enzo", TipoCliente.PESSOA_FISICA, TipoPagamento.DEBITO);
//        Cliente cliente2 = new Cliente("Enzo", TipoCliente.PESSOA_FISICA);
//        Cliente cliente3 = new Cliente("Enzo", TipoCliente.PESSOA_JURIDICA);
//        Cliente cliente4 = new Cliente("Enzo", TipoCliente.PESSOA_JURIDICA);

        System.out.println(cliente1);
        System.out.println(TipoPagamento.CREDITO.calcularDesconto(100));
        TipoCliente tipoCliente = TipoCliente.valueOf("PESSOA_FISICA");
        TipoCliente tipoCliente2 = TipoCliente.tipoClientePorNomeRelatorio("Pessa Física");
        System.out.println(tipoCliente2);
    }
}
