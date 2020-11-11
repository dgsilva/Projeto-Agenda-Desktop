
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
}
