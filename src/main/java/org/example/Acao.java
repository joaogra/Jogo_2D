package org.example;

import java.util.Scanner;

public class Acao {
    public void movimentacao(Tabuleiro tabuleiroAtual, Personagem personagemAtual) {
        Scanner teclado = new Scanner(System.in);
        String escolha = teclado.nextLine();
        tabuleiroAtual.setPos(personagemAtual, escolha, personagemAtual.getIndicaPlayer());
        tabuleiroAtual.imprimeTabuleiro();
    }
}
