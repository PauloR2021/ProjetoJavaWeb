package br.com.prsoftware.dao;

import br.com.prsoftware.env.EnvLoader;
import br.com.prsoftware.model.Produto;
import java.sql.*;
import java.util.*;

public class ProdutoDAO {

    private final String url = EnvLoader.get("DB_URL");
    private final String user = EnvLoader.get("DB_USER"); 
    private final String password = EnvLoader.get("DB_PASSWORD"); 

    public ProdutoDAO() throws ClassNotFoundException {
        // Carrega o driver JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public void cadastrar(Produto p) throws Exception {
        String sql = "INSERT INTO produtos (descricao, quantidade, preco) VALUES (?, ?, ?)";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDouble(3, p.getPreco());
            stmt.executeUpdate();
        }
    }

    public List<Produto> listar() throws Exception {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
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
