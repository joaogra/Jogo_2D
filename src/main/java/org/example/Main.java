package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Personagem arqueiro = new Personagem("arqueiro", 8, 5, 5 );
        Personagem guerreiro = new Personagem("guerreiro" ,15 , 10, 1 );
        Personagem mago = new Personagem("mago", 10, 7, 3);
        int var1;
        Menu menu = new Menu();
        var1=menu.apresentacao();
        String escolha1=menu.seletordePersonagem();
        String escolha2 =menu.seletordePersonagem();
        TipoJogo tipodeJogo = new TipoJogo(definePersonagem(arqueiro,guerreiro,mago,escolha1),definePersonagem(arqueiro,guerreiro,mago,escolha2));
    }

    public static  Personagem definePersonagem(Personagem arqueiro, Personagem guerreiro , Personagem mago, String x){
        switch (x){
            case "1": return  arqueiro;
            case "2": return guerreiro;
            case "3": return mago;
            default: return null;
        }

    }
}

