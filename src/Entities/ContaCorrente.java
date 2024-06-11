package Entities;

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente){
        super(cliente);
    }

    public void imprimirExtrato(){
        System.out.println("=== Extrato da Conta Corrente ===");
        imprimirInfo();
    }

}
