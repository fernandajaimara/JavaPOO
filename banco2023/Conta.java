public class Conta {
    String numero;
    Pessoa titular;
    Gerente ger;
    double saldo;
    Data criacao;

    
    Conta(String numero, Pessoa titular, Gerente ger, Data criacao){
        this.numero = numero;
        this.titular = titular;
        this.ger = ger;
        this.criacao = criacao;
        this.saldo = 0;
        System.out.println("Nova conta adicionada ao sistema.");
    }

    void depositar(double valor){
        this.saldo += valor;
    }

    
    /*boolean transferir(double valor, Conta destino) {
        if(this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transaferencia de "+ valor + " da conta "+ this.numero + " para a conta " + destino.numero + " foi realizado com sucesso.");
            return true;
        }
        else{
            System.out.println("ERRO: Não foi possível transferir " + valor + " da conta " + this.numero + " para a conta " + destino.numero + ". Valor disponivel: "+ this.disponivel());
            return false;
    }*/
}