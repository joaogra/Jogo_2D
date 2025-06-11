package org.inGame;

import java.util.Scanner;

public class Jogo {

    public void jogoMultiPlayer(Personagem p1, Personagem p2) {
        Personagem atual = p1;
        Personagem oponente = p2;
        Tabuleiro tabuleiro1 = new Tabuleiro(p1,p2);
        while (p1.getPontoVida() > 0 && p2.getPontoVida() > 0 ){
            informacoes(p1, p2);
            tabuleiro1.imprimeTabuleiro();

            rodadaPlayer(atual, oponente, tabuleiro1);
             if(atual == p1) {
                 atual = p2;
                 oponente = p1;
             }
             else{
                atual = p1;
                oponente = p2;
            }
        }
        if(p1.getPontoVida()<=0)
            System.out.println("FIM DE JOGO! " + p2.getIndicaPlayer() + ": " + p2.getNome() +" é o grande VENCEDOR!");
        if (p2.getPontoVida()<=0)
            System.out.println("FIM DE JOGO! " + p1.getIndicaPlayer() + ": " + p1.getNome() + " é o grande VENCEDOR!");
    }

    public void jogoBot(Personagem p1, Personagem p2) {
        Personagem atual = p1;
        Personagem oponente = p2;
        Tabuleiro tabuleiro1 = new Tabuleiro(p1,p2);
        int contador = 1;
        while (p1.getPontoVida() > 0 && p2.getPontoVida() > 0 ){
            informacoes(p1, p2);
            tabuleiro1.imprimeTabuleiro();

            if(contador % 2 != 0) {
                rodadaPlayer(atual, oponente, tabuleiro1);
            }
            else{
                rodadaBot(atual, oponente, tabuleiro1);
            }

            if(atual == p1) {
                atual = p2;
                oponente = p1;
            }
            else{
                atual = p1;
                oponente = p2;
            }

            contador = contador + 1;
        }
        if(p1.getPontoVida()<=0)
            System.out.println("FIM DE JOGO! " + p2.getIndicaPlayer() + ": " + p2.getNome() +" é o grande VENCEDOR!");
        if (p2.getPontoVida()<=0)
            System.out.println("FIM DE JOGO! " + p1.getIndicaPlayer() + ": " + p1.getNome() + " é o grande VENCEDOR!");
    }

    private void informacoes(Personagem p1, Personagem p2){ // Exibe os atributos atuais dos players
        System.out.println(p1.getIndicaPlayer() + ":" + "                      " + p2.getIndicaPlayer() + ":");
        System.out.println("Vida: " + p1.getPontoVida() + "                 " + "Vida: " + p2.getPontoVida());
        System.out.println("Força de Ataque: " + p1.getForcaAtaque() + "       " + "Força de Ataque: " + p2.getForcaAtaque());
        System.out.println("Força de Defesa: " + p1.getForcaDefesa() + "       " + "Força de Defesa: " + p2.getForcaDefesa());
        System.out.println("Alcance: " + p1.getAlcance() + "               " + "Alcance: " + p2.getAlcance() );
        System.out.println();
    }

    private void rodadaPlayer(Personagem p1, Personagem p2, Tabuleiro tabuleiro1){
        Acao acao = new Acao();
        System.out.println("Vez de " + p1.getIndicaPlayer() + " | " + p1.getNome() );
        boolean teste;
        do {
            teste = false;
            System.out.println("ESCOLHA SUA AÇÃO:");
            System.out.println("1 - MOVIMENTAR | 2 - ATACAR | 3 - DEFENDER | 4 - ATAQUE ESPECIAL | 5 - SAIR");
            Scanner teclado = new Scanner(System.in);
            String escolha = teclado.nextLine();
            switch (escolha) {
                case "1":
                    acao.movimentacao(tabuleiro1, p1);
                    break;
                case "2":
                    acao.atacar(p1, p2);
                    break;
                case "3":
                    acao.defender(p1);
                    break;
                case "4":
                    acao.ultimate(p1, p2);
                    break;
                case "5":
                    System.out.println("Encerrando jogo!");
                    System.exit(0);//encerra o programa
                default:
                    teste = true;
                    System.out.println("Ação inválida!");
                    break;
            }
        }while (teste);
    }

    private boolean numDef = false;//Só pra evitar o BOT ficar defendendo duas vezes seguidas
    private void rodadaBot(Personagem p1, Personagem p2, Tabuleiro tabuleiro1){
        Acao acao = new Acao();

        //Mago usa o ataque especial (se disponível) se tiver com vida baixa (< 40) e se a vida dele for menor que a do oponente
        if(p1.getContador() && p1.getTipoPersonagem() == 3 && p1.getPontoVida() < 40 && p1.getPontoVida() < p2.getPontoVida()){
            System.out.println("BOT usou a ultimate!");
            acao.ultimate(p1,p2);
            numDef = true;
            return;
        }

        //Guerreiro ou arqueiro usa o ataque especial no começo já que quase sempre vai valer a pena
        if(p1.getContador() && (p1.getTipoPersonagem() == 1 || p1.getTipoPersonagem() == 2)) {
            System.out.println("BOT usou a ultimate!");
            acao.ultimate(p1, p2);
            numDef = true;
            return;
        }

        //Se a defesa do BOT for zero e o BOT ter menos vida q o Player e ele não tiver defendido na ultima rodada ele usa o defender
        if(p1.getPontoVida() <= p2.getPontoVida() && p1.getForcaDefesa() == 0 && numDef){
            System.out.println("O BOT defendeu!");
            acao.defender(p1);
            numDef = false;
            return;
        }

        //Se tiver no alcance o BOT vai atacar
        if(calculaDistancia(p1,p2) <= p1.getAlcance()){
            System.out.println("O BOT atacou!");
            acao.atacar(p1, p2);
            numDef = true;
            return;
        }


        //Se o BOT estiver longe anda pra mais perto do player
        if(calculaDistancia(p1,p2) > p1.getAlcance()){
            if(Math.abs(p1.getPos()[0] - p2.getPos()[0]) > p1.getAlcance()) {
                //Verifica se é a linha que está fora de alcance

                if (p1.getPos()[0] > p2.getPos()[0]) {
                //Verifica se a linha do bot é maior que a do player, então anda pra cima

                    tabuleiro1.setPos(p1,"C");
                    System.out.println("P2 se moveu para cima");
                    return;
                }

                if (p1.getPos()[0] < p2.getPos()[0]) {
                //Verifica se a linha do bot é menor que a do player, então anda pra baixo

                    tabuleiro1.setPos(p1,"B");
                    System.out.println("P2 se moveu para baixo");
                    return;
                }
            }

            if(Math.abs(p1.getPos()[1] - p2.getPos()[1]) > p1.getAlcance()) {
                //Verifica se é a coluna que está fora de alcance

                if (p1.getPos()[1] > p2.getPos()[1]) {
                //Coluna do bot maior que a do player entao anda pra esquerda

                    tabuleiro1.setPos(p1,"E");
                    System.out.println("P2 se moveu para esquerda");
                    return;
                }

                if (p1.getPos()[1] < p2.getPos()[1]) {
                //Linha do bot menor que a do player entao anda pra direita

                    tabuleiro1.setPos(p1,"D");
                    System.out.println("P2 se moveu para direita");
                }
            }
        }


    }
    private int calculaDistancia(Personagem atacante, Personagem defensor){
        return Math.max(Math.abs(atacante.getPos()[0] - defensor.getPos()[0]), Math.abs(atacante.getPos()[1] - defensor.getPos()[1]));
    }
}
