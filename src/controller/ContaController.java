package controller;

import model.Associado;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ContaController {
    public static void main(String[] args) {
        System.out.println("\nExercicio A");
        ContaPoupanca cp1 = new ContaPoupanca(1000);
        System.out.println(cp1);
        ContaCorrente cc1 = new ContaCorrente(1000);
        System.out.println(cc1);
        Associado a1 = new Associado("Daniel");
        System.out.println(a1);

        ContaPoupanca cp2 = new ContaPoupanca(2000);
        System.out.println(cp2);
        ContaCorrente cc2 = new ContaCorrente(2000);
        System.out.println(cc2);
        Associado a2 = new Associado("Rafael");
        System.out.println(a2);

        ContaPoupanca cp3 = new ContaPoupanca(3000);
        System.out.println(cp3);
        ContaCorrente cc3 = new ContaCorrente(3000);
        System.out.println(cc3);
        Associado a3 = new Associado("Alex");
        System.out.println(a3);

        System.out.println("\nExercicio B");
        List<Conta> contas = new ArrayList<>();
        contas.add(cp1);
        contas.add(cp2);
        contas.add(cp3);
        contas.add(cc1);
        contas.add(cc2);
        contas.add(cc3);

        List<ContaPoupanca> contaPoupancas = new ArrayList<>();
        contaPoupancas.add(cp1);
        contaPoupancas.add(cp2);
        contaPoupancas.add(cp3);
        System.out.println(contaPoupancas);

        List<ContaCorrente> contaCorrentes = new ArrayList<>();
        contaCorrentes.add(cc1);
        contaCorrentes.add(cc2);
        contaCorrentes.add(cc3);
        System.out.println(contaCorrentes);

        List<Associado> associados = new ArrayList<>();
        associados.add(a1);
        associados.add(a2);
        associados.add(a3);
        System.out.println(associados);

        System.out.println("\nExercicio C");
        cp1.deposita(1000);
        cp1.atualiza(5);
        cp1.saca(50);

        System.out.println("\nExercicio D");
        cc1.deposita(500);
        cc1.saca(400);

        System.out.println("\nExercicio E");
        cc1.lucros(100,1);
        cc2.lucros(400,1);
        cc3.lucros(600,1);
        a1.lucros(300,1);
        a2.lucros(600,1);
        a3.lucros(600,1);
        System.out.println(contaCorrentes);
        System.out.println(associados);

        System.out.println("\nExercicio F");
        associados= associados.stream()
                .sorted(Comparator.comparing(Associado::getNumeroCota).reversed()).collect(Collectors.toList());
        System.out.println(associados);

        System.out.print("\n\nAssociado com maior número de cotas: ");

        Optional a_maior_cota = associados.stream().max(Comparator.comparing(Associado::getNumeroCota));
        System.out.println(a_maior_cota.get());

        System.out.println("\nExercicio G");
        contaCorrentes= contaCorrentes.stream()
                .sorted(Comparator.comparing(ContaCorrente::getSaldo).reversed()).collect(Collectors.toList());
        System.out.println(contaCorrentes);
        contaPoupancas= contaPoupancas.stream()
                .sorted(Comparator.comparing(ContaPoupanca::getSaldo).reversed()).collect(Collectors.toList());
        System.out.println(contaPoupancas);

        Optional maior_saldo = contas.stream().max(Comparator.comparing(Conta::getSaldo));
        System.out.println(maior_saldo);

    }
}
