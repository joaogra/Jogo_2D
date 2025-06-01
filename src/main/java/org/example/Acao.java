package org.example;

import java.util.Scanner;

public class Acao {
    public void movimentacao(Tabuleiro tabuleiroAtual, Personagem personagemAtual) {
        //Scanner teclado = new Scanner(System.in);
        String escolha = tabuleiroAtual.insereMovimento(personagemAtual);
        tabuleiroAtual.setPos(personagemAtual, escolha, personagemAtual.getIndicaPlayer());
        tabuleiroAtual.imprimeTabuleiro();
    }

    public void atacar(Tabuleiro tabuleiroAtual, Personagem atacante, Personagem defensor){

    }

    public  void defender(Personagem atual){ // A força de defesa do personagem é restaurada à inicial
        if(atual.getTipoPersonagem()==1)
            atual.setForcaDefesa(5);
        if(atual.getTipoPersonagem()==2)
            atual.setForcaDefesa(10);
        if(atual.getTipoPersonagem()==3)
            atual.setForcaDefesa(7);
    }

    public  void ultimate(Personagem atual, Personagem oponente){
        if(atual.getTipoPersonagem()==1){
            atual.setAlcance(atual.getAlcance()+1);
        }

        if(atual.getTipoPersonagem()==2){
            atual.setForcaAtaque(atual.getForcaAtaque()*2);
        }

        if(atual.getTipoPersonagem()==3){
         int aux=0;
         aux = atual.getPontoVida();
         atual.setPontoVida(oponente.getPontoVida());
         oponente.setPontoVida(aux);
        }

    }
}
