package org.inGame;

public class Acao {
    protected void movimentacao(Tabuleiro tabuleiroAtual, Personagem personagemAtual) {
        String escolha = tabuleiroAtual.insereMovimento(personagemAtual);
        tabuleiroAtual.setPos(personagemAtual,escolha);
    }

    protected void atacar(Personagem atacante, Personagem defensor){
        if(verificaDistancia(atacante, defensor)) {//Se o defensor estiver no alcance do atacante
            defensor.setPontoVidaDano(calculaDano(atacante, defensor));
            System.out.println("O " + defensor.getNome() + " / " + defensor.getIndicaPlayer() + " sofreu " + Math.max(calculaDano(atacante, defensor) - defensor.getForcaDefesa(),calculaDano(atacante,defensor))  + " de dano");

            defensor.setForcaDefesaDano(atacante.getForcaAtaque());//att a defesa do defensor
            System.out.println("A defesa atual do " + defensor.getNome() + " / " + defensor.getIndicaPlayer() + " = " + defensor.getForcaDefesa());
            System.out.println();
        }
        else{//Se o defensor estiver fora do alcance
            System.out.println("O " + defensor.getNome() + " NÃO ESTÁ NO ALCANCE!");
            System.out.println("VOCÊ PERDEU A VEZ!");
            System.out.println();
        }
    }

    protected  void defender(Personagem atual){ // A força de defesa do personagem é restaurada à inicial
        if(atual.getTipoPersonagem()==1) {
            atual.setDefesaMax(5);
            System.out.println("Alterando defesa atual para 5");
        }
        if(atual.getTipoPersonagem()==2) {
            atual.setDefesaMax(10);
            System.out.println("Alterando defesa atual para 10");
        }
        if(atual.getTipoPersonagem()==3) {
            System.out.println("Alterando defesa para 7");
            atual.setDefesaMax(7);
        }
    }

    protected void ultimate(Personagem atual, Personagem oponente){
        if(atual.getTipoPersonagem()==1){
            if(atual.getContador()){
                System.out.println("O seu alcance aumentou para 6!");
                System.out.println("Não pode mais usar essa habilidade!");
                atual.setAlcance(atual.getAlcance() + 1);
                atual.setContador(false);
                System.out.println();
            }
            else {
                System.out.println("Já usou a habilidade uma vez!");
                System.out.println("PERDEU A VEZ!");
                System.out.println();
            }
        }

        if(atual.getTipoPersonagem()==2){
            if(atual.getContador()) {
                atual.setForcaAtaque(atual.getForcaAtaque() * 2);
                System.out.println("O seu ataque aumentou para 30!");
                System.out.println("Não pode mais usar essa habilidade!");
                System.out.println();
                atual.setContador(false);
            }
            else {
                System.out.println("Já usou a habilidade uma vez!");
                System.out.println("PERDEU A VEZ!");
                System.out.println();
            }
        }

        if(atual.getTipoPersonagem()==3){
            if(atual.getContador()) {
                int aux=0;
                aux = atual.getPontoVida();
                atual.setPontoVida(oponente.getPontoVida());
                oponente.setPontoVida(aux);
                System.out.println("Trocou de vida com o oponente!");
                System.out.println("Agora " + atual.getNome() + " tem " + atual.getPontoVida());
                System.out.println("Agora " + oponente.getNome() + " tem " + oponente.getPontoVida());
                System.out.println("Não pode mais usar essa habilidade!");
                System.out.println();
                atual.setContador(false);
            }
            else{
                System.out.println("Já usou a habilidade uma vez!");
                System.out.println("PERDEU A VEZ!");
                System.out.println();
            }
        }

    }

    private boolean verificaDistancia(Personagem atacante, Personagem defensor){
        return (atacante.getAlcance() >= calculaDistancia(atacante, defensor));
    }

    private int calculaDistancia(Personagem atacante, Personagem defensor){
        return Math.max(Math.abs(atacante.getPos()[0] - defensor.getPos()[0]), Math.abs(atacante.getPos()[1] - defensor.getPos()[1]));
    }

    private int calculaDano(Personagem atacante, Personagem defensor){
        return Math.max(0, atacante.getForcaAtaque() - defensor.getForcaDefesa());
    }
}
