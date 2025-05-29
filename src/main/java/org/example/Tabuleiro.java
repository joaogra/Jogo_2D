package org.example;

import java.util.Random;

public class Tabuleiro {
    private int [][] tabuleiro = new int[10][10];

    public Tabuleiro(){
        for(int linha = 0; linha < 10; linha++){
            for(int coluna = 0; coluna < 10; coluna++){
                tabuleiro[linha][coluna] = 0;
            }
        }
        startPosition();
    }

    private void startPosition(){
        Random posicao = new Random();
        int linha = posicao.nextInt(10);
        int coluna = posicao.nextInt(10);
        tabuleiro[linha][coluna] = 1;
        System.out.println("O Jogador 1 está na linha " + linha + " e na coluna " + coluna);

        do {
            linha = posicao.nextInt(10);
            coluna = posicao.nextInt(10);
        }while(tabuleiro[linha][coluna] == 1);

        tabuleiro[linha][coluna] = 2;
        System.out.println("O Jogador 2 está na linha " + linha + " e na coluna " + coluna);
    }

    public void imprimeTabuleiro(){
        System.out.print("Coluna  | ");
        for(int i = 0; i < 10; i++) {
            System.out.printf("%2d  ", i + 1);
        }
        System.out.println();

        for(int linha = 0; linha < 10; linha++){
            System.out.printf("Linha %2d|" , (linha + 1));

            for(int coluna = 0; coluna < 10; coluna++){
                System.out.printf(" %2d ",tabuleiro[linha][coluna]);
            }

            System.out.println();
        }
    }
}


