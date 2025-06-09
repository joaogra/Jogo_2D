package org.inGame;

import java.util.Scanner;

public class
Personagem {
    private String nome;
    private int forcaAtaque, forcaDefesa, alcance, pontoVida;
    private final int tipoPersonagem; // Indica se o personagem é Arqueiro, Guerreiro ou Mago
    private final String indicaPlayer;//indica se é o player 1 ou o player 2
    private int[] posAtual = new int[2];
    private boolean contador = true;

    public Personagem(int forcaAtaque, int forcaDefesa, int alcance, String indicaPlayer, int tipoPersonagem) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do personagem: ");
        defineNome(teclado.nextLine());

        pontoVida = 100;
        this.forcaAtaque = forcaAtaque;
        this.forcaDefesa = forcaDefesa;
        this.alcance = alcance;
        this.indicaPlayer = indicaPlayer;
        this.tipoPersonagem = tipoPersonagem;
    }

    protected int getPontoVida() {
        return pontoVida;
    }

    protected String getNome() {
        return nome;
    }

    protected int getForcaAtaque() {
        return forcaAtaque;
    }

    protected int getForcaDefesa() {
        return forcaDefesa;
    }

    protected int getAlcance() {
        return alcance;
    }

    protected int getTipoPersonagem() { return tipoPersonagem;}

    protected String getIndicaPlayer() {
        return indicaPlayer;
    }

    protected int[] getPos() {
        return posAtual;
    }

    protected boolean getContador(){ return contador;}


    protected void setContador(boolean contador) { this.contador = contador;}
    protected void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    protected void setForcaAtaque(int forcaAtaque) {
        this.forcaAtaque = forcaAtaque;
    }

    protected void setForcaDefesa(int dano) {

        forcaDefesa = Math.max(0, forcaDefesa - dano) ;
    }

    protected void setDefesaMax(int defesaMax) {
        forcaDefesa = defesaMax;
    }
    protected void setPontoVidaDano(int dano) {
        pontoVida = pontoVida - dano;
    }
    protected void setPontoVida(int vida) {
        pontoVida = vida;
    }

    protected void setPos(int linha, int coluna) {
        posAtual[0] = linha;
        posAtual[1] = coluna;
    }

    private void defineNome(String s) {
        nome = s;
    }



}

