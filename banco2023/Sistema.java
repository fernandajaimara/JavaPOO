import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

        this.lerClientesArq();
        this.lerGerentesArq();
        this.lerContasArq();
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

        if (op == 1) {
            this.clientes.add(new Pessoa());
            this.salvarClientesArq();
        }
        else if (op == 2) {
            this.gerentes.add(new Gerente());
            this.salvarGerentesArq();
        }
        else if (op == 3){
            Pessoa tit = this.escolherCliente();
            Gerente ger = this.escolherGerente(); 
            this.contas.add(new ContaCorrente(tit, ger));
            this.salvarContasArq();
        }
        else if (op == 4){
            Pessoa tit = this.escolherCliente();
            Gerente ger = this.escolherGerente();
            this.contas.add(new Poupanca(tit, ger));
            this.salvarContasArq();

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
        else if (op == 2) {
            conta1.sacar();
            this.salvarContasArq();
        }
        else if (op == 3) {
            conta1.depositar();
            this.salvarContasArq();
        }
        else if (op == 4){
            System.out.println("Qual a conta destino? ");
            Conta conta2 = this.escolherConta();
            conta1.transferir(conta2);
            this.salvarContasArq();
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
    
    public void salvarClientesArq(){
        try {
            FileWriter r = new FileWriter("Clientes.txt");
            BufferedWriter b = new BufferedWriter(r);

            b.write(this.clientes.size() + "\n");

            for (Pessoa tit : this.clientes){
                tit.salvarArq(b);
            }

            b.close();
        }
        catch (IOException e){
            System.out.println("Erro ao salvar o arquivo de clientes.");
        }
    }

    public void lerClientesArq(){
        try {
            FileReader f = new FileReader("Clientes.txt");
            BufferedReader b = new BufferedReader(f);

            int t = Integer.parseInt(b.readLine());

            for(int i = 0; i<t; i++){
                this.clientes.add(new Pessoa(b));
            }
            b.close();
            System.out.println(this.clientes.size() + " cliente(s) carregados.");
        }
        catch (IOException e){
            System.out.println("Erro ao ler o arquivo de clientes.");
            this.clientes = new ArrayList<>();
            System.out.println("Nenhum cliente carregado.");
        }
    }
    public void salvarGerentesArq(){
        try {
            FileWriter r = new FileWriter("Gerentes.txt");
            BufferedWriter b = new BufferedWriter(r);

            b.write(this.gerentes.size() + "\n");

            for (Gerente ger : this.gerentes){
                ger.salvarArq(b);
            }

            b.close();
        }
        catch (IOException e){
            System.out.println("Erro ao salvar o arquivo de gerentes.");
        }
    }

    public void lerGerentesArq(){
        try {
            FileReader f = new FileReader("Gerentes.txt");
            BufferedReader b = new BufferedReader(f);

            int t = Integer.parseInt(b.readLine());

            for(int i = 0; i<t; i++){
                this.gerentes.add(new Gerente(b));
            }
            b.close();
            System.out.println(this.gerentes.size() + " gerente(s) carregados.");
        }
        catch (IOException e){
            System.out.println("Erro ao ler o arquivo de gerentes.");
            this.gerentes = new ArrayList<>();
            System.out.println("Nenhum gerente carregado.");
        }
    }
    public void salvarContasArq(){
        try {
            FileWriter r = new FileWriter("Contas.txt");
            BufferedWriter b = new BufferedWriter(r);

            b.write(this.contas.size() + "\n");

            for (Conta c : this.contas){
                c.salvarArq(b);
            }

            b.close();
        }
        catch (IOException e){
            System.out.println("Erro ao salvar o arquivo de contas.");
        }
    }

    public void lerContaArq(){
        try {
            FileReader f = new FileReader("Contas.txt");
            BufferedReader b = new BufferedReader(f);

            int t = Integer.parseInt(b.readLine());

            for(int i = 0; i<t; i++){
                this.contas.add(new Conta(b));
            }
            b.close();
            System.out.println(this.contas.size() + " conta(s) carregados.");
        }
        catch (IOException e){
            System.out.println("Erro ao ler o arquivo de contas.");
            this.gerentes = new ArrayList<>();
            System.out.println("Nenhuma conta carregado.");
        }
    }

    public void lerContasArq(){
        try {
            FileReader f = new FileReader("Contas.txt");
            BufferedReader b = new BufferedReader(f);

            int t = Integer.parseInt(b.readLine());

            for(int i = 0; i<t; i++){
                int tipo = Integer.parseInt(b.readLine());
                String numero = b.readLine();
                String cpfT = b.readLine();
                Pessoa tit = this.localizarCliente(cpfT);
                double saldo = Double.parseDouble(b.readLine());
                Data d = new Data(b);
                String cpfG = b.readLine();
                Gerente g = this.localizarGerente(cpfG);

                if (tipo==1){
                    double limite = Double.parseDouble(b.readLine());
                    this.contas.add(new ContaCorrente(numero, tit, saldo, d, g, limite));
                }
                else {
                    this.contas.add(new Poupanca(numero, tit, saldo, d, g));
                }
        
            }
            b.close();
            System.out.println(this.contas.size() + " conta(s) carregadas.");
        }
        catch (IOException e){
            System.out.println("Erro ao ler o arquivo de contas.");
            this.gerentes = new ArrayList<>();
            System.out.println("Nenhuma conta carregado.");
        }
    }
}
