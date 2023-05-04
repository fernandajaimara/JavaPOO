import java.util.Scanner;
public class ContaCorrente extends Conta{
    private double limite;

    public ContaCorrente(Gerente g){
        super(g);
        this.limite = 200;
    }
    
    public ContaCorrente(String numero, Pessoa titular, Gerente ger, Data criacao){
        super(numero, titular, ger, criacao);
        this.limite = 200.0;
        System.out.println("Nova conta adicionada ao sistema.");
    }

    public double getLimite(){
        return limite;
    }

    public void setLimite(String senha, double l){
        if (this.gerente.validarAcesso(senha)){
            this.limite = l;
        }
    }

    protected double disponivel() {
        return this.saldo + this.limite;
    }

    public void extrato() {
        System.out.println("EXTRATO DA CONTA-CORRENTE");
        super.extrato();
    }
    
    public void chequeEspecial(double juro) {
        if(this.saldo < 0) {
            this.saldo = this.saldo + (juro*this.saldo)/100;
        }
    }   
    public void alterarLimite(String senha, double limite){
        if(gerente.validarAcesso(senha)){
            this.limite = limite;
        }
    }

    void alterarLimite() {
        if (gerente.validarAcesso()){
            Scanner s = new Scanner(System.in); 
            System.out.println("Digite o novo limite: ");
            this.limite = s.nextDouble();
        }
        
    }
}