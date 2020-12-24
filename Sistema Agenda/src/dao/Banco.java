
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Acesso;
import modelo.Contato;
import modelo.Login;



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
       stmt.setString(1,ctt.getNome().toUpperCase());
       stmt.setString(2,ctt.getEndereco().trim());
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
 public void excluirContato(int id)throws Exception{
      String sql = ("delete from agenda where id = '" + id + "'");
      PreparedStatement stmt = this.conexao.prepareStatement(sql);
      stmt.execute();
      stmt.close();   
 }
  
   public void alterarContato(Contato ctt)throws Exception{
      String sql = ("update agenda set nome=?,endereco=?,telefone=?"
              + ",email=?,sexo=? where id=?");
      PreparedStatement stmt = this.conexao.prepareStatement(sql);
      stmt.setString(1, ctt.getNome());
      stmt.setString(2, ctt.getEndereco());
      stmt.setString(3, ctt.getTelefone());
      stmt.setString(4, ctt.getEmail());
      stmt.setString(5, ctt.getSexo());
      stmt.setInt(6, ctt.getIdContato());
      stmt.execute();
      stmt.close();  
  }
   
   public void EntradaAcesso(String nome_usuario)throws SQLException{
       String sql = "insert into acesso(nome_usuario,data_acesso,hora_acesso)"
               +"values(?,?,?)";
        Acesso acesso = new Acesso();
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome_usuario);
        stmt.setString(2,acesso.getDataAcesso());
        stmt.setString(3, acesso.getHoraAcesso());
        stmt.execute();
        stmt.close();
   }
   
   public boolean ValidarLogin(String nomeUsuario,String senha)throws Exception{
       boolean autenticado = false;
       String sql = "select * from login where nome_usuario =? and senha =?";
       PreparedStatement stmt = conexao.prepareStatement(sql);
       stmt.setString(1, nomeUsuario);
       stmt.setString(2, senha);
       ResultSet rs = stmt.executeQuery();
       if(rs.next()){
           Login login = new Login();
           login.setNomeUsuario(rs.getString("nome_usuario"));
           login.setSenha(rs.getString("senha"));
           autenticado = true;
           EntradaAcesso(nomeUsuario);    
       }
       rs.close();
       stmt.close();
       return autenticado;
       
   }
 
}
   
