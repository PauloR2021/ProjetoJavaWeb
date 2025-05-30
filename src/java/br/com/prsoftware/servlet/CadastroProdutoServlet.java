/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.prsoftware.servlet;

import br.com.prsoftware.dao.ProdutoDAO;
import br.com.prsoftware.model.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Paulo
 * 
 * Criando o Servlet para a requisição POST para inserir os dados no banco
 * Vindo da Página HTML
 */
public class CadastroProdutoServlet extends HttpServlet{
    
    @Override //Anotação para Importar o HttpServlet
    protected void doPost(HttpServletRequest request , HttpServletResponse response)  
            throws ServletException, IOException {
        
        //Transendo os dados do HTML digitado pelo Usuário
        //Chamando o Construtor para Salvar as Informações
        Produto p = new Produto(); 
        p.setDescricao(request.getParameter("descricao"));
        p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        p.setPreco(Double.parseDouble(request.getParameter("preco")));
        
        try{
            //Chamando o Construtor do Banco de Dados , junto com o função de Cadastrar Produtos
            ProdutoDAO dao = new ProdutoDAO();
            dao.cadastrar(p);
            //Retornando para a página Html de Cadastro, após inserir os dados com Sucesso
            response.sendRedirect("cadastrar.html");
        }catch(Exception e){
            throw new ServletException(e);
        }
        
    }
}
