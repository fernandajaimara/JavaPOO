public class Gerente extends Pessoa{
    String matricula, senha;

    Gerente(String nome, Data i, char sexo, String cpf, String m, String senha) {
        /*Construtor da subclasse Gerente */
        super(nome, i, sexo, cpf);
        this.matricula = m;
        this.senha = senha;
        System.out.println("Novo gerente criado no sistema.");
    }

    boolean validarAcesso(String s){
        return s.equals(senha);
    }
}
