/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import pacote.Cliente;
import pacote.Datalog;
import pacote.Funcionario;

/**
 *
 * @author hednisk
 */
public class DaoCliente {
  
   private Connection con=null;
   private Statement comando;  
  PreparedStatement ptmt = null;
	ResultSet resultSet = null;
   public List<Cliente> busca(String s,String tipo) throws SQLException {
        String query;
        if(tipo.equals("cpf"))
             query = "SELECT * FROM cliente where cpf="+ s;
        else//palavra
             query = "SELECT * FROM cliente WHERE nome LIKE '%"+s+"%' OR email LIKE '%"+s+"%' or login LIKE '%"+s+"%'";
        List<Cliente> lista = new ArrayList<>();
            try {
                con = ConnectionFactory.getConnection();
                ptmt = con.prepareStatement(query);
                resultSet= ptmt.executeQuery();
                
                while(resultSet.next()){  //idCliente,idEndereco,login, senha, nome, cpf,dataNascimento, Sexo,email, telefone, celular,status
                    Cliente f = new Cliente();
                    //f.setLogin(resultSet.getString("login"));
                   // f.setSenha(resultSet.getString("senha"));
                    f.setNome(resultSet.getString("nome"));
                    f.setCpf(resultSet.getString("cpf"));
                     f.setIdCliente(resultSet.getInt("idCliente"));
                   // f.setCpf(resultSet.getString("dataNascimento"));
                   // f.setSexo(resultSet.getString("sexo"));
                    f.setEmail(resultSet.getString("email"));
                   // f.setEmail(resultSet.getString("telefone"));
                   // f.setEmail(resultSet.getString("celular"));
                   // f.setEmail(resultSet.getString("status"));

                    lista.add(f);  
                }  
            }finally {       
            }
                return lista;  
            
        }  
   public void add(Cliente cli) {
		try {
			String query = "INSERT INTO Cliente(nome, login, senha, cpf, email, telefone, celular, status) VALUES(?,?,?,?,?,?,?,?)";
			con = ConnectionFactory.getConnection();
			ptmt = con.prepareStatement(query);
			//ptmt.setInt(1, cli.getRollNo());
                        ptmt.setString(1, cli.getNome());
			ptmt.setString(2, cli.getLogin());
			ptmt.setString(3, cli.getSenha());
			ptmt.setString(4, cli.getEmail());
                        ptmt.setString(5, cli.getTelefone());
                        ptmt.setString(6, cli.getCelular());
                        ptmt.setBoolean(7, cli.getStatus());
                        
			ptmt.executeUpdate();
			System.out.println("Data Adicionada!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
//                List<Datalog> lista = new ArrayList<>();
   public List<Datalog> buscadatalog(Cliente s) throws SQLException {
        String query = "SELECT * FROM Datalog where idCliente=?";

        List<Datalog> lista = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            ptmt = con.prepareStatement(query);
            ptmt.setInt(1, s.getIdCliente());
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                Datalog f = new Datalog();
                f.setDatalogin(resultSet.getTimestamp("dataLogin"));
                f.setDatalogout(resultSet.getTimestamp("dataLogout"));
                lista.add(f);
            }
        } finally {
        }
        return lista;

    }
    
    public void adiciona(Cliente cliente) {
    
        String sql = "insert into datalog " +
            "(idCliente, dataLogin)" +
            " values (?,?)";
        
    try {
        // prepared statement para inserção
        ptmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores

        ptmt.setLong(1,cliente.getIdCliente());
        ptmt.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
        // executa
        ptmt.execute();
        ResultSet rs = ptmt.getGeneratedKeys(); // pega o Id gerado
        rs.next();
        long i = rs.getLong(1);
        
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }finally{
                try{ptmt.close();}catch (Exception ex){};
            }
    }
}
