import java.io.*;

public class GerenciamentoArquivos {

    private static final String nomeArq = "usuarios.txt";

    private GerenciamentoArquivos() {
    }

    public static boolean realizarLogin(int id, String senha) {
        try {

            FileReader ent = new FileReader(nomeArq);
            BufferedReader br = new BufferedReader(ent);
            String linha;
            String[] campos = null;

            while ((linha = br.readLine()) != null) {

                campos = linha.split(";");
                if (campos[0].equals(id) && campos[2].equals(senha))
                    System.out.println("Login Realizado com sucesso!");

                return true;
            }
            System.out.println("Login Nao Realizado!");

            br.close();
        } catch (IOException erro) {
            System.out.println(" Erro na leitura dos dados ");
        }
        return false;

    }




      public static boolean cadastrarUsuario(Usuario usuario){
          System.out.println("teste");
        if (VerificarUsuario(usuario.getID())) {
              System.out.println("Erro: O ID já está cadastrado.");
              System.out.println("teste");
              return false;
          }


       try{
            FileWriter arq = new FileWriter("usuarios.txt", true);
            BufferedWriter bw = new BufferedWriter(arq);
            bw.write(usuario.getID() + ";" + usuario.getNome() + ";" + usuario.getSenha() + ";" + usuario.getNascimento());
            bw.newLine();
            bw.flush();
            System.out.println("Cadastrado com sucesso!");
            return true;

       }
         catch(IOException erro){
           System.out.println("Erro na leitura do arquivo");
           return false;
         }
      }

 public static boolean VerificarUsuario(int id){
    try {

        FileReader ent = new FileReader("usuarios.txt");
        BufferedReader br = new BufferedReader(ent);
        String linha;
        String[] campos = null;

        while ((linha = br.readLine()) != null) {

            campos = linha.split(";");
            if(Integer.parseInt(campos[0]) == id) {
                return true;
            }
        }


        br.close();
    }
    catch (IOException erro){
        System.out.println ( " Erro na leitura dos dados " );
    }
     return false;
 }

}
