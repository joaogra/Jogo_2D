package org.example;

public class Personagem {
    private String nome;
    private int forcaAtaque, forcaDefesa, alcance, pontoVida;

    public Personagem(String nome, int forcaAtaque, int forcaDefesa, int alcance){
        pontoVida = 100;
        this.forcaAtaque=forcaAtaque;
        this.forcaDefesa=forcaDefesa;
        this.alcance=alcance;
    }


    public int getForcaAtaque(){
        return forcaAtaque;
    }

    public int getForcaDefesa(){
        return forcaDefesa;
    }

    public int getAlcance(){
        return alcance;
    }

    public void defineNome(String s){
        nome = s;
    }
    public void imprimeNome(){
        System.out.println("Seu nome é: " + nome);
    }
}
