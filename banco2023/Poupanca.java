public class Poupanca extends Conta{

    Poupanca(String numero, Pessoa titular, Gerente ger, Data criacao){
        super(numero, titular, ger, criacao);
        System.out.println("Nova conta adicionada ao sistema.");
    }


    double disponivel() {
        return this.saldo;
    }

    void extrato(){
        System.out.println("*** EXTRATO DA CONTA ***");
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular.cpf);
        System.out.println("Saldo disponivel para saque: " + this.disponivel());
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

    void rendimentos(double taxa) {
        double juros = saldo * (taxa / 100);
        saldo += juros;
    }
}