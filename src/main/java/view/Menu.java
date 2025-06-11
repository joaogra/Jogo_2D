package view;


import org.inGame.Personagem;

import java.util.Scanner;

public class Menu {
    protected int modoDeJogo (){
        System.out.println("  ____  _   _ _____ _              __ \n" +
                " |  _ \\| | | | ____| |       ___  / _|\n" +
                " | | | | | | |  _| | |      / _ \\| |_ \n" +
                " | |_| | |_| | |___| |___  | (_) |  _|\n" +
                " |____/ \\___/|_____|_____|  \\___/|_|  \n" +
                "                                    ");
        System.out.println("   ____ _   _    _    __  __ ____ ___ ___  _   _ ____  \n" +
                "  / ___| | | |  / \\  |  \\/  |  _ \\_ _/ _ \\| \\ | / ___| \n" +
                " | |   | |_| | / _ \\ | |\\/| | |_) | | | | |  \\| \\___ \\ \n" +
                " | |___|  _  |/ ___ \\| |  | |  __/| | |_| | |\\  |___) |\n" +
                "  \\____|_| |_/_/   \\_\\_|  |_|_|  |___\\___/|_| \\_|____/ \n" +
                "                                                       ");
        System.out.println("Seja muito bem vindo ao jogo DUEL OF CHAMPIONS! Esse é um jogo de batalhas por turnos entre 2 personagens. Temos a opção de jogador conta jogador e jogador contra máquina.\n" +
                "O jogo possui 3 tipos de personagem:\n" +
                "* Arqueiro: Possui alcance de ataque à distância, mas defesa mais baixa.\n" +
                "* Guerreiro: É mais resistente e possui ataque corpo a corpo.\n" +
                "* Mago: Pode lançar feitiços especiais, mas possui defesa fraca.\n" +
                "\n" +
                "Toda a dinâmica do jogo ocorre via console e as interações são sempre via teclado.  \n" +
                "Muito obrigado por jogar e aproveite!");
        System.out.println();
        System.out.println("Escolha seu modo de jogo:");
        System.out.println("1 - Player vs Player | 2 - Player vs Bot | 3 - Sair" );
        Scanner teclado = new Scanner(System.in);
        do {
            String resp = teclado.nextLine();
            switch (resp) {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(true);
    }

     protected Personagem seletordePersonagem (String indice){ // Menu de Seleção de Personagem
        System.out.println("Escolha seu personagem: " + indice);
        System.out.println("1 - Arqueiro / 2 - Guerreiro / 3 - Mago");
        Scanner teclado = new Scanner(System.in);
        do {
            String resp = teclado.nextLine();
            switch (resp) {
                case "1":
                    return new Personagem( 8, 5, 5 , indice, 1);
                case "2":
                    return new Personagem( 15, 10, 1, indice, 2);
                case "3":
                    return new Personagem( 10, 7, 3, indice, 3);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(true);
    }

    protected Personagem seletordePersonagemBot(String indice){ // Seletor de Personagem pro BOT
        System.out.println("Escolha o personagem do BOT: " + indice);
        System.out.println("1 - Arqueiro / 2 - Guerreiro / 3 - Mago");
        Scanner teclado = new Scanner(System.in);
        boolean teste = false;
        do {
            String resp = teclado.nextLine();
            switch (resp) {
                case "1":
                    return new Personagem(8, 5, 5 , indice, 1);
                case "2":
                    return new Personagem( 15, 10, 1, indice, 2);
                case "3":
                    return new Personagem( 10, 7, 3, indice, 3);
                default: teste = true;
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(teste);
        return null;
    }

    protected boolean repetirJogo (){
        Scanner teclado = new Scanner(System.in);
        String resp = "";
        do {
            System.out.println("Quer jogar de novo?");
            System.out.println("1 - Jogar denovo  |  2 - Sair");
            resp = teclado.nextLine();
            switch (resp) {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }while(true);
    }
}
