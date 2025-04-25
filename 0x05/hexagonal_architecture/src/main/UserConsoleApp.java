// Interface de entrada (Teste via console)
package main;
import adapters.InMemoryUserRepository;
import domain.User;
import domain.UserService;

import java.util.Scanner;
import java.util.List;


public class UserConsoleApp {
    public static void main(String[] args) {
        UserService userService = new UserService(new InMemoryUserRepository());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Criar usuário\n2. Buscar usuário\n3. Listar usuários\n4. Sair");
            System.out.print("Escolha uma opção: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine().trim();
                    System.out.print("Nome: ");
                    String name = scanner.nextLine().trim();
                    userService.createUser(id, name);
                    System.out.println("Usuário criado com sucesso!");
                    break;
                case 2:
                    System.out.print("ID do usuário: ");
                    String searchId = scanner.nextLine().trim();
                    User user = userService.getUser(searchId);
                    if (user != null) {
                        System.out.println("Usuário encontrado: " + user.getName());
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Lista de usuários:");
                    List<User> users = userService.listUsers();
                    for (User u : users) {
                        System.out.println(u.getId() + " - " + u.getName());
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
