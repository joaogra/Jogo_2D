package org.example;

import java.lang.reflect.Array;
import java.util.Scanner;

public class
Personagem {
    private String nome;
    private int forcaAtaque, forcaDefesa, alcance, pontoVida;
    private final int tipoPersonagem;
    private final int indicaPlayer;//indica se é o player 1 ou o player 2
    private int[] posAtual = new int[2];

    public Personagem(String nome, int forcaAtaque, int forcaDefesa, int alcance, int indicaPlayer, int tipoPersonagem) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do personagem: ");
        defineNome(teclado.nextLine());

        pontoVida = 100;
        this.forcaAtaque = forcaAtaque;
        this.forcaDefesa = forcaDefesa;
        this.alcance = alcance;
        this.indicaPlayer = indicaPlayer;//Indica se é o player 1 ou player 2
        this.tipoPersonagem=tipoPersonagem;
    }

    public int getPontoVida() {
        return pontoVida;
    }

    public String getNome() {
        return nome;
    }

    public int getForcaAtaque() {
        return forcaAtaque;
    }

    public int getForcaDefesa() {
        return forcaDefesa;
    }

    public int getAlcance() {
        return alcance;
    }

    public  int getTipoPersonagem(){ return tipoPersonagem; }

    public int getIndicaPlayer() {
        return indicaPlayer;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public void setForcaAtaque(int forcaAtaque) {
        this.forcaAtaque = forcaAtaque;
    }

    public void setForcaDefesa(int forcaDefesa) {
        this.forcaDefesa = forcaDefesa;
    }

    public void setPontoVida(int pontoVida) {
        this.pontoVida = pontoVida;
    }

    public void defineNome(String s) {
        nome = s;
    }

    public void imprimeNome() {
        System.out.println("Seu nome é: " + nome);
    }

    public void setPos(int linha, int coluna) {
        posAtual[0] = linha;
        posAtual[1] = coluna;
    }

    public int [] getPos() {
        return posAtual;
    }
}

