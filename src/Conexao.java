
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conexao {
    private String url;
    private String usuario;
    private String senha;
    private Connection con;
    
    Conexao(){
        url = "jdbc:postgresql://localhost:5432/postgres";
        usuario = "postgres";
        senha = "9466";
        
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insereSQL(String sql){
        try {
            java.sql.Statement stm = con.createStatement();
            int res = stm.executeUpdate(sql);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public ResultSet executaBusca(){
        try {
            String sql = "Select * from cliente";
            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            con.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void delete(int id) {
	try {
            String sql = "DELETE FROM CLIENTE WHERE id =?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.execute();
            stm.close();
            //con.close();
            System.out.println("Cliente excluido");
            }catch(Exception e) {
		e.printStackTrace();
            }
	}
}
