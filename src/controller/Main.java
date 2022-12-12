package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
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
        Item i3 = new Item(3,0.00,1,p2);
        Item i4 = new Item(4,0.00,1,p2);
        pe2.getItems().add(i3);
        pe2.getItems().add(i4);

        List<Pedido> vendas = new ArrayList<>();
        vendas.add(pe1);
        vendas.add(pe2);

        vendas.forEach(a -> {
            double acum = 0;
            for (int i = 0; i < a.getItems().size(); i++) {
                acum += a.getItems().get(i).getProduto().getPreco();
            }
            System.out.println(a);
            a.getItems().forEach(x -> {System.out.println(x);System.out.println(x.getProduto());});
            System.out.println(a.getVendedor());
            System.out.println("Total do pedido: "+ acum);
        } );
        System.out.println("\nExercicio c");

        Fornecedor f1 = new Fornecedor(1,"xyz","Rafael");
        Produto p3 = new Produto(3,"Borracha",2,0.50);
        Fornecimento fo1 = new Fornecimento(LocalDate.now(), 1,f1,p3);
        p3.getFornecedors().add(f1);

        Fornecedor f2 = new Fornecedor(2,"xyz","Leonel");
        Produto p4 = new Produto(4,"Giz",2,0.20);
        Fornecimento fo2 = new Fornecimento(LocalDate.now(), 0.40,f2,p4);
        p4.getFornecedors().add(f2);

        List<Fornecimento> estoque = new ArrayList<>();
        estoque.add(fo1);
        estoque.add(fo2);
        var ref = new Object() {
            double acum_est = 0;
        };

        estoque.forEach(b -> {
            ref.acum_est += b.getValorTotal();

            System.out.println(b);
            System.out.println(b.getFornecedor());
            System.out.println(b.getProduto());
            System.out.println("Total de fornecimentos: "+ ref.acum_est);
        } );

    }
}