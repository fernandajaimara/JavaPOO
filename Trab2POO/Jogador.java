package Trab2POO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Jogador {
    private String nome;
    private int pontosMax;

    
    public Jogador(String nome) {
        this.nome = nome;
        this.pontosMax = 0;
    }

    public Jogador(BufferedReader b){
        try{
            String linha = b.readLine();
            String[] dados = linha.split(",");
            this.nome = dados[0];
            this.pontosMax = Integer.parseInt(dados[1]);
        }
        catch (IOException e){
            System.out.println(e);
        }
    } 

    public void atualizarRecorde(int pontos) {
        if (pontos >= this.pontosMax) {
            pontosMax = pontos;
        }
    }

    public void salvarArq(BufferedWriter buffer) throws IOException {
        buffer.write(nome + "," + pontosMax);
        buffer.newLine();
    }

    public String getNome() {
        return nome;
    }

    public int getPontosMax() {
        return pontosMax;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

}
