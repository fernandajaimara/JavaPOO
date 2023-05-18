public class Poupanca extends Conta{ 
       
    public Poupanca(Pessoa t, Gerente g){
        super(t, g);
    }

    /*public Poupanca(String numero, Pessoa titular, Gerente ger, Data criacao){
        super(numero, titular, ger, criacao);
        System.out.println("Nova conta adicionada ao sistema.");
    }*/
    
    public void extrato(){
        System.out.println("EXTRATO DA POUPANÇA");
        super.extrato();
    }

    public void rendimentos(double taxa) {
        this.saldo = this.saldo + (taxa*this.saldo)/100;
    }
}