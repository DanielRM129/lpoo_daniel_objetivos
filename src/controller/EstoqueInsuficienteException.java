package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstoqueInsuficienteException {
    public static void main(String[] args) {
        System.out.println("\nExercicio b");
        System.out.println("\nVenda = itens vendidos + produtos do item," +
                " pedido, total pedido,vendedor");

        Vendedor v1 = new Vendedor(1,"Daniel","Saturnino Arruda","Fragata","000000000","Pelotas","RS","CASA");
        Pedido pe1 = new Pedido(1, LocalDate.now(),2,v1);
        Produto p1 = new Produto(1,"Lapis",2,1);
        Item i1 = new Item(1,0.00,1,p1);
        Item i2 = new Item(2,0.00,1,p1);
        pe1.getItems().add(i1);
        pe1.getItems().add(i2);

        Vendedor v2 = new Vendedor(2,"Daniela","Saturnino Arruda","Fragata","000000000","Pelotas","RS","CASA");
        Pedido pe2 = new Pedido(2, LocalDate.now(),3,v2);
        Produto p2 = new Produto(2,"Caneta",2,1.50);
        Item i3 = new Item(3,0.00,3,p2);
        Item i4 = new Item(4,0.00,1,p2);
        pe2.getItems().add(i3);
        pe2.getItems().add(i4);

        List<Pedido> vendas = new ArrayList<>();
        vendas.add(pe1);
        vendas.add(pe2);

        vendas.forEach(a -> {
            double acum = 0;
            for (int i = 0; i < a.getItems().size(); i++) {
                if(a.getItems().get(i).getQuantidade() > a.getItems().get(i).getProduto().getQuantidade()){
                    mythrowException();
                    System.out.println("Quantidade de itens do pedido:"+ a.getItems().get(i).getQuantidade());
                    System.out.println("Quantidade de itens em estoque:"+ a.getItems().get(i).getProduto().getQuantidade());
                }
            }
        } );
    }

    private static void mythrowException() {
        try {
            System.err.println("Tentou executar o bloco try, mas lança a MinhaExcecao");
            throw new MinhaExcecao();
        } catch (MinhaExcecao e) {
            e.printStackTrace();
        } finally {
            System.err.println("Finally executado em mythrowException()");
        }
    }
}
