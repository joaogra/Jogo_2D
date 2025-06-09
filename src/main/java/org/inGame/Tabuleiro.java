package org.inGame;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
    private String [][] tabuleiro = new String[10][10];

    protected Tabuleiro(Personagem p1, Personagem p2){
        for(int linha = 0; linha < 10; linha++){
            for(int coluna = 0; coluna < 10; coluna++){
                tabuleiro[linha][coluna] = "•";//"o"
            }
        }
        startPosition(p1,p2);
    }

    private void startPosition(Personagem p1, Personagem p2){ // Define a posição inicial dos jogadores
        Random posicao = new Random();
        int linha = posicao.nextInt(10);
        int coluna = posicao.nextInt(10);
        p1.setPos(linha, coluna);
        tabuleiro[linha][coluna] = "P1";
        System.out.println("O Jogador 1 está na linha " + (linha+1) + " e na coluna " + (coluna+1));

        do {
            linha = posicao.nextInt(10);
            coluna = posicao.nextInt(10);
        }while(tabuleiro[linha][coluna].equals("P1"));
        p2.setPos(linha, coluna);
        tabuleiro[linha][coluna] = "P2";
        System.out.println("O Jogador 2 está na linha " + (linha+1) + " e na coluna " + (coluna+1));
    }

    protected void imprimeTabuleiro(){
        System.out.print("C   | ");
        for(int i = 0; i < 10; i++) {
            System.out.printf("%2d  ", i + 1);
        }
        System.out.println();


        for(int linha = 0; linha < 10; linha++){
            System.out.printf("L %2d|" , (linha + 1));

            for(int coluna = 0; coluna < 10; coluna++){
                System.out.printf(" %2s ",tabuleiro[linha][coluna]);
            }

            System.out.println();
        }
        System.out.println();
    }

    protected void setPos(Personagem p,String direcao){
        do {
            switch (direcao) {
                case "C":
                    if (p.getPos()[0] != 0 && tabuleiro[p.getPos()[0] - 1][p.getPos()[1]].equals("•") ) {//Verifica se esta na linha 0
                        tabuleiro[p.getPos()[0]][p.getPos()[1]] = "•";
                        tabuleiro[p.getPos()[0] - 1][p.getPos()[1]] = p.getIndicaPlayer();//anda para cima
                        p.setPos(p.getPos()[0] - 1, p.getPos()[1]);//att a posicao do personagem
                        return;
                    }
                    System.out.println("Posição Invalida!");
                    direcao = insereMovimento(p);//Usuario insere denovo
                    break;//repete o loop

                case "B":
                    if (p.getPos()[0] != 9 && tabuleiro[p.getPos()[0] + 1][p.getPos()[1]].equals("•")) {//Verifica se esta na 9
                        tabuleiro[p.getPos()[0]][p.getPos()[1]] = "•";
                        tabuleiro[p.getPos()[0] + 1][p.getPos()[1]] = p.getIndicaPlayer();//anda para baixo
                        p.setPos(p.getPos()[0] + 1, p.getPos()[1]);
                        return;
                    }
                    System.out.println("Posição Invalida!");
                    direcao = insereMovimento(p);
                    break;

                case "D":
                    if (p.getPos()[1] != 9 && tabuleiro[p.getPos()[0]][p.getPos()[1] + 1].equals("•")) {//Verifica se esta na coluna 9
                        tabuleiro[p.getPos()[0]][p.getPos()[1]] = "•";
                        tabuleiro[p.getPos()[0]][p.getPos()[1] + 1] = p.getIndicaPlayer();//anda para a direita
                        p.setPos(p.getPos()[0], p.getPos()[1] + 1);
                        return;
                    }
                    System.out.println("Posição Invalida!");
                    direcao = insereMovimento(p);
                    break;

                case "E":
                    if (p.getPos()[1] != 0 && tabuleiro[p.getPos()[0]][p.getPos()[1] - 1].equals("•")) {//Verifica se esta na coluna 0
                        tabuleiro[p.getPos()[0]][p.getPos()[1]] = "•";
                        tabuleiro[p.getPos()[0]][p.getPos()[1] - 1] = p.getIndicaPlayer();//Anda para a esquerda
                        p.setPos(p.getPos()[0], p.getPos()[1] - 1);
                        return;
                    }
                    System.out.println("Posição Invalida!");
                    direcao = insereMovimento(p);
                    break;

                default://caso receba uma String invalida
                    System.out.println("Opção Invalida!");
                    direcao = insereMovimento(p);
                    break;
            }
        }while(true);//repete o switch se der Posicao invalida
    }

    protected String insereMovimento(Personagem personagemAtual){ // Permite o usuário escolher a direção do movimento
        System.out.println("Vez de " +personagemAtual.getNome() +":");
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Digite 'C' para andar para cima");
            System.out.println("Digite 'B' para andar para baixo");
            System.out.println("Digite 'E' para andar para esquerda");
            System.out.println("Digite 'D' para andar para direita");
            switch(teclado.nextLine().toUpperCase()){
                case "C":
                    return "C";
                case "B":
                    return "B";
                case "E":
                    return "E";
                case "D":
                    return "D";
                default:
                    System.out.println("Jogada Inválida!");
                    break;
            }
        }while(true);
    }
}


