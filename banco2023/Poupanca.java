import java.io.BufferedWriter;
import java.io.IOException;

public class Poupanca extends Conta{ 
       
    public Poupanca(Pessoa t, Gerente g){
        super(t, g);
    }

    public Poupanca(String numero, Pessoa titular, double saldo, Data criacao, Gerente ger){
        super(numero, titular, criacao, ger);
        this.saldo = saldo;
        System.out.println("Nova conta adicionada ao sistema.");
    }
    
    public void extrato(){
        System.out.println("EXTRATO DA POUPANÇA");
        super.extrato();
    }

    public void rendimentos(double taxa) {
        this.saldo = this.saldo + (taxa*this.saldo)/100;
    }

    public void salvarArq(BufferedWriter b)throws IOException{
        b.write("2\n");
        super.salvarArq(b);
    }
}