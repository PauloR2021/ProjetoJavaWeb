<%-- 
    Document   : Home
    Created on : 29 de mai. de 2025, 06:58:24
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
    </head>
    <body>
    <header>
        <h2>Controle de Produtos</h2>
        <div clas="nav-buttons">
            <a href="cadastrar.jsp">Cadastrar Produtos</a>
            <a href="consultar.jsp">Consultar Produtos</a>            
        </div>
    </header>
        
        <form action = "salvar" method="post">
            <h3>Cadastro de Produtos</h3>
            
            <label for="descricao">Descrição do Produto:</label>
            <input type="text" id="descricao" name="descricao" required>
            
            <label for="Quantidade">Quantidade do Produto:</label>
            <input type="number" id="quantidade" name="quantidade" required>
            
            <label for="preco">Preço do Produto</label>
            <input type="text" id="preco" name="preço" required>
            
            <button type="submit">Salvar Produto</button>
            
        </form>
    </body>
</html>