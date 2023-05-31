//import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.IOException;

public class ContaCorrente extends Conta{
    private double limite;

    public ContaCorrente(Pessoa t, Gerente g){
        super(t, g);
        this.limite = 200;
    }
    
    public ContaCorrente(String numero, Pessoa titular, double saldo, Data criacao, Gerente ger, double limite){
        super(numero, titular, criacao, ger);
        this.saldo = saldo;
        this.limite = limite;
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

    public void salvarArq(BufferedWriter b)throws IOException{
        b.write("1\n");
        super.salvarArq(b);
        b.write(this.limite + "\n");
    }
    
    /*public void chequeEspecial(double juro) {
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
            s.close();
        }
    }*/
}