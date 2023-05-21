import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    ArrayList<Pessoa> clientes;
    ArrayList<Gerente> gerentes;
    ArrayList<Conta> contas;

    public Sistema(){
        this.clientes = new ArrayList<>();
        this.gerentes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public int menuInicial(){
        Scanner s = new Scanner(System.in);
        String op;

        while (true) {
            System.out.println("\n Escolha uma opção.\n");
            System.out.println("1) Cadastro");
            System.out.println("2) Movimentação Fininceira");
            System.out.println("0) Sair ");

            op = s.next();

            if (op.equals("1")) return 1;
            if (op.equals("2")) return 2;
            if (op.equals("0")) return 0;

            System.out.println("Opção inválida!");
        
        }
    }

    public void menuCadastro(){
        Scanner s = new Scanner(System.in);

        System.out.println("O que deseja cadastrar?");
        System.out.println("1) Novo cliente");
        System.out.println("2) Novo gerente");
        System.out.println("3) Nova conta corrente ");
        System.out.println("4) Nova poupança");

        while(s.hasNextInt() == false){
            System.out.println("Número inválido. Tente novamente.");
            s.nextLine();
        }
        int op = s.nextInt();

        if (op == 1) this.clientes.add(new Pessoa());
        else if (op == 2) this.gerentes.add(new Gerente());
        else if (op == 3){
            Pessoa tit = this.escolherCliente();
            Gerente ger = this.escolherGerente(); 
            this.contas.add(new ContaCorrente(tit, ger));
        }
        else if (op == 4){
            Pessoa tit = this.escolherCliente();
            Gerente ger = this.escolherGerente();
            this.contas.add(new Poupanca(tit, ger));
        }
        else{
            System.out.println("Opção Invalida!");
        }

    }
    public Pessoa localizarCliente(String cpf) throws IllegalArgumentException{
        for(Pessoa tit : this.clientes){
            if(cpf.equals(tit.getCpf())) return tit;
        }

        throw new IllegalArgumentException("Cliente " + cpf + " não encontrado.");
    }

    public Gerente localizarGerente(String cpf) throws IllegalArgumentException{
        for(Gerente ger : this.gerentes){
            if(cpf.equals(ger.getCpf())) return ger;
        }

        throw new IllegalArgumentException("Gerente " + cpf + " não encontrado.");
    }

    public Conta localizarConta(String numero) throws IllegalArgumentException{
        for(Conta c : this.contas){
            if(numero.equals(c.getNumero())) return c;
        }

        throw new IllegalArgumentException("Conta " + numero + " não encontrada.");
    }

    public Pessoa escolherCliente(){
        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println("Digite o cpf do cliente: ");
        
            for(Pessoa tit : this.clientes) {
                System.out.println(tit.getCpf() + " - " + tit.getNome());
            }

            try{
                String cpf = s.next();
                return this.localizarCliente(cpf);
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Tente novamente.");
            }
        }
    }

    public Gerente escolherGerente(){
        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println("Digite o cpf do gerente: ");
        
            for(Gerente ger : this.gerentes) {
                System.out.println(ger.getCpf() + " - " + ger.getNome());
            }

            try{
                String cpf = s.next();
                return this.localizarGerente(cpf);
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Tente novamente.");
            }
        }
    }

    public void menuMovimentacoes(){
        Scanner s = new Scanner(System.in);

        Conta conta1 = this.escolherConta();
        System.out.println("O que deseja realizar? ");
        System.out.println("1) Extrato");
        System.out.println("2) Saque");
        System.out.println("3) Deposito");
        System.out.println("4) Transferencia");

        while(s.hasNextInt() == false){
            System.out.println("Número inválido. Tente novamente.");
            s.nextLine();
        }

        int op = s.nextInt();

        if (op == 1) conta1.extrato();
        else if (op == 2) conta1.sacar();
        else if (op == 3) conta1.depositar();
        else if (op == 4){
            System.out.println("Qual a conta destino? ");
            Conta conta2 = this.escolherConta();
            conta1.transferir(conta2);
        }
        else {
            System.out.println("Opção Inválida.");
        }
    }

    public Conta escolherConta(){
        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println("Digite o numero da conta: ");
        
            for(Conta c : this.contas) {
                System.out.println(c.getNumero() + " - " + c.getTitular());
            }

            try{
                String numero = s.next();
                return this.localizarConta(numero);
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Tente novamente.");
            }
        }
    }
    
       
}
