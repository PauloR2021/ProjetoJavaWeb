/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function formatarPreco(input) {
    let valor = input.value.replace(/\D/g, ""); // Remove tudo que não for número
    valor = (parseInt(valor, 10) / 100).toFixed(2); // Divide por 100 e fixa 2 casas decimais
    valor = valor.replace(".", ","); // Substitui ponto por vírgula
    valor = valor.replace(/\B(?=(\d{3})+(?!\d))/g, "."); // Adiciona pontos como separador de milhar
    input.value = valor;
}