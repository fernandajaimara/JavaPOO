import java.util.Scanner;
public class Conta {
    String numero;
    Pessoa titular;
    Gerente ger;
    double saldo;
    Data criacao;

    /*Construtor da classe Conta */

    Conta (Gerente g){
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o numero: ");
        this.numero = s.nextLine();

        System.out.println("Digite os dados do titular. ");
        this.titular = new Pessoa();

        this.saldo = 0;

        System.out.println("Digite a data de criação da conta. ");
        this.criacao = new Data();
    }

    Conta(String numero, Pessoa titular, Gerente ger, Data criacao){
        this.numero = numero;
        this.titular = titular;
        this.ger = ger;
        this.criacao = criacao;
        this.saldo = 0;
        System.out.println("Nova conta adicionada ao sistema.");
    }

    double disponivel(){
        return this.saldo;
    }

    void extrato(){
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular.cpf);
        System.out.println("Saldo disponivel para saque: " + this.disponivel());
    }

    void depositar(double valor){
        this.saldo += valor;
    }

    boolean sacar(double valor){
        if (valor <= this.disponivel()){
            this.saldo -= valor;
            System.out.println("Saque na conta " + this.numero + " realizado com sucesso. Novo saldo: " + this.saldo);
            return true;
        }
        else {
            System.out.println("ERRO: Saque na conta " + this.numero + " nao realizado. Valor disponivel: " + this.disponivel());
            return false;
        }
    }
    
    boolean transferir(double valor, Conta destino) {
        if(this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transaferencia de "+ valor + " da conta "+ this.numero + " para a conta " + destino.numero + " foi realizado com sucesso.");
            return true;
        }
        else{
            System.out.println("ERRO: Não foi possível transferir " + valor + " da conta " + this.numero + " para a conta " + destino.numero + ". Valor disponivel: "+ this.disponivel());
            return false;
        }
    }
}