

public class Banco{
    
    public static void main(String[] args) {
       
        /* 
        Pessoa p1 = new Pessoa("Maria", 18, 'F', "123.456.789-00");
        Pessoa p2 = new Pessoa("João", 22, 'M', "234.567.890-00");

        Conta c1 = new Conta("12345-6", p1);
        Conta c2 = new Conta("23456-7", p2);

        c1.extrato();
        c2.extrato();

        c1.sacar(150);
        c1.transferir(100, c2);
        c1.sacar(100);
        c1.depositar(100);
        c1.transferir(200, c2);

        for(int i = 1; i <= 120; i += 1){
            c1.chequeEspecial(0.5);

            if(i%30 == 0) {
                System.out.println("Saldo apos " +i+ " dias: " + c1.saldo);
            }*/
            Gerente g = new Gerente();
            ContaCorrente c1 = new ContaCorrente(g);
            Poupanca p1 = new Poupanca(g);

            c1.extrato();
            p1.extrato();

            c1.sacar(200);
            p1.depositar(50);

            p1.transferir(30, c1);

            c1.extrato();
            p1.extrato();       
        }
}
