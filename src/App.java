import java.time.LocalDate;

import Entities.Cliente;
import Entities.Conta;
import Entities.ContaCorrente;
import Entities.ContaPoupanca;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println();

        Cliente c1 = new Cliente("José", LocalDate.of(1996, 12, 30));
        Cliente c2 = new Cliente("Pedro", LocalDate.of(1980, 11, 30));

        Conta contaCorrente = new ContaCorrente(c1);
        Conta contaPoupanca = new ContaPoupanca(c2);

        contaCorrente.depositar(100);
        System.out.println();
        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
        contaCorrente.transferir(100, contaPoupanca);
        
        System.out.println();
        System.out.println(" === Após a transferência. ===");
        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
         
    }
}
