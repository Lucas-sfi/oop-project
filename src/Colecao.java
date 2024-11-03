import java.util.ArrayList;

public class Colecao extends Biblioteca {

    protected static ArrayList<Jogo> listaDeJogosColecao = new ArrayList<Jogo>();

    private final String nomeColecao;
    private String dataCriacao;
    private String descricaoColecao;

    public Colecao(int quantidadeDeJogos,String nomeColecao, String dataCriacao, String descricaoColecao) {
        super(quantidadeDeJogos);
        this.nomeColecao = nomeColecao;
        this.dataCriacao = dataCriacao;
        this.descricaoColecao = descricaoColecao;
    }

    public static void adicionarJogo(String nome, String Categoria, String dataLancamento, boolean favorito) {

        Jogo jogotemp = new Jogo(nome, Categoria,  dataLancamento, favorito);
        listaDeJogosColecao.add(jogotemp);

    }

    public void mostarColeçao(){ //mostra todos os jogos presentes na colecao

        if(listaDeJogosColecao.isEmpty()){
            System.out.println("Não há jogos na biblioteca!");
        }

        else {
            for (Jogo jogos : listaDeJogosColecao) {

                System.out.println("Lista de jogos");
                System.out.println(jogos.getNome() + "|" + jogos.getFavorito());
            }
        }

    }

    public void mudarDescricao(String descricaoNova) {

        this.descricaoColecao = descricaoNova;

    }

    public void setDataCriacao(String data) {

        this.dataCriacao = data;

    }

    public String getNome(){
        return this.nomeColecao;

    }

}