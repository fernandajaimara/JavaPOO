public class Poupanca extends Conta{

    Poupanca(String numero, Pessoa titular, Gerente ger, Data criacao){
        super(numero, titular, ger, criacao);
        System.out.println("Nova conta adicionada ao sistema.");
    }
    
    void extrato(){
        System.out.println("EXTRATO DA POUPANÇA");
        super.extrato();
    }

    void rendimentos(double taxa) {
        this.saldo = this.saldo + (taxa*this.saldo)/100;
    }
}