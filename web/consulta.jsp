<%@ page import="java.util.List" %>
<%@ page import="br.com.prsoftware.model.Produto" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
    List<Produto> lista = (List<Produto>) request.getAttribute("produtos");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Consultar Produtos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/consulta_style.css">
</head>
<body>

    <header class="cabecalho">
        <div class="nav-buttons">
            <a href="index.html">Cadastrar Produto</a>
            <a href="consulta.jsp">Consultar Produtos</a>
        </div>
    </header>

    <div class="container">
        <h1>Produtos Cadastrados</h1>

        <% if (lista == null || lista.isEmpty()) { %>
            <p>Nenhum produto encontrado.</p>
        <% } else { %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Quantidade</th>
                    <th>Preço</th>
                </tr>
                <% for (Produto p : lista) { %>
                    <tr>
                        <td><%= p.getId() %></td>
                        <td><%= p.getDescricao() %></td>
                        <td><%= p.getQuantidade() %></td>
                        <td>R$ <%= p.getPreco() %></td>
                    </tr>
                <% } %>
            </table>
        <% } %>
    </div>

</body>
</html>
