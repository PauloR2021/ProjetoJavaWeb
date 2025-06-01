/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.prsoftware.servlet;

import br.com.prsoftware.dao.ProdutoDAO;
import br.com.prsoftware.model.Produto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cadastrar")
public class CadastroProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response)  
            throws ServletException, IOException {

        Produto p = new Produto(); 
        p.setDescricao(request.getParameter("descricao"));
        p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        p.setPreco(Double.parseDouble(request.getParameter("preco")));

        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.cadastrar(p);
            response.sendRedirect("index.html");
        } catch(Exception e) {
            throw new ServletException(e);
        }
    }
}
