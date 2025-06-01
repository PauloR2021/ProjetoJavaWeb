/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.prsoftware.servlet;

import br.com.prsoftware.dao.ProdutoDAO;
import br.com.prsoftware.model.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Paulo
 * 
 * Criando a Classe de consultar os dados no Banco e trazer para o HTML
 */
@WebServlet("/consultar")
public class ConsultaProdutosServlet  extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        try{
            //Iniciando a Classe do Banco de dados e Trazendo o Metodo de Consulta
            ProdutoDAO dao = new ProdutoDAO();
            //Inciando uma Lista com o os dados da Consulta em SQL e transendo para o Construtor
            List<Produto> lista = dao.listar();
            request.setAttribute("produtos", lista);
            //Retornando a Lista para o HTML de Consulta
            RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
            rd.forward(request, response);
        }catch (Exception e){
            throw new ServletException(e);
        }   
    }    
}
