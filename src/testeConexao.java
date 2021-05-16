import java.sql.ResultSet;

public class testeConexao {
    public static void main(String[] ags){
        Conexao con = new Conexao();
        
         /*String sql = "INSERT into cliente (id, nome, email)" + 
                           "values (default, 'Lucas Silva', " +
                           " 'lucas.silva@gmail.com')";
        int res = con.insereSQL(sql);
        if (res > 0){
              System.out.println("Cadastro realizado com sucesso");
       }else{
              System.out.println("Erro durante o Cadastro");
       }*/
        con.delete(4);
        ResultSet rs = con.executaBusca();
        try {
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                System.out.println(id+"-"+nome+"-"+email);
            }
        }catch (Exception e){
              e.printStackTrace();
          }
        
    }
    
}
