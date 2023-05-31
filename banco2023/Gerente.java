import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Gerente extends Pessoa{
    private String matricula;
    private String senha;

    public Gerente(BufferedReader b){
        super(b);
        try{
            this.senha = b.readLine();
            this.matricula = b.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Gerente(){
        super();
        Scanner s = new Scanner(System.in);

        System.out.print("Digite a matricula: ");
        this.matricula = s.nextLine();

        System.out.print("Digite a senha: ");
        this.senha = s.nextLine();
        
    }

    public String getMatricula(){
        return matricula;
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }

    /*public Gerente(String nome, Data d, char sexo, String cpf, String m, String senha) {
        super(nome, d, sexo, cpf);
        this.matricula = m;
        this.senha = senha;
        System.out.println("Novo gerente criado no sistema.");
    }*/

    public boolean validarAcesso(String s){
        return s.equals(senha);
    }
    /*
    public boolean validarAcesso(){
        Scanner s = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        String senha = s.nextLine();

        return this.validarAcesso(senha);
    }*/
    
    public void salvarArq(BufferedWriter b)throws IOException{
        super.salvarArq(b);
        b.write(this.senha + "\n");
        b.write(this.matricula + "\n");
    }
}

