package org.example;


import java.util.Scanner;

public class Menu {
    public int apresentacao (){
        System.out.println("blablablabla");
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

     public String seletordePersonagem (){
        System.out.println("Escolha seu personagem: ");
        System.out.println("1 - Arqueiro / 2 - Guerreiro / 3 - Mago");
        Scanner teclado = new Scanner(System.in);
        boolean teste = false;
        do {
            String resp = teclado.nextLine();
            switch (resp) {
                case "1":
                    return "1";
                case "2":
                    return "2";
                case "3":
                    return "3";
                default: teste = true;
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(teste);
    return "0";
    }
}
