package org.example;


import java.util.Scanner;

public class Menu {
    public int modoDeJogo (){
        System.out.println("Olá, seja bem vindo ao:");
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
        System.out.println("Escolha seu modo de jogo:");
        System.out.println("1 - Player vs Player | 2 - Player vs Bot | 3 - Sair" );
        Scanner teclado = new Scanner(System.in);
        boolean teste = false;
        do {
            String resp = teclado.nextLine();
            switch (resp) {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                default: teste = true;
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(teste);
        return 0;
    }

     public Personagem seletordePersonagem (String indice){
        System.out.println("Escolha seu personagem: ");
        System.out.println("1 - Arqueiro / 2 - Guerreiro / 3 - Mago");
        Scanner teclado = new Scanner(System.in);
        boolean teste = false;
        do {
            String resp = teclado.nextLine();
            switch (resp) {
                case "1":
                    return new Personagem("Arqueiro", 8, 5, 5 , indice, 1);
                case "2":
                    return new Personagem("Guerreiro", 15, 10, 1, indice, 2);
                case "3":
                    return new Personagem("Mago", 10, 7, 3, indice, 3);
                default: teste = true;
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(teste);
    return null;
    }
    public boolean repetir (){
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
        }while(!(resp.equals("1") || resp.equals("2")));
        return false;
    }
}
