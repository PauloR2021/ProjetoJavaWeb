<%-- 
    Document   : consulta
    Created on : 29 de mai. de 2025, 20:08:20
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Produtos</title>
    </head>
    <body>
        <h1>Consulta de Produtos</h1>
        <form method="GET" action="consultaProdutos">
            <label for="nome">Nome do Produto:</label>
            <input type="text" id="nome" name="name"/>
            <button type="submit">Buscar</button>
        </form>
    </body>
</html>
