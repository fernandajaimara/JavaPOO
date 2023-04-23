public class Pessoa {
    String nome;
    Data dataNascimento;
    char sexo;
    String cpf;

    Pessoa(String nome, Data i, char sexo, String cpf) {
        /*Construtor da classe Pessoa */
        System.out.println("Nova pessoa criada no sistema.");
        this.nome = nome;
        this.dataNascimento = i;
        this.sexo = sexo;
        this.cpf = cpf;
    }

    int idade(Data hoje) {
        /*Método compara duas datas e retorna idade da pessoa*/
        int diaAtual = hoje.dia;
        int mesAtual = hoje.mes;
        int anoAtual = hoje.ano;

        int diaNasc = this.dataNascimento.dia;
        int mesNasc = this.dataNascimento.mes;
        int anoNasc = this.dataNascimento.ano;

        int idade = anoAtual - anoNasc;

        if (mesAtual < mesNasc || (mesAtual == mesNasc && diaAtual < diaNasc)){
            idade--;
        }

        System.out.println(nome + "tem " + idade + " anos.");
        return idade;
    }

    

}
