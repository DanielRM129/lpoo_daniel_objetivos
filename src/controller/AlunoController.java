package controller;

import model.Aluno;

import java.util.*;
import java.util.stream.Collectors;

public class AlunoController {
    public static void main(String[] args) {
        System.out.println("Exercicio1");
        System.out.println("\nInstâncias construtor padrão");
        Aluno aluno1 = new Aluno();
        System.out.println(aluno1);
        Aluno aluno2 = new Aluno();
        System.out.println(aluno2);
        System.out.println("\nInstâncias construtor parametrizado - todos atributos");
        Aluno aluno3 = new Aluno(1,"04343998096","Daniel","Rojhn Milgarejo","danielrojhn@gmail.com");
        System.out.println(aluno3);
        Aluno aluno4 = new Aluno(2,"40343899069","Ana Maria", "Medeiros","ana@gmail.com");
        System.out.println(aluno4);
        System.out.println("\nInstâncias construtor parametrizado - 2 atributos");
        Aluno aluno5 = new Aluno(3,"40343899000");
        System.out.println(aluno5);
        Aluno aluno6 = new Aluno(4,"40343899111");
        System.out.println(aluno6);

        aluno1.setNome("Ana Lucia");
        aluno1.setCpf("40343111111");
        aluno1.setEmail("analucia@gmail.com");
        aluno1.setSobrenome("Rojhn");
        aluno1.setId(5);

        aluno2.setNome("Ana Claudia");
        aluno2.setCpf("40343111000");
        aluno2.setEmail("anaclaudia@gmail.com");
        aluno2.setSobrenome("Robin");
        aluno2.setId(6);
        System.out.println("\nSetters e getters");
        System.out.println(aluno1.getCpf()+" "+
                aluno1.getEmail()+" "+
                aluno1.getId()+" "+
                aluno1.getNome()+" "+
                aluno1.getSobrenome());

        System.out.printf("%s %s %d %s %s", aluno2.getCpf(),
        aluno2.getEmail(),
        aluno2.getId(),
        aluno2.getNome(),
        aluno2.getSobrenome());

        System.out.println("\n \nExercicio2");
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno3);
        alunos.add(aluno4);
        alunos.add(aluno5);
        alunos.add(aluno6);
        alunos.add(aluno1);
        alunos.add(aluno2);
        System.out.println(alunos);

        Map<Integer, Aluno> alunosMap = new HashMap<>();
        alunosMap.put(aluno3.hashCode(), aluno3);
        alunosMap.put(aluno4.hashCode(), aluno4);
        alunosMap.put(aluno5.hashCode(), aluno5);
        alunosMap.put(aluno6.hashCode(), aluno6);
        alunosMap.put(aluno1.hashCode(), aluno1);
        alunosMap.put(aluno2.hashCode(), aluno2);
        System.out.println(alunosMap);
        System.out.println("\nOrdem decrescente");
        alunos = alunos.stream()
                .sorted(Comparator.comparing(Aluno::getId).reversed()).collect(Collectors.toList());
        System.out.println(alunos);
        System.out.println("\nid5 list");
        alunos.forEach(a -> {
            if (a.getId() == 5)
                System.out.println(a);
        });
        System.out.println("\nid5 map");
        System.out.println(alunosMap.get(5));


    }

}
