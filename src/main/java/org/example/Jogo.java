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
        Personagem oponente = p2;
        Tabuleiro tabuleiro1 = new Tabuleiro(p1,p2);

        tabuleiro1.imprimeTabuleiro();
        //rodada(p1,tabuleiro1);
        //rodada(p2,tabuleiro1);
        //tabuleiro1.setPos(p1, "a", p1.getIndicaPlayer());
        //tabuleiro1.imprimeTabuleiro();

        while (p1.getPontoVida() > 0 && p2.getPontoVida() > 0 && querSair){
            informacoes(p1);
            informacoes(p2);
            System.out.println(" ");
             rodada(atual, oponente, tabuleiro1);//ta faltando imprimir o tabuleiro no meio das rodadas
             if(atual == p1) {
                 atual = p2;
                 oponente = p1;
             }
             else{
                atual = p1;
                oponente = p2;
            }
               // atual.setPontoVida(atual.getPontoVida()-20); // Teste só pra sair do while
        }
        if(p1.getPontoVida()<=0)
            System.out.println("FIM DE JOGO! " + p2.getNome() + " é o grande VENCEDOR!");
        if (p2.getPontoVida()<=0)
            System.out.println("FIM DE JOGO! " + p1.getNome() + " é o grande VENCEDOR!");
    }

    public void informacoes(Personagem p){
        System.out.println(p.getNome());
        System.out.println("Vida: " + p.getPontoVida());
        System.out.println("Força de Ataque: " + p.getForcaAtaque());
        System.out.println("Força de Defesa: " + p.getForcaDefesa());
        System.out.println("Alcance: " + p.getAlcance());
        System.out.println();
    }

    public void rodada(Personagem p1, Personagem p2, Tabuleiro tabuleiro1){
        Acao acao = new Acao();
        System.out.println("Vez de " + p1.getNome());
        System.out.println("ESCOLHA SUA AÇÃO:");
        System.out.println("1 - MOVIMENTAR | 2 - ATACAR | 3 - DEFENDER | 4 - ATAQUE ESPECIAL | 5 - SAIR");
        Scanner teclado = new Scanner(System.in);
        String escolha = teclado.nextLine();
        boolean teste = false;
        do {
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
                    querSair = false;//se escolher "5" da false e quebra o while
                    break;
                default:
                    teste = true;
                    System.out.println("Ação inválida!");
            }
        }while (teste);
    }
}
