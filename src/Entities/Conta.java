package Entities;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public abstract class Conta implements IConta{

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL= 1;

    private int agencia;
    private int numeroDaConta;
    private double saldo;

    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numeroDaConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public static int getAgenciaPadrao() {
        return AGENCIA_PADRAO;
    }

    public static int getSEQUENCIAL() {
        return SEQUENCIAL;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void imprimirInfo(){
        System.out.println("Cliente: ");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Data de Nascimento: " + dtf.format(cliente.getDataDeNascimento()));
        System.out.println("Informações da Conta: ");
        System.out.println("Agência: " + getAgencia());
        System.out.println("Número da conta: " + getNumeroDaConta());
        System.out.println("Saldo: " + getSaldo());
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.saldo){
            this.saldo -= valor;
        }
        else{
            throw new IllegalArgumentException("Saldo Insuficiente");
        }
        
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);
        
    }

}
