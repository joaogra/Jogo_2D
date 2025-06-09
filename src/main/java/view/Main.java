package view;

import org.inGame.Jogo;
import org.inGame.Personagem;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Jogo jogo = new Jogo();
        Personagem jog1 = null, jog2 = null;
        do {

            switch (menu.modoDeJogo()) { // Define o modo de jogo
                case 1: // Player vs Player
                    jog1 = menu.seletordePersonagem("P1");
                    jog2 = menu.seletordePersonagem("P2");
                    jogo.jogoMultiPlayer(jog1, jog2);
                    break;
                case 2: // Player vs Bot
                    jog1 = menu.seletordePersonagem("P1");
                    jog2 = menu.seletordePersonagemBot("P2");
                    jogo.jogoBot(jog1, jog2);
                    break;
                case 3: // Sair
                    return;
            }
        } while (menu.repetirJogo());
    }
}

