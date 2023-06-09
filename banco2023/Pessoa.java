import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pessoa {
    protected String nome;
    protected Data dataNascimento;
    protected char sexo;
    protected String cpf;

    public Pessoa(BufferedReader b){
        try{
            this.nome = b.readLine();
            this.cpf = b.readLine();
            this.dataNascimento = new Data(b);
            this.sexo = b.readLine().charAt(0);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Pessoa(){
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        this.nome = s.nextLine();

        System.out.print("Digite o CPF: ");
        this.cpf = s.nextLine();

        System.out.println("Data de nascimento: ");
        this.dataNascimento = new Data();

        System.out.print("Digite o sexo: ");
        this.sexo = s.nextLine().charAt(0);
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public char getSexo(){
        return sexo;
    }

    public void setSexo(char sexo){
        this.sexo = sexo;
    }

    public void salvarArq(BufferedWriter b)throws IOException{
        b.write(this.nome + "\n");
        b.write(this.cpf + "\n");
        this.dataNascimento.salvarArq(b);
        b.write(this.sexo + "\n");
    }

    /*public Pessoa(String nome, Data i, char sexo, String cpf) {        
        this.nome = nome;
        this.dataNascimento = i;
        this.sexo = sexo;
        this.cpf = cpf;
    }

    public int idade(Data hoje) {
        int diaAtual = hoje.getDia();
        int mesAtual = hoje.getMes();
        int anoAtual = hoje.getAno();

        int diaNasc = this.dataNascimento.getDia();
        int mesNasc = this.dataNascimento.getMes();
        int anoNasc = this.dataNascimento.getAno();

        int idade = anoAtual - anoNasc;

        if (mesAtual < mesNasc || (mesAtual == mesNasc && diaAtual < diaNasc)){
            idade--;
        }

        System.out.println(nome + "tem " + idade + " anos.");
        return idade;
    }*/

    

}
