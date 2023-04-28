import java.util.Scanner;
public class Gerente extends Pessoa{
    String matricula, senha;

    Gerente(String nome, Data d, char sexo, String cpf, String m, String senha) {
        /*Construtor da subclasse Gerente */
        super(nome, d, sexo, cpf);
        this.matricula = m;
        this.senha = senha;
        System.out.println("Novo gerente criado no sistema.");
    }

    boolean validarAcesso(String s){
        return s.equals(senha);
    }

    boolean validarAcesso(){
        Scanner s = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        String senha = s.nextLine();

        return this.validarAcesso(senha);
    }
}
