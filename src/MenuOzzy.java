import java.util.Scanner;

public class MenuOzzy {
    static final int MAX_USUARIOS = 10;
    static String[] usuarios = new String[MAX_USUARIOS];
    static int[] idades = new int[MAX_USUARIOS];
    static int acumulador = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("                 *BEM VINDO A OZZY*           ");
        System.out.print("Cadastre-se: ");
        System.out.print("Digite o número exato de cadastros: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        for (int i = 0; i < numero; i++) {
            System.out.print("Cadastre um novo usuário: ");
            String usuario = scanner.nextLine();
            System.out.print("Informe a Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            usuarios[acumulador] = usuario;
            idades[acumulador] = idade;
            acumulador++;
            System.out.println("O " + usuario + " foi cadastrado com sucesso!!");
        }

        if (acumulador >= numero) {
            System.out.println("Todos usuários cadastrados!!");
            System.out.println("Deseja acessar o menu?");
            System.out.print("Digite 1 para continuar ou 5 para sair: ");
            int escolhido = scanner.nextInt();

            if (escolhido == 1) {
                mostrarMenu();
            } else {
                System.out.println("Saindo do programa...");
            }
        }
    }

    public static void mostrarMenu() {
        while (true) {
            System.out.println("                            MENU               ");
            System.out.println("-> Digite 1 para cadastrar um novo usuário:");
            System.out.println("-> Digite 2 para listar todos os usuários cadastrados:");
            System.out.println("-> Digite 3 para buscar usuario:");
            System.out.println("-> Digite 4 para excluir usuario:");
            System.out.println("-> Digite 5 para sair:");
            int escolhido = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolhido) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    buscarUsuario();
                    break;
                case 4:
                    excluirUsuario();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

    public static void cadastrarUsuario() {
        if (acumulador < MAX_USUARIOS) {
            System.out.print("Cadastrar novo usuário: ");
            String usuario = scanner.nextLine();
            System.out.print("Informe a Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            usuarios[acumulador] = usuario;
            idades[acumulador] = idade;
            acumulador++;
            System.out.println("O " + usuario + " foi cadastrado com sucesso!!");
        } else {
            System.out.println("Capacidade máxima de usuários atingida.");
        }
    }

    public static void listarUsuarios() {
        System.out.println("Lista de todos os usuários cadastrados:");
        for (int i = 0; i < acumulador; i++) {
            System.out.println("Usuario: " + usuarios[i] + " / Idade: " + idades[i] + " anos");
        }
        System.out.println("O total de pessoas cadastradas é: " + acumulador);
    }

    public static void buscarUsuario() {
        System.out.print("Qual o usuario que deseja procurar? ");
        String usuaDes = scanner.nextLine();
        int indiceEncontrado = busca(usuaDes);

        if (indiceEncontrado >= 0) {
            System.out.println("Usuario encontrado: " + usuarios[indiceEncontrado] + " / Idade: " + idades[indiceEncontrado] + " anos");
        } else {
            System.out.println("Usuario nao encontrado");
        }
    }

    public static int busca(String pes) {
        for (int i = 0; i < acumulador; i++) {
            if (usuarios[i].equals(pes)) {
                return i;
            }
        }
        return -1;
    }

    public static void excluirUsuario() {
        System.out.print("Qual usuario deseja excluir? ");
        String exusu = scanner.nextLine();
        int indiceExcluir = busca(exusu);

        if (indiceExcluir >= 0) {
            usuarios[indiceExcluir] = "";
            idades[indiceExcluir] = 0;
            System.out.println("Usuario Removido!!");
        } else {
            System.out.println("Usuario não encontrado.");
        }
    }
}
