import java.util.Scanner;
public class Gerente extends Pessoa{
    private String matricula;
    private String senha;

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
}
