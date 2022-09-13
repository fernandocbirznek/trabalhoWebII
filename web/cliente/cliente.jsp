<%-- 
    Document   : cliente
    Created on : 01/08/2022, 16:18:44
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Tela Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel='stylesheet' type='text/css' href="http://localhost:8080/trabalho/indexCss.scss">
        <link rel='stylesheet' type='text/css' href="http://localhost:8080/trabalho/cliente/clienteCss.scss">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script type="text/javascript" src="http://localhost:8080/trabalho/cliente/clienteJS.js" defer></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/jquery-migrate-3.4.0.js"></script>
        <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
        
        <script type="text/javascript">
            $(document).ready(function() {
                $( "#estado" ).change(function() {
                    getCidades();
                });
            });
            
            function getCidades() {
                var estadoId = $("#estado").val();
                var url = "http://localhost:8080/trabalho/AJAXController";
                $.ajax({
                    url : url, // URL 
                    data : {
                        estadoId : estadoId
                    }, // Parâmetro passado para a Servlet
                    dataType : 'json',
                    success : function(data) {
                        // Se sucesso, limpa e preenche a combo de cidade
                        // alert(JSON.stringify(data));
                        $("#cidade").empty();
                        $.each(data, function(i, obj) {
                            $("#cidade").append('<option value=' + obj.id + '>' + obj.nome + '</option>');
                        });
                    },
                    error : function(request, textStatus, errorThrown) {
                        alert(request.status + ', Error: ' + request.statusText);
                        // Erro
                    }
                });
            }
        </script>
        
        <style>
            .remover {
                color: black !important;
            }
        </style>
    </head>
    <body class="imagem">
        
        <c:if test="${empty sessionScope.logado}" >
            <c:set var="mensagem" value="Precisa fazer o login" scope="request" />
            <jsp:forward page="erro.jsp" />
        </c:if>
        
        <div class="container conteudo">
            <div class="mensagem">${mensagem}</div>
            <div class="header row justify-content-center">
                <div class="col-3 text-center">
                    <button id="btn-alterar" class="botao-cliente botao-cliente-alterar">Alterar dados</button>
                </div>
                <div class="col-3 text-center">
                    <button id="btn-atendimento" class="botao-cliente botao-cliente-atendimento">Atendimentos</button>
                </div>
                <div class="col-3 text-center">
                    <button id="btn-criar" class="botao-cliente botao-cliente-criar">Criar atendimento</button>
                </div>
                <div class="col-3 text-center">
                    <form action="LogoutServlet">
                        <button id="btn-criar" class="botao-cliente botao-cliente-deslogar">Deslogar</button>
                    </form>
                </div>
            </div>
            
            <div id="container-cliente-alterar">
                <h1>Alterar dados cliente</h1>
                <form class="container-alterar" action="ClienteController?action=atualizarCliente&id=${usuario.getIdUsuario()}" method="POST">
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <label for="nomeCompletoAlterar">Nome Completo</label>
                                <input class="form-control" type="text" placeholder="Nome completo" name="nomeCompletoAlterar" value="${usuario.getNomeUsuario()}">
                            </div>
                        </div>
                        <div class="form-group col-6">
                            <label for="telefoneAlterar">Telefone/Celular</label>
                            <input type="text" class="form-control" onkeypress="$(this).mask('(00) 0000-00009');" placeholder="(00) 0000-00000" name="telefoneAlterar" value="${usuario.getTelefoneUsuario()}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <label for="senhaAlterar">Senha</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha" name="senhaAlterar" value="${usuario.getSenhaUsuario()}">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-8">
                            <div class="form-group">
                                <label for="ruaAlterar">Rua</label>
                                <input class="form-control" type="text" placeholder="Nome completo" name="ruaAlterar" value="${usuario.getRuaUsuario()}">
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="form-group">
                                <label for="numeroAlterar">Número</label>
                                <input type="number" class="form-control" name="numeroAlterar" value="${usuario.getNumeroUsuario()}">
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="form-group">
                                <label for="complementoAlterar">Complemento</label>
                                <input type="text" class="form-control" name="complementoAlterar" value="${usuario.getComplementoUsuario()}">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <div class="form-group">
                                <label for="bairroAlterar">Bairro</label>
                                <input class="form-control" type="text" name="bairroAlterar" value="${usuario.getBairroUsuario()}">
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="cepAlterar">CEP</label>
                                <input type="text" class="form-control" onkeypress="$(this).mask('00.000-000')" placeholder="00.000-000" name="cepAlterar" value="${usuario.getCepUsuario()}">
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="estado">Estado</label>
                            </div>
                            <select class="custom-select" id="estado" name="estado" value="${usuario.getEstadoUsuario()}">
                                <c:forEach var="estado" items="${estados}">
                                    <option value="${estado.getId()}">${estado.getNome()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="cidade">Cidade</label>
                            </div>
                            <select class="custom-select" id="cidade" name="cidade">
                                <option selected>Escolha...</option>
                            </select>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Alterar</button>
                </form>
            </div>
            
            <div id="container-cliente-atendimento">
                <h1>Listagem de atendimentos</h1>
                <div class="row justify-content-center">
                    <div class="col-10 container-table">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">Tipo do atendimento</th>
                                    <th scope="col">Descrição</th>
                                    <th scope="col">produto</th>
                                    <th scope="col">Situação do atendimento</th>
                                    <th scope="col">data/hora</th>
                                    <th scope="col">Ver atendimento / Remover</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <c:forEach var="atendimento" items="${atendimentos}">
                                    <tr>
                                        <td> ${atendimento.getTipoAtendimentoString()} </td>
                                        <td> ${atendimento.getDescricaoAtendimento()} </td>
                                        <td> ${atendimento.getProdutoAtendimento()} </td>
                                        <td> 
                                            <c:choose>
                                                <c:when test="${atendimento.getSituacaoAtendimento() == false}">
                                                    Em aberto
                                                </c:when>
                                                <c:otherwise>
                                                    Procedimento realizado
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td> ${atendimento.getDataAtendimentoString()} </td>
                                        <td class="column">
                                            <a class="detalhes btn-detalhar-atendimento" href="ClienteController?action=detalharAtendimentosCliente&id=${atendimento.getIdAtendimento()}">Detalhar</a>
                                            <c:if test="${atendimento.getSituacaoAtendimento() == false}">
                                                <a class="btn-remover-atendimento" data-toggle="modal" data-target="#modal${atendimento.getIdAtendimento()}">Remover</a>
                                                
                                                <div class="modal fade" id="modal${atendimento.getIdAtendimento()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog" role="document">
                                                      <div class="modal-content">
                                                        <div class="modal-header">
                                                          <h5 class="modal-title" id="exampleModalLabel">Deseja realmente excluir o Atendimento?</h5>
                                                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                          </button>
                                                        </div>
                                                        <div class="modal-body">
                                                          <h4>Atendimento selecionado: ${atendimento.getDescricaoAtendimento()}</h4>
                                                        </div>
                                                        <div class="modal-footer">
                                                          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                                          <button type="button" class="btn btn-primary">
                                                              <a href="ClienteController?action=removerAtendimentoCliente&id=${atendimento.getIdAtendimento()}" class="remover">Confirmar</a>
                                                          </button>
                                                        </div>
                                                      </div>
                                                    </div>
                                                </div>    
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            
            <div id="container-cliente-criar">
                <h1>Criar atendimento</h1>
                <form class="container-alterar" action="ClienteController?action=inserirAtendimento" method="POST">
                    <div class="row justify-content-md-center">
                        <div class="col-5 input-group">
                            <label>Escolha a data:</label>
                            <input id="datepicker" name="dataAtendimento" data-date-format="dd/mm/yyyy"/>
                            <script>
                                $('#datepicker').datepicker({
                                    uiLibrary: 'bootstrap4',
                                    format: 'dd/mm/yyyy'
                                });
                            </script>
                        </div>
                        <div class="col-5 input-group">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="tipoAtendimento">Tipo Atendimento</label>
                            </div>
                            <select class="custom-select" id="tipoAtendimento" name="tipoAtendimento">
                                <c:forEach var="tipoAtendimento" items="${tipoAtendimentos}">
                                    <option value="${tipoAtendimento.getIdTipoAtendimento()}">${tipoAtendimento.getNomeTipoAtendimento()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row justify-content-md-center">
                        <div class="col-5">
                            <div class="form-group">
                                <label for="Descricao">Descrição</label>
                                <textarea class="form-control" id="descricao" name="descricaoAtendimento" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="col-5">
                            <div class="form-group">
                                <label for="Solucao">Solução</label>
                                <textarea class="form-control" id="solucao" name="solucaoAtendimento" rows="3"></textarea>
                            </div>
                        </div>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Criar Atendimento</button>
                </form>
            </div>
        </div>
    </body>
</html>
