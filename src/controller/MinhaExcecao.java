package controller;

public class MinhaExcecao extends Exception{
    public MinhaExcecao() {
        super("Erro, estoque insuficiente.");
    }
}
