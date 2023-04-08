public class Pessoa {
    String nome;
    Data dataNascimento;
    char sexo;
    String cpf;

    Pessoa(String n, Data i, char s, String c) {
        /*Construtor da classe Pessoa */
        System.out.println("Nova pessoa criada no sistema.");
        this.nome = n;
        this.dataNascimento = i;
        this.sexo = s;
        this.cpf = c;
    }

    

}
