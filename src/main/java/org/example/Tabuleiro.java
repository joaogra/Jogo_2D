package org.example;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
    private int [][] tabuleiro = new int[10][10];

    public Tabuleiro(Personagem p1, Personagem p2){
        for(int linha = 0; linha < 10; linha++){
            for(int coluna = 0; coluna < 10; coluna++){
                tabuleiro[linha][coluna] = 0;
            }
        }
        startPosition(p1,p2);
    }

    private void startPosition(Personagem p1, Personagem p2){
        Random posicao = new Random();
        int linha = posicao.nextInt(10);
        int coluna = posicao.nextInt(10);
        p1.setPos(linha, coluna);
        tabuleiro[linha][coluna] = 1;
        System.out.println("O Jogador 1 está na linha " + (linha+1) + " e na coluna " + (coluna+1));

        do {
            linha = posicao.nextInt(10);
            coluna = posicao.nextInt(10);
        }while(tabuleiro[linha][coluna] == 1);
        p2.setPos(linha, coluna);
        tabuleiro[linha][coluna] = 2;
        System.out.println("O Jogador 2 está na linha " + (linha+1) + " e na coluna " + (coluna+1));
    }

    public void imprimeTabuleiro(){
        System.out.print("C   | ");
        for(int i = 0; i < 10; i++) {
            System.out.printf("%2d  ", i + 1);
        }
        System.out.println();

        for(int linha = 0; linha < 10; linha++){
            System.out.printf("L %2d|" , (linha + 1));

            for(int coluna = 0; coluna < 10; coluna++){
                System.out.printf(" %2d ",tabuleiro[linha][coluna]);
            }

            System.out.println();
        }
        System.out.println();
    }

    public void setPos(Personagem p, String direcao,int indicePersonagem){
        do {
            switch (direcao) {
                case "C":
                    if (p.getPos()[0] != 0) {//Verifica se esta na linha 0
                        tabuleiro[p.getPos()[0]][p.getPos()[1]] = 0;
                        tabuleiro[p.getPos()[0] - 1][p.getPos()[1]] = indicePersonagem;//anda para cima
                        p.setPos(p.getPos()[0] - 1, p.getPos()[1]);//att a posicao do personagem
                        return;
                    }
                    System.out.println("Posição Invalida!");
                    direcao = insereMovimento();//Usuario insere denovo
                    break;//repete o loop

                case "B":
                    if (p.getPos()[0] != 9) {//Verifica se esta na 9
                        tabuleiro[p.getPos()[0]][p.getPos()[1]] = 0;
                        tabuleiro[p.getPos()[0] + 1][p.getPos()[1]] = indicePersonagem;//anda para baixo
                        p.setPos(p.getPos()[0] + 1, p.getPos()[1]);
                        return;
                    }
                    System.out.println("Posição Invalida!");
                    direcao = insereMovimento();
                    break;

                case "D":
                    if (p.getPos()[1] != 9) {//Verifica se esta na coluna 9
                        tabuleiro[p.getPos()[0]][p.getPos()[1]] = 0;
                        tabuleiro[p.getPos()[0]][p.getPos()[1] + 1] = indicePersonagem;//anda para a direita
                        p.setPos(p.getPos()[0], p.getPos()[1] + 1);
                        return;
                    }
                    System.out.println("Posição Invalida!");
                    direcao = insereMovimento();
                    break;

                case "E":
                    if (p.getPos()[1] != 0) {//Verifica se esta na coluna 0
                        tabuleiro[p.getPos()[0]][p.getPos()[1]] = 0;
                        tabuleiro[p.getPos()[0]][p.getPos()[1] - 1] = indicePersonagem;//Anda para a esquerda
                        p.setPos(p.getPos()[0], p.getPos()[1] - 1);
                        return;
                    }
                    System.out.println("Posição Invalida!");
                    direcao = insereMovimento();
                    break;

                default://caso receba uma String invalida
                    System.out.println("Opção Invalida!");
                    direcao = insereMovimento();
                    break;
            }
        }while(true);//repete o switch se der Posicao invalida
    }

    private String insereMovimento(){
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
                    System.out.println("Jogador Invalida!");
                    break;
            }
        }while(true);
    }
}


