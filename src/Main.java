import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Perfil> perfis = new ArrayList<>();
    private static ArrayList<Colecao> Colecoes = new ArrayList<>();


    public static void main(String[] args) {

        //inicio programa
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        boolean loginValido = false;
        int qtdUsuarios = 0;

        do { // menu incial de login
            System.out.println("\nBem-Vindo ao sistema, escolha sua opção:");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Login");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu se cadastrar!");

                    System.out.print("Digite seu nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite sua senha: ");
                    String senha = scanner.nextLine();

                    System.out.print("Digite sua data de nascimento (ex: 01/01/2000): ");
                    String nascimento = scanner.nextLine();

                    //Verifique se o nome já existe antes de criar um novo usuário
                    if (usuarios.stream().anyMatch(u -> u.getNome().equals(nome))) {
                        System.out.println("Nome de usuário já existe. Tente outro nome.");
                    } else {

                        Usuario novoUsuario = new Usuario(nome, senha, nascimento);
                        usuarios.add(novoUsuario); // Adiciona o novo usuário à lista

                        System.out.println("\nUsuário criado com sucesso!");
                        qtdUsuarios ++;
                        System.out.println("Agora vamos criar um perfil para o seu usuário: " + novoUsuario.getNome());

                        Perfil perfilAtual = new Perfil(nome, senha, nascimento, "NULL", true, "nada", scanner);
                        perfis.add(perfilAtual);

                        System.out.println("Digite o apelido que deseja para seu perfil: ");
                        String apelido = scanner.nextLine().trim();
                        perfilAtual.setApelido(apelido);
                        novoUsuario.setID(qtdUsuarios);
                        System.out.println("Seu ID é: " + novoUsuario.getID());
                        break;
                    }

                case 2:
                    System.out.println("Você escolheu realizar o Login!");

                    System.out.print("Digite seu nome: ");
                    String loginNome = scanner.nextLine().trim();

                    System.out.print("Digite sua senha: ");
                    String loginSenha = scanner.nextLine().trim();

                    Perfil perfilLogado = new Perfil(null,null,null,null,true,null,null);

                    for (Perfil perfil : perfis) {
                        // Verifique a comparação para ver se o login é possivel ser realizado
                        if (perfil.getNome().equals(loginNome) && perfil.getSenha().equals(loginSenha)) {
                            System.out.println("Login realizado com sucesso! Bem-vindo, " + perfil.getNome());
                            loginValido = true;
                            perfilLogado = perfil;
                        }
                    }


                    if (loginValido) {
                        exibirMenuUsuario(perfilLogado);
                    } else {
                        System.out.println("Nome ou senha incorretos. Tente novamente.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while(opcao !=0);

        scanner.close();
    }

    private static void exibirMenuUsuario(Perfil perfil) {
        // Verifica se o usuário logado é um Perfil
        if (!(perfil instanceof Perfil)) {
            System.out.println("Erro: O usuário não é um perfil válido.");
            return;
        }

        Perfil perfilLogado = (Perfil) perfil; // Faz o cast do usuário para Perfil
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do { //mostra opçoes do menu de usuario
            System.out.println("\nMenu do Usuário: " + perfilLogado.getNome());
            System.out.println("1 - Exibir Perfil");
            System.out.println("2 - Adicionar amigo");
            System.out.println("3 - Ver amigos");
            System.out.println("4 - Ver biblioteca");
            System.out.println("5 - adicionar jogos");
            System.out.println("6 - remover jogos");
            System.out.println("7 - Criar Coleção / max 10");
            System.out.println("8 - Adicionar jogos na coleção");
            System.out.println("9 - Ver jogos de coleção");
            System.out.println("10 - Logout");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:

                    perfilLogado.exibirPerfil();

                    break;
                case 2:
                    System.out.print("Digite o nome do amigo que deseja adicionar: ");
                    String amigoNome = scanner.nextLine().trim();

                    // Procura o amigo na lista de usuários
                    Usuario amigoEncontrado = null;
                    for (Usuario u : usuarios) {
                        if (u.getNome().equals(amigoNome)) {
                            amigoEncontrado = u;
                            break;
                        }
                    }

                    // Adiciona o amigo, se encontrado
                    if (amigoEncontrado != null) {
                        perfilLogado.adicionarAmigo(usuarios); // Chama o método da instância do Perfil
                    } else {
                        System.out.println("Usuário com o nome " + amigoNome + " não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Amigos de " + perfilLogado.getNome() + ":");
                    perfilLogado.exibirListaAmigos(usuarios); // Exibe o perfil e amigos
                    break;

                case 4:
                     System.out.println("Lista de jogos:");
                    Biblioteca.mostarBibliotec();
                    break;

                case 5: // adiciona jogos a biblioteca

                    System.out.println("Qual o nome do jogo que será adicionado?");
                    String jogoNome = scanner.nextLine();

                    System.out.println("Qual sua Categoria?");
                    String categoria = scanner.nextLine();

                    System.out.println("Qual sua data de lançamento?");
                    String dataLancamento = scanner.nextLine();

                    System.out.println("Deseja tornar favorito?");
                    String tornarFavorito = scanner.nextLine();
                    boolean favorito = false;

                     if(tornarFavorito == "sim") {
                          favorito = true;
                     }



                     Biblioteca.adicionarJogoBiblioteca(jogoNome, categoria, dataLancamento, favorito);
                     System.out.println("Jogo" + jogoNome + " adicionado com sucesso!");
                     break;

                case 6:  // remove jogos da biblioteca
                    System.out.println("Qual o nome do jogo que deseja remover?");
                    String jogoNome2 = scanner.nextLine();


                    Biblioteca.removerJogo(jogoNome2);
                     break;

                case 7: // cria coleções
                    int counter = 0;
                    System.out.println("qual o nome da Coleção?");
                    String nomeColecao = scanner.nextLine();
                    System.out.println("Qual sua data de criação?");
                    String dataCriacao = scanner.nextLine();
                    System.out.println("Dê uma breve descrição");
                    String descricaoBreve = scanner.nextLine();

                    Colecao Temp = new Colecao(0,nomeColecao, dataCriacao, descricaoBreve);
                    Colecoes.add(Temp);
                    break;

                case 8:

                    if(Colecoes.isEmpty()){ //verifica se existe alguma coleção criada
                        System.out.println("Não existem coleções");
                        break;
                    }

                    else{
                        System.out.println("Qual coleção deseja Ver?");
                        String col = scanner.nextLine();

                        for (Colecao colecao : Colecoes) { // verifica se coleção existe
                            if(colecao.getNome().equals(col)) {
                                Colecao colecao2 = colecao;
                                System.out.println("Qual o nome do jogo que será adicionado?");
                                String jogoNome1 = scanner.nextLine();

                                System.out.println("Qual sua Categoria?");
                                String categoria2 = scanner.nextLine();

                                System.out.println("Qual sua data de lançamento?");
                                String dataLancamento2 = scanner.nextLine();

                                System.out.println("Deseja tornar favorito?");
                                String tornarFavorito2 = scanner.nextLine();
                                boolean favorito2 = false;

                                if(tornarFavorito2 == "sim") {
                                    favorito = true;
                                }

                                colecao2.adicionarJogo(jogoNome1, categoria2, dataLancamento2, favorito2);
                                System.out.println("Jogo" + jogoNome1 + " adicionado com sucesso!");

                            }
                            else{
                                System.out.println("Coleção não encontrada");
                            }
                        }
                    }



                    break;

                case 9:

                    if(Colecoes.isEmpty()){
                        System.out.println("Não existem coleções");
                        break;
                    }

                    else {
                        System.out.println("Qual coleção deseja Ver?");
                        String col = scanner.nextLine();

                        for (Colecao colecao : Colecoes) { // verifica se o nome da coleção existe
                            if(colecao.getNome().equals(col)) {
                                Colecao colecao1 = colecao;
                                colecao1.mostarColeçao();
                            }
                          else{
                              System.out.println("Coleção não encontrada!");
                            }

                        }
                                break;
                    }


                case 10:
                    System.out.println("Você saiu do menu do usuário.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 10); // Enquanto não escolher sair (logout)
    }
}







