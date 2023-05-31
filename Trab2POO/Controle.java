package Trab2POO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

//muitos imports
public class Controle {
    private ArrayList<Jogador> jogadores;
    private String correta;
    private Jogador atual;

    public Controle() {
        this.jogadores = new ArrayList<>();
        this.correta = "";
        carregarJogadoresArq();
    }
    
    public int sortear() {
        Random r = new Random();
        int numero = r.nextInt(9) + 1;
        this.correta += numero;
        return numero;
    }

    

    public Jogador localizarJogador(String nome) throws IllegalArgumentException{
        for(Jogador jogador : this.jogadores){
            if(nome.equals(jogador.getNome())) return jogador;
        }

        Jogador novoJogador = new Jogador(nome);
        this.jogadores.add(novoJogador);
        return novoJogador;
    }

    public void salvarJogadoresArq(){
        try {
            FileWriter r = new FileWriter("recordes.txt");
            BufferedWriter b = new BufferedWriter(r);

            b.write(this.jogadores.size() + "\n");

            for (Jogador jogador : this.jogadores){
                jogador.salvarArq(b);
            }

            b.close();
        }
        catch (IOException e){
            System.out.println("Erro ao salvar o arquivo de jogadores  em salvarJogadoresARQ.");
        }
    }

    public void carregarJogadoresArq() {
        try  {
            FileReader f = new FileReader("recordes.txt");
            BufferedReader b = new BufferedReader(f);
            
            String t = b.readLine();

            if(t != null){
                String[] dados = t.split("\n");
                int j = Integer.parseInt(dados[0]);

                for(int i = 0; i<j; i++){
                    this.jogadores.add(new Jogador(b));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de recordes em carregarJogadoresArq.controle" );
        }
    }

    public Jogador bemvindo() {
        String nome = JOptionPane.showInputDialog(null ," Qual seu nome ?", "Bem vindo !", JOptionPane.PLAIN_MESSAGE);

        while (nome == null || nome.isEmpty()) {
            nome = JOptionPane.showInputDialog(null, "Qual o seu nome:", "Nome inválido.", JOptionPane.PLAIN_MESSAGE);
        }
        return localizarJogador(nome);
    }


    public boolean errou() {
        int t = this.correta.length() - 1;

        int x = JOptionPane . showConfirmDialog (null ," Voce acertou " + t + " números. Deseja começar um novo jogo?", " Fim de jogo ", JOptionPane.YES_NO_OPTION);

        return x == JOptionPane.YES_OPTION;
    }

    public Jogador recordista() {
        Jogador recordista = jogadores.get(0);

        for (Jogador jogador : jogadores) {
            if (jogador.getPontosMax() > recordista.getPontosMax()) {
                recordista = jogador;
            }
        }
        return recordista;
    }

    public void bye(String nome, int pontosMax) {

        Jogador recordistaGeral = this.recordista();

        JOptionPane.showMessageDialog (null , " Recorde da sessao: " + nome + " - " + pontosMax + " ponto(s). Geral: " + recordistaGeral.getNome() + " - " + recordistaGeral.getPontosMax() + " ponto(s).", " RECORDES ", JOptionPane.PLAIN_MESSAGE);

        salvarJogadoresArq();
    }

    public void jogo() {

        boolean continuar = true;
        this.atual = bemvindo();
        Jogador recordistaSessao = new Jogador("teste");

        while (continuar) {
            int numero = sortear();
            String sequencia = JOptionPane.showInputDialog(null, "O novo número é: " + numero , "Digite a sequência completa", JOptionPane.PLAIN_MESSAGE);
            if (sequencia == null || !sequencia.equals(this.correta)) {

                continuar = errou();

                this.atual.atualizarRecorde(this.correta.length()-1);

                if (this.correta.length()-1 >=recordistaSessao.getPontosMax()) {
                    recordistaSessao.setNome(this.atual.getNome());
                    recordistaSessao.atualizarRecorde(this.correta.length()-1);
                }

                if(continuar){
                    this.atual = bemvindo();
                }
                correta = "";
            }
        }
        bye(recordistaSessao.getNome(), recordistaSessao.getPontosMax());
    }
}



