package modelo;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Diego
 */
public class Acesso {
    private int id;
    private String dataAcesso;
    private String horaAcesso;
    private String nomeUsuario;

    public Acesso() {
     SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
     SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
     dataAcesso = sdf2.format(new Date());
     horaAcesso = sdf.format(new Date().getTime());
    }
    public Acesso(int id, String dataAcesso, String horaAcesso, String nomeUsuario) {
        this.id = id;
        this.dataAcesso = dataAcesso;
        this.horaAcesso = horaAcesso;
        this.nomeUsuario = nomeUsuario;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getDataAcesso() {return dataAcesso;}

    public void setDataAcesso(String dataAcesso){this.dataAcesso = dataAcesso;}

    public String getHoraAcesso() {return horaAcesso;}

    public void setHoraAcesso(String horaAcesso) {
        this.horaAcesso = horaAcesso;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    
}
