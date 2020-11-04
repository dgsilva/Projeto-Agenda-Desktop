
package dao;

//Você precisa ter essas importações 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class CriaConexao {
    //Criação do objeto Connection, caso de certo ele trará uma exceção
    public static Connection getConexao()throws SQLException{
       try{
           //Referencia ao Driver do bnaco utilizado
         Class.forName("org.postgresql.Driver");
         
           //Será exibido no console a mensagem caso, consiga acessa
           System.out.println("Conectando ao Banco");
           
           //Se a conexao for estabelecida, ele irá acessar o banco agendabd, usuario e senha
          return DriverManager.getConnection("jdbc:postgresql:agendabd", "postgres", "123456");
          
       }catch(ClassNotFoundException ex){
           throw new SQLException(ex.getMessage());
       }
           
    }

    
}
