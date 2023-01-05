package control;

import java.util.Scanner;

import dao.VeterinarioDAO;
import model.Veterinario;

public class VeterinarioController {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao = 0;
        do {
            System.out.print("\n\"-------  MENU veterinario -------\"");
            System.out.print(
                    "\n1. Inserir novo veterinario" +
                            "\n2. Atualizar um veterinario" +
                            "\n3. Listar todos os veterinarios" +
                            "\n4. Buscar veterinario pelo código" +
                            "\n5. Excluir um veterinario" +
                            "\nOpção (Zero p/sair): ");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    inserir();
                    break;
                case 2:
                    atualizar();
                    break;
                case 3:
                    selectVeterinarios();
                    break;
                case 4:
                    selectVeterinariosById();
                    break;
                case 5:
                    excluir();
                    break;
                default:
                    if (opcao != 0)
                        System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

    }

    //opção 1
    private static void inserir() {
        Veterinario veterinario = new Veterinario();
        System.out.println("\n++++++ Cadastro de novo Veterinario ++++++");
        System.out.print("Digite o nome do veterinario: ");
        veterinario.setNom_vet(input.nextLine());
        System.out.print("\nDigite o Endereço do veterinario: ");
        veterinario.setEnd_vet(input.nextLine());
        System.out.print("\nDigite o Telefone do veterinario: ");
        veterinario.setTel_vet(input.nextLine());

        if(VeterinarioDAO.insertVeterinario(veterinario)) {
            System.out.println("\nVeterinario salvo com sucesso.");
        }else {
            System.out.println("\nHouve um erro ao salvar o veterinario. Por favor, contate o administrador do sistema.");
        }
    }

    //opção 2
    private static void atualizar() {
        System.out.println("\n++++++ Alterar um Veterinario ++++++");
        Veterinario veterinario = null;
        int opcao = 0;
        do{
            System.out.print("\nDigite o código do veterinario (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else {
                veterinario = VeterinarioDAO.selectVeterinarioById(codigo);
                if(veterinario == null){
                    System.out.println("Código inválido.");
                }else{
                    System.out.println("Nome: " + veterinario.getNom_vet());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo nome do veterinario: ");
                        veterinario.setNom_vet(input.nextLine());
                    }
                    System.out.println("Endereço: " + veterinario.getEnd_vet());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo Endereço do veterinario: ");
                        veterinario.setEnd_vet(input.nextLine());
                    }
                    System.out.println("Telefone: " + veterinario.getTel_vet());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo Telefone do veterinario: ");
                        veterinario.setTel_vet(input.next());
                    }

                    if(VeterinarioDAO.updateVeterinario(veterinario)){
                        System.out.println("veterinario salvo:" + veterinario);
                    }else{
                        System.out.println("Erro ao tentar salvar o veterinario. Por favor, contate o adminstrador.");
                    }
                    opcao = 1;
                }

            }
        }while(opcao != 0);
    }

    //opção 3
    private static void selectVeterinarios() {
        System.out.println("\nLista de veterinarios cadastrados no banco de dados:\n" + VeterinarioDAO.selectVeterinarios());
    }

    //opção 4
    private static void selectVeterinariosById() {
        System.out.print("\nDigite o código do veterinario: ");
        Veterinario veterinario = VeterinarioDAO.selectVeterinarioById(input.nextLong());
        input.nextLine();
        if(veterinario != null){
            System.out.println(veterinario);
        }else{
            System.out.println("Código não localizado.");
        }
    }

    //opção 5

    private static void excluir() {
        System.out.println("\n++++++ Deletar um Veterinario ++++++");
        Veterinario veterinario = null;
        int opcao = 0;
        do{
            System.out.print("\nDigite o código do veterinario (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else {
                veterinario = VeterinarioDAO.selectVeterinarioById(codigo);
                if(veterinario == null){
                    System.out.println("Código inválido.");
                }else{
                    if(VeterinarioDAO.deleteVeterinario(codigo)){
                        System.out.println("veterinario excluido:" + veterinario);
                    }else{
                        System.out.println("Erro ao tentar excluir o veterinario. Por favor, contate o adminstrador.");
                    }
                    opcao = 1;
                }

            }
        }while(opcao != 0);
    }
}//fim classe
