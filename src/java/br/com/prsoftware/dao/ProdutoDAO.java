/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.prsoftware.dao;

/**
 *
 * @author Paulo
 * Criando a Classe responsável por Realizar consultas no Banco de Dados
 *
 */

import br.com.prsoftware.model.Produto;
import java.sql.*;
import java.util.*;
public class ProdutoDAO {
    
    private final String url = "jdbc:mysql://localhost:3306/produto_db";
    private final String user = "root";
    private final String password = "senha";
    
    
    public void cadastrar(Produto p) throws Exception{
        String sql = "INSERT INTO produto (descricao, quantidade, preco) VALUES (?,?,?)";
        
        try(Connection conn = DriverManager.getConnection(url,user,password);
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDouble(3, p.getPreco());
            stmt.executeUpdate();
        }
    }
    
    
    public List<Produto> listar() throws Exception{
        List<Produto> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM produto";
        
        try(Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPreco(rs.getDouble("preco"));
                lista.add(p);
            }
        }
        
        return lista;
    }
    
}
