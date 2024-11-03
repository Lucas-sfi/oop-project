import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Biblioteca {

    protected int quantidadeDeJogos;
    protected static ArrayList <Jogo> listaDeJogos = new ArrayList<Jogo>();

    public Biblioteca(int quantidadeDeJogos){
        this.quantidadeDeJogos = quantidadeDeJogos;
    }

    public Biblioteca(){

    }


    public void setQuantidadeDeJogos(int quantidadeJogos) {

        this.quantidadeDeJogos = quantidadeJogos;

    }

    public void ordenarJogos() {

        Collections.sort(listaDeJogos, new Comparator<Jogo>() {
            public int compare(Jogo j1, Jogo j2) {
                return j1.getNome().compareTo(j2.getNome());

            }
        });
    }


    public static void mostarBibliotec(){ //mostra todos os jogos presentes na biblioteca

        if(listaDeJogos.isEmpty()){
            System.out.println("Não há jogos na biblioteca!");
        }

        else {
            for (Jogo jogos : listaDeJogos) {

                System.out.println("Lista de jogos");
                System.out.println(jogos.getNome() + "|" + jogos.getFavorito());
            }
        }

    }



    public void favoritarJogo(String nome) {

        for (int i = 0; i < listaDeJogos.size(); i++) {

            if (listaDeJogos.get(i).getNome().equals(nome)) {

                listaDeJogos.get(i).setFavorito(true);

            }

        }

    }

    public void desfavoritarJogo(String nome) {

        for (int i = 0; i < listaDeJogos.size(); i++) {

            if (listaDeJogos.get(i).getNome().equals(nome)) {

                listaDeJogos.get(i).setFavorito(false);

            }

        }

    }

    public boolean buscarJogoPorNome(String nome) {

        boolean possui = false;

        for (int i = 0; i < listaDeJogos.size(); i++) {

            if (listaDeJogos.get(i).getNome().equals(nome)) {

                possui = true;

            }

        }

        return possui;

    }

    public static void adicionarJogoBiblioteca(String nome, String Categoria, String dataLancamento, boolean favorito) {

        Jogo jogotemp = new Jogo(nome, Categoria,  dataLancamento, favorito);
        listaDeJogos.add(jogotemp);

    }

    public static void removerJogo(String nome) {

        for (int i = 0; i < listaDeJogos.size(); i++) {

            if (listaDeJogos.get(i).getNome().equals(nome)) {

                listaDeJogos.remove(i);
                System.out.println("Jogo removido com sucesso!");
            }

            else {
                System.out.println("Não foi possivel localizar o jogo");
            }
            }
        }

    }

