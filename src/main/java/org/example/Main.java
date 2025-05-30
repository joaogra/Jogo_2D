package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Personagem jog1 = null, jog2=null;
        int tipo = menu.modoDeJogo();

        switch (tipo){
            case 1 , 2:
                jog1 = menu.seletordePersonagem(1);
                jog2 = menu.seletordePersonagem(2);
                break;

            case 3:
                return;
        }
        Jogo jogo = new Jogo();
        jogo.jogo(jog1, jog2);
    }

}

