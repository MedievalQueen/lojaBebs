/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pacote.Funcionario;

/**
 *
 * @author Ina
 */
public class DaoFuncionario {
    private Connection con=null;
    PreparedStatement ptmt = null;
    private Statement comando;  
    ResultSet resultSet = null;
    
    
    
    
    public List<Funcionario> busca(String cat,String ordem) throws SQLException {
        String query;
        if(cat.equals("todos"))
             query = "SELECT * FROM produto p, imagem a where p.idProduto= a.idProduto ORDER BY "+ordem;
        else
             query = "SELECT * FROM produto p, imagem a where p.idProduto= a.idProduto and idCategoria="+cat+" ORDER BY "+ordem;// nome ASC;  nome DESC; valor ASC; valor DESC;
             
        List<Funcionario> lista = new ArrayList<>();
            try {
                con = ConnectionFactory.getConnection();
                ptmt = con.prepareStatement(query);
                resultSet= ptmt.executeQuery();
                
                while(resultSet.next()){  //idProduto, idCategoria, nome, descricao, valor, quantidade, status
                    Funcionario p = new Funcionario();  

                    p.setNome(resultSet.getString("nome"));  
                    p.setDescricao(resultSet.getString("descricao"));
                    p.setValor(resultSet.getFloat("valor"));
                    p.setQuantidade(resultSet.getInt("quantidade"));
                    p.setStatus(resultSet.getInt("status"));
 
                    lista.add(p);  
                }  
            }finally {       
            }
                return lista;  
            
        }  
}
