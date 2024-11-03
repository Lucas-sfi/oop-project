import java.util.Scanner;

public class Assinante extends Perfil {

    private String validadeAssinatura; // Mantendo como String
    private boolean acessoJogos;

    public Assinante(String nome, String senha, String nascimento, String apelido, boolean status, String jogoAtual, Scanner scanner, String validadeAssinatura, boolean acessoJogos) {
        super(nome, senha, nascimento, apelido, status, jogoAtual, scanner);
        this.validadeAssinatura = validadeAssinatura;
        this.acessoJogos = acessoJogos;
    }

    public void criarAssinatura() {
        // Define a validade da assinatura como um ano a partir da data atual
        validadeAssinatura = "2024-10-31"; // Defina a validade inicial como desejado. Exemplo: 1 ano a partir de hoje.
        acessoJogos = true; // Usuário tem acesso a todos os jogos
        System.out.println("Assinatura criada com sucesso! Você agora tem acesso a todos os jogos.");
        System.out.println("Validade da assinatura: " + validadeAssinatura);
    }

    public void renovarAssinatura() {
        String[] partesData = validadeAssinatura.split("-");
        int ano = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int dia = Integer.parseInt(partesData[2]);

        // Adiciona 1 ano à validade
        ano += 1;

        // Forma a nova data de validade
        validadeAssinatura = String.format("%04d-%02d-%02d", ano, mes, dia);
        System.out.println("Assinatura renovada. Nova validade: " + validadeAssinatura);
    }

    public String getValidadeAssinatura() {
        return validadeAssinatura;
    }

    public boolean isAcessoJogos() {
        return acessoJogos;
    }

    public void setAcessoJogos(boolean acessoJogos) {
        this.acessoJogos = acessoJogos;
    }
}
