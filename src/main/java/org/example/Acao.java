package org.example;

import java.util.Scanner;

public class Acao {
    public void movimentacao(Tabuleiro tabuleiroAtual, Personagem personagemAtual) {
        Scanner teclado = new Scanner(System.in);
        String acao = teclado.nextLine();
        tabuleiroAtual.setPos(personagemAtual, acao , personagemAtual.getIndicaPlayer());
        tabuleiroAtual.imprimeTabuleiro();
    }
}
