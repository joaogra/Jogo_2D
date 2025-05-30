package org.example;

public class Jogo {

    public void jogo(Personagem p1, Personagem p2){
        Personagem atual = p1;
        Tabuleiro tabuleiro1 = new Tabuleiro(p1,p2);
        tabuleiro1.imprimeTabuleiro();
        p1.setPos(p1.getPos()[0],1);
        p2.setPos(p2.getPos()[1],8);
        tabuleiro1.setPos(p1, "a");
        tabuleiro1.imprimeTabuleiro();

        while (p1.getPontoVida() < 0 && p2.getPontoVida()<0){
             rodada(atual);
             if(atual == p1)
                 atual = p2;
             else
                 atual = p1;


        }
    }

    public void rodada(Personagem p){
        Acao acao = new Acao();
    }
}
