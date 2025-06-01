/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 * @author Paulo
 * 
 * Servlet responsavel por chamar os métodos de cadastrar os dados no banco de dados
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

       try {
            String descricao = request.getParameter("descricao");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            
            // Preço vindo como texto (ex: "1.234,56"), precisa normalizar
            String precoStr = request.getParameter("preco");
            precoStr = precoStr.replace(".", "").replace(",", ".");
            double preco = Double.parseDouble(precoStr);
            

            Produto p = new Produto();
            p.setDescricao(descricao);
            p.setQuantidade(quantidade);
            p.setPreco(preco);

            ProdutoDAO dao = new ProdutoDAO();
            dao.cadastrar(p);

            response.sendRedirect("index.html");
            
        } catch (NumberFormatException e) {
            response.getWriter().println("Erro no formato de número (quantidade ou preço).");
        } catch (Exception e) {
            throw new ServletException("Erro ao cadastrar produto: " + e.getMessage(), e);
        }
    }
}
