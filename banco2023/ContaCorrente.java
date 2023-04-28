public class ContaCorrente extends Conta{
    double limite;

    ContaCorrente(String numero, Pessoa titular, Gerente ger, Data criacao){
        super(numero, titular, ger, criacao);
        this.limite = 200.0;
        System.out.println("Nova conta adicionada ao sistema.");
    }

    double disponivel() {
        return this.saldo + this.limite;
    }

    void extrato() {
        System.out.println("EXTRATO DA CONTA-CORRENTE");
        super.extrato();
    }
    
    void chequeEspecial(double juro) {
        if(this.saldo < 0) {
            this.saldo = this.saldo + (juro*this.saldo)/100;
        }
    }    
}