package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Jogo jogo = new Jogo();
        Personagem jog1 = null, jog2 = null;
        do {

            switch (menu.modoDeJogo()) {
                case 1:
                    jog1 = menu.seletordePersonagem("P1");
                    jog2 = menu.seletordePersonagem("P2");
                    jogo.jogo(jog1, jog2);
                    break;
                case 2:
                    jog1 = menu.seletordePersonagem("P1");
                    jog2 = menu.seletordePersonagemBot("P2");
                    jogo.jogoBot(jog1, jog2);
                    break;
                case 3:
                    return;
            }
        } while (menu.repetir());
    }

}

