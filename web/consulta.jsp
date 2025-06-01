<%-- 
    Document   : resultado
    Created on : 30 de mai. de 2025, 07:35:47
    Author     : Paulo
    Description: Criando a Classe HTML que vai Mostrar o Resultado da Busca dos Dados
--%>

<%@ page import="java.util.List" %>
<%@ page import="br.com.prsoftware.model.Produto"%>
<% List<Produto> lista = (List<Produto>) request.getAttribute("produtos"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head lang="pt-BR">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Produtos Cadastrados</h1>
        <table border="1">
        <tr><th>ID</th><th>Descrição</th><th>Qtd</th><th>Preço</th></tr>
        <% for (Produto p : lista) { %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getDescricao() %></td>
                <td><%= p.getQuantidade() %></td>
                <td>R$ <%= p.getPreco() %></td>
            </tr>
        <% } %>
    </table>
    <a href="index.html">Cadstrar Produto</a>
    </body>
</html>
