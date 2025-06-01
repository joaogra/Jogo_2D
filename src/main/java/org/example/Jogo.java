package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Jogo {
    private Boolean querSair;//cria variavel pra sair do jogo
    public Jogo() {
        querSair = true;
    }
    public void jogo(Personagem p1, Personagem p2) {
        Personagem atual = p1;
        Tabuleiro tabuleiro1 = new Tabuleiro(p1,p2);

        tabuleiro1.imprimeTabuleiro();
        //rodada(p1,tabuleiro1);
        //rodada(p2,tabuleiro1);
        //tabuleiro1.setPos(p1, "a", p1.getIndicaPlayer());
        //tabuleiro1.imprimeTabuleiro();

        while (p1.getPontoVida() > 0 && p2.getPontoVida() > 0 && querSair){
            System.out.println("Vida de " + p1.getNome() + ": " + p1.getPontoVida());
            System.out.println("Vida de " + p2.getNome() + ": " + p2.getPontoVida());
            System.out.println(" ");
             rodada(atual, tabuleiro1);
             if(atual == p1)
                 atual = p2;
             else
                 atual = p1;

        atual.setPontoVida(atual.getPontoVida()-50); // Teste só pra sair do while
        }
        if(p1.getPontoVida()<=0)
            System.out.println("FIM DE JOGO! " + p2.getNome() + " é o grande VENCEDOR!");
        if (p2.getPontoVida()<=0)
            System.out.println("FIM DE JOGO! " + p1.getNome() + " é o grande VENCEDOR!");
    }

    public void rodada(Personagem p, Tabuleiro tabuleiro1){
        Acao acao = new Acao();
        System.out.println("ESCOLHA SUA AÇÃO:");
        System.out.println("1 - MOVIMENTAR | 2 - ATACAR | 3 - DEFENDER | 4 - ATAQUE ESPECIAL | 5 - SAIR");
        Scanner teclado = new Scanner(System.in);
        String escolha = teclado.nextLine();
        boolean teste = false;
        do {
            switch (escolha) {
                case "1":
                    acao.movimentacao(tabuleiro1, p);
                    break;
                case "2":
                    //acao.atacar(); Complementar quando implementar a função "ATACAR"
                    break;
                case "3":
                    acao.defender(p);
                    break;
                case "4":
                    acao.ultimate(p);
                    break;
                case "5":
                    querSair = false;//se escolher "5" da false e quebra o while
                    break;
                default:
                    teste = true;
                    System.out.println("Ação inválida!");
            }
        }while (teste);
    }
}
