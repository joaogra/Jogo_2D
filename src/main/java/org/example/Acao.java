package org.example;

import java.sql.SQLOutput;

public class Acao {
    public void movimentacao(Tabuleiro tabuleiroAtual, Personagem personagemAtual, Personagem oponente) {
        //Scanner teclado = new Scanner(System.in);
        String escolha = tabuleiroAtual.insereMovimento(personagemAtual);
        tabuleiroAtual.setPos(personagemAtual, oponente, escolha);
        tabuleiroAtual.imprimeTabuleiro();
    }

    public void atacar(Personagem atacante, Personagem defensor, Tabuleiro tabuleiro){
        if(verificaDistancia(atacante, defensor)) {
            defensor.setPontoVida(dano(atacante, defensor));
            defensor.setForcaDefesa(atacante.getForcaAtaque());//att a defesa do defensor
            tabuleiro.imprimeTabuleiro();
        }
        else{
            System.out.println("O " + defensor.getNome() + " NÃO ESTÁ NO ALCANCE!");
            System.out.println("VOCÊ PERDEU A VEZ!");
            System.out.println();
        }
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

    private boolean verificaDistancia(Personagem atacante, Personagem defensor){
        return (atacante.getAlcance() >= calculaDistancia(atacante, defensor));
    }

    private int calculaDistancia(Personagem atacante, Personagem defensor){
        return Math.max(Math.abs(atacante.getPos()[0] - defensor.getPos()[0]), Math.abs(atacante.getPos()[1] - defensor.getPos()[1]));
    }

    private int dano(Personagem atacante, Personagem defensor){
        return Math.max(0, atacante.getForcaAtaque() - defensor.getForcaDefesa());
    }
}
