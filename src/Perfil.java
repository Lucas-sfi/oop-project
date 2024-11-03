
import java.util.ArrayList;
import java.util.Scanner;

public class Perfil extends Usuario {

    private int quantidadeAmigos = 0;
    private String apelido;
    private boolean status;
    private String jogoAtual;
    private ArrayList<Integer> listaAmigos;  // Lista de IDs de amigos como inteiros
    private Scanner scanner;  // Scanner compartilhado para entrada do usuário

    public Perfil(String nome, String senha, String nascimento, String apelido, boolean status, String jogoAtual, Scanner scanner) {
        super(nome, senha, nascimento);
        this.apelido = apelido;
        this.status = status;
        this.jogoAtual = jogoAtual;
        this.listaAmigos = new ArrayList<>(); // Inicializa a lista de amigos
        this.scanner = scanner;
    }


    private int solicitarID(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt();
    }

    public void adicionarAmigo(ArrayList<Usuario> usuarios) {

        int idAmigo = solicitarID("Digite o ID do usuário que deseja adicionar como amigo: ");

        // Verifica se o ID já está na lista de amigos para evitar duplicatas
        if (listaAmigos.contains(idAmigo)) {
            System.out.println("Este usuário já está na sua lista de amigos.");
            return;
        }

        // Procura o usuário pelo ID na lista de usuários
        for (Usuario usuario : usuarios) {
            if (usuario.getID() == idAmigo) {
                listaAmigos.add(idAmigo);  // Adiciona o ID do amigo à lista de IDs
                quantidadeAmigos++;
                System.out.println("Amigo " + usuario.getNome() + " (ID: " + idAmigo + ") adicionado com sucesso!");
                return;
            }
        }

        // Caso o ID não seja encontrado
        System.out.println("Usuário com ID " + idAmigo + " não encontrado.");
    }

    public void removerAmigo() {
        int idAmigo = solicitarID("Digite o ID do amigo que deseja remover: ");
        if (listaAmigos.contains(idAmigo)) {
            listaAmigos.remove(Integer.valueOf(idAmigo));  // Remove o ID do amigo
            quantidadeAmigos--;
            System.out.println("Amigo com ID " + idAmigo + " removido com sucesso.");
        } else {
            System.out.println("Amigo com ID " + idAmigo + " não encontrado na sua lista de amigos.");
        }
    }

    public void setApelido(String novoApelido) {
        this.apelido = novoApelido;
        System.out.println("Seu novo apelido é: " + novoApelido);
    }

    public String getApelido() {

        return apelido;

    }

    // Buscar o nome pelo ID
    private String nomePorID(ArrayList<Usuario> usuarios, int idAmigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getID() == idAmigo) {
                return usuario.getNome();
            }
        }
        return null; //
    }

    public void exibirListaAmigos(ArrayList<Usuario> usuarios) {

        for(int i = 0; i < listaAmigos.size(); i++) {
            for (Usuario usuario : usuarios) {
                if (usuario.getID() == listaAmigos.get(i)) {
                    System.out.println("Nome: " + usuario.getNome() + " (ID: " + listaAmigos.get(i) + ")");
                }
            }
        }
    }

    public void exibirPerfil() {
        System.out.println("Perfil do usuário:");
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + iD);
        System.out.println("Apelido: " + apelido);
        System.out.println("Amigos: " + quantidadeAmigos);
        System.out.println("Status: " + (status ? "Online" : "Offline"));
        System.out.println("Jogo atual: " + (jogoAtual.isEmpty() ? "Nenhum" : jogoAtual));
        System.out.println("Lista de amigos: " + listaAmigos);
    }
}


