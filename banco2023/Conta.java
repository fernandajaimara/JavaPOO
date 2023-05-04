import java.util.Scanner;
public class Conta {
    protected String numero;
    protected Pessoa titular;
    protected Gerente gerente;
    protected double saldo;
    protected Data criacao;

    /*Construtor da classe Conta */

    public Conta (Gerente g){
        Scanner s = new Scanner(System.in);

        System.out.print("Digite o numero da Conta: ");
        this.numero = s.nextLine();

        System.out.println("Digite os dados do titular. ");
        this.titular = new Pessoa();

        this.saldo = 0;

        System.out.println("Digite a data de criação da conta. ");
        this.criacao = new Data();
    }

    public Conta(String numero, Pessoa titular, Gerente ger, Data criacao){
        this.numero = numero;
        this.titular = titular;
        this.gerente = ger;
        this.criacao = criacao;
        this.saldo = 0;
        System.out.println("Nova conta adicionada ao sistema.");
    }

    protected double disponivel(){
        return this.saldo;
    }

    public void extrato(){
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular.cpf);
        System.out.println("Saldo disponivel para saque: " + this.disponivel());
        System.out.println("----------------------------------------------------");
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Deposito de " + valor + " realizado na conta " + this.numero + " com sucesso.");
        System.out.println("-------------------------------------------------");
    }

    public boolean sacar(double valor){
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
    
    public boolean transferir(double valor, Conta destino) {
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