/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var btnLista = document.getElementById('btn-lista');
var btnAtendimentoAberto = document.getElementById('btn-atendimento-aberto');
var btnAtendimento = document.getElementById('btn-atendimento');
var btnRelatorioFuncionario = document.getElementById('btn-relatorio-funcionario');
var btnRelatorioProduto = document.getElementById('btn-relatorio-produto');
var btnRelatorioData = document.getElementById('btn-relatorio-data');
var btnRelatorioReclamacao = document.getElementById('btn-relatorio-reclamacao');

var containerLista = document.getElementById('container-gerente-lista');
var containerAtendimentoAberto = document.getElementById("container-gerente-atendimento-aberto");
var containerAtendimento = document.getElementById('container-gerente-atendimento');
var containerRelatorioFuncionario = document.getElementById('container-gerente-relatorio-funcionario');
var containerRelatorioProduto = document.getElementById('container-gerente-relatorio-produto');
var containerRelatorioData = document.getElementById('container-gerente-relatorio-data');
var containerRelatorioReclamacao = document.getElementById('container-gerente-relatorio-reclamacao');

var telasGerente = [containerLista, containerAtendimento, containerAtendimentoAberto, containerRelatorioFuncionario, containerRelatorioProduto, containerRelatorioData, containerRelatorioReclamacao];

btnLista.addEventListener('click', function() {
    alterarTela(containerLista);
});

btnAtendimentoAberto.addEventListener('click', function() {
    alterarTela(containerAtendimentoAberto);
});

btnAtendimento.addEventListener('click', function() {
    alterarTela(containerAtendimento);
});

btnRelatorioFuncionario.addEventListener('click', function() {
    alterarTela(containerRelatorioFuncionario);
});

btnRelatorioProduto.addEventListener('click', function() {
    alterarTela(containerRelatorioProduto);
});

btnRelatorioData.addEventListener('click', function() {
    alterarTela(containerRelatorioData);
});

btnRelatorioReclamacao.addEventListener('click', function() {
    alterarTela(containerRelatorioReclamacao);
});

function alterarTela(item) {
    if(item.style.display === 'none' || item.style.display === '') {
        item.style.display = "block";
    }
    telasGerente.forEach(function(tela) {
        if(item.id !== tela.id)
            tela.style.display = "none";
    });
}