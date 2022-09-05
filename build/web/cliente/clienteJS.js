/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var btnAlterar = document.getElementById('btn-alterar');
var btnAtendimento = document.getElementById('btn-atendimento');
var btnCriar = document.getElementById('btn-criar');

var containerAlterar = document.getElementById('container-cliente-alterar');
var containerAtendimento = document.getElementById("container-cliente-atendimento");
var containerCriar = document.getElementById('container-cliente-criar');

var telasGerente = [containerAlterar, containerAtendimento, containerCriar];

btnAlterar.addEventListener('click', function() {
    alterarTela(containerAlterar);
});

btnAtendimento.addEventListener('click', function() {
    alterarTela(containerAtendimento);
});

btnCriar.addEventListener('click', function() {
    alterarTela(containerCriar);
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