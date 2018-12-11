package model.dao;


import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EmpregadoAssalariado;
import model.database.DatabaseMySQL;

/**
 *
 * @author cassioseffrin
 */
public final class EmpregadoAssalariadoDAO {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public EmpregadoAssalariadoDAO() {
        Connection con = DatabaseMySQL.getConnection();
        setConnection((com.mysql.jdbc.Connection) con);
    }

    public boolean inserir(EmpregadoAssalariado ea) {
        String sql = "INSERT INTO empregadoAssalariado( nome,  cpf ) VALUES(?,?)";
//        String sql = "INSERT INTO empregadoAssalariado(   nome,  sobreNome,  cpf,  sexo,  salarioMensal) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ea.getNome());
//            stmt.setString(2, ea.getSobreNome());
            stmt.setString(2, ea.getCpf());
//            stmt.setString(4, empregadoAssalariado.getSexo());
//            stmt.setDouble(5, empregadoAssalariado.getSalarioMensal());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpregadoAssalariadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer id) {
        String sql = "DELETE FROM empregadoAssalariado WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpregadoAssalariadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<EmpregadoAssalariado> listar() {
        String sql = "SELECT * FROM empregadoAssalariado";
        List<EmpregadoAssalariado> lista = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                EmpregadoAssalariado ea = new EmpregadoAssalariado();
                ea.setCodigo(resultado.getInt("codigo"));
                ea.setNome(resultado.getString("nome"));
                ea.setSobreNome(resultado.getString("sobrenome"));
            
                lista.add(ea);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpregadoAssalariadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean atualizar(EmpregadoAssalariado empregadoAssalariadoSelecionado) {
        String sql = "UPDATE empregadoAssalariado SET nome=?  WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, empregadoAssalariadoSelecionado.getNome());
    
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpregadoAssalariadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
