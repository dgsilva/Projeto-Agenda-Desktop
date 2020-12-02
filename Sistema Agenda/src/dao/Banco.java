
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Contato;


/**
 *
 * @author Diego
 */
public class Banco {
   private Connection conexao;
   
   public Banco()throws Exception{
       this.conexao = CriaConexao.getConexao();
   }
   
   public void adicionarContato(Contato ctt)throws SQLException{
     String sql = "insert into agenda(nome,endereco,telefone,email,sexo)"+
             "values(?,?,?,?,?)";
       PreparedStatement stmt= conexao.prepareStatement(sql);
       stmt.setString(1,ctt.getNome());
       stmt.setString(2,ctt.getEndereco());
       stmt.setString(3,ctt.getTelefone());
       stmt.setString(4,ctt.getEmail());
       stmt.setString(5,ctt.getSexo());
       stmt.execute();
       stmt.close();
   }
   
   public Contato consultarporId(int id)throws Exception{
       Contato c = new Contato();
       String pesq = ("select * from agenda where id= ?");
       PreparedStatement stmt = this.conexao.prepareStatement(pesq);
       stmt.setInt(1, id);
       ResultSet rs = stmt.executeQuery();
       if(rs.next()){
           c.setIdContato(Integer.parseInt(rs.getString("id")));
           c.setNome(rs.getString("nome"));
           c.setEndereco(rs.getString("endereco"));
           c.setEmail(rs.getString("email"));
           c.setTelefone(rs.getString("telefone"));
           c.setSexo(rs.getString("sexo"));
           rs.close();
                 
       }
       return c;
   }
   
    public Contato consultarporNome(String nome)throws Exception{
       Contato c = new Contato();
       String pesq = ("select * from agenda where nome= ?");
       PreparedStatement stmt = this.conexao.prepareStatement(pesq);
       stmt.setString(1, nome);
       ResultSet rs = stmt.executeQuery();
       if(rs.next()){
           c.setIdContato(Integer.parseInt(rs.getString("id")));
           c.setNome(rs.getString("nome"));
           c.setEndereco(rs.getString("endereco"));
           c.setEmail(rs.getString("email"));
           c.setTelefone(rs.getString("telefone"));
           c.setSexo(rs.getString("sexo"));
           rs.close();
       }
       return c;
   }
}
   
