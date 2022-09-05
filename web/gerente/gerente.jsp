<%-- 
    Document   : gerente
    Created on : 01/08/2022, 16:45:05
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Tela gerente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel='stylesheet' type='text/css' href="../indexCss.scss">
        <link rel='stylesheet' type='text/css' href="gerenteCss.scss">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script type="text/javascript" src="gerenteJS.js" defer></script>
    </head>
    <body class="imagem">
        
        <c:if test="${empty sessionScope.logado}" >
            <c:set var="msg" value="Precisa fazer o login" scope="request" />
            <jsp:forward page="index.jsp" />
        </c:if>
        
        <div class="container conteudo">
            <div class="header row justify-content-center">
                <div class="row justify-content-center container-botoes align-items-center">
                    <div class="col-3 text-center">
                        <button id="btn-lista" class="botao-gerente botao-gerente-lista">Lista Usuários</button>
                    </div>
                    <div class="col-3 text-center">
                        <button id="btn-atendimento-aberto" class="botao-gerente botao-gerente-atendimento-aberto">Atendimento em aberto</button>
                    </div>
                    <div class="col-3 text-center">
                        <button id="btn-atendimento" class="botao-gerente botao-gerente-atendimento">Atendimentos</button>
                    </div>
                    <div class="col-3 text-center">
                        <form action="../index.jsp">
                            <button id="btn-deslogar" class="botao-gerente botao-gerente-deslogar">Deslogar</button>
                        </form>
                    </div>
                </div>
                <div class="row justify-content-center align-items-center">
                    <div class="col-3 text-center">
                        <button id="btn-relatorio-funcionario" class="botao-gerente botao-gerente-relatorio-funcionario">Relatório de Funcionários</button>
                    </div>
                    <div class="col-3 text-center">
                        <button id="btn-relatorio-produto" class="botao-gerente botao-gerente-relatorio-produto">Produtos com mais reclamações</button>
                    </div>
                    <div class="col-3 text-center">
                        <button id="btn-relatorio-data" class="botao-gerente botao-gerente-criar-relatorio-data">Relatório de atendimentos em aberto por Data</button>
                    </div>
                    <div class="col-3 text-center">
                        <button id="btn-relatorio-reclamacao" class="botao-gerente botao-gerente-relatorio-reclamacao">Relatório de Reclamações</button>
                    </div>
                </div>
            </div>

            <div id="container-gerente-lista">
                
                <div class="container-adicionar-usuario">
                    <a href="GerenteController?action=formAdicionarUsuario" class="botao-adicionar">Adicionar novo usuário</a>
                </div>
                
                <div class="mensagem">${mensagem}</div>
                
                <h1>Listagem de Usuários</h1>
                <div class="row justify-content-center">
                    <div class="col-10 container-table">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">Nome</th>
                                    <th scope="col">Cargo</th>
                                    <th scope="col">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tagl:forEach var="usuario" items="${usuarios}">
                                    <tr>
                                        <th scope="row">${usuario.getNomeUsuario()}</th>
                                        <td>${usuario.getCargoUsuario()}</td>
                                        <td class="row">
                                            <a class="botao-gerente btn-alterar" href="GerenteController?action=formAlterar&id=${usuario.getIdUsuario()}">Alterar</a>
                                            <a class="botao-gerente btn-visualizar" href="GerenteController?action=visualizarUsuario&id=${usuario.getIdUsuario()}">Visualizar</a>
                                            <div>
                                                <button type="button" class="button button-remover" data-toggle="modal" data-target="#modal${usuario.getIdUsuario()}">
                                                    Remover
                                                </button>

                                                <div class="modal fade" id="modal${usuario.getIdUsuario()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                  <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                      <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Deseja realmente excluir o Usuário?</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                          <span aria-hidden="true">&times;</span>
                                                        </button>
                                                      </div>
                                                      <div class="modal-body">
                                                        <h4>Usuário selecionado: ${usuario.getNomeUsuario()}</h4>
                                                      </div>
                                                      <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                                        <button type="button" class="btn btn-primary">
                                                            <a href="GerenteController?action=removerUsuario&id=${usuario.getIdUsuario()}">Confirmar</a>
                                                        </button>
                                                      </div>
                                                    </div>
                                                  </div>
                                                </div>    
                                            </div>
                                        </td>
                                    </tr>
                                </tagl:forEach>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            
            <div id="container-gerente-atendimento-aberto">
                <h1>Atendimento em aberto</h1>
                <div class="row justify-content-center">
                    <table class="col-10 table">
                        <thead>
                            <tr>
                                <th scope="col">código</th>
                                <th scope="col">Usuário</th>
                                <th scope="col">Data</th>
                                <th scope="col">Dias atrasado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tagl:forEach var="atendimento" items="${atendimentos}">
                                <c:if test="${atendimento.getSituacaoAtendimento == false}">
                                    <c:choose>
                                        <c:when test="${atendimento.getDiasAtrasadosAtendimento >= 7}">
                                            <tr class="atendimento-atrasado">
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                        </c:otherwise>
                                    </c:choose>
                                        <th scope="row">${atendimento.getIdAtendimento()}</th>
                                        <td>${atendimento.getUsuarioAtendimento()}</td>
                                        <td>${atendimento.getDataAtendimento()}</td>
                                        <td>${atendimento.getDAtendimento()}</td>
                                    </tr>
                                </c:if>
                            </tagl:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            
            <div id="container-gerente-atendimento">
                <h1>Atendimento</h1>
                <div class="row justify-content-center">
                    <table class="col-10 table">
                        <thead>
                            <tr>
                                <th scope="col">código</th>
                                <th scope="col">Usuário</th>
                                <th scope="col">Data</th>
                                <th scope="col">Dias atrasado</th>
                            </tr>
                        </thead>
                        <tbody>
                           <tagl:forEach var="atendimento" items="${atendimentos}">
                                <c:choose>
                                    <c:when test="${atendimento.getDiasAtrasadosAtendimento >= 7}">
                                        <tr class="atendimento-atrasado">
                                    </c:when>
                                    <c:when test="${atendimento.getDiasAtrasadosAtendimento >= 1}">
                                        <tr class="atendimento-atrasado-semana">
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                    </c:otherwise>
                                </c:choose>
                                    <th scope="row">${atendimento.getIdAtendimento()}</th>
                                    <td>${atendimento.getUsuarioAtendimento()}</td>
                                    <td>${atendimento.getDataAtendimento()}</td>
                                    <td>${atendimento.getDAtendimento()}</td>
                                </tr>
                            </tagl:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            
            <div id="container-gerente-relatorio-funcionario">
                <h1>Relatório Funcionário</h1>
            </div>
            
            <div id="container-gerente-relatorio-produto">
                <h1>Relatório Produto</h1>
            </div>
            
            <div id="container-gerente-relatorio-data">
                <h1>Relatório data</h1>
            </div>
            
            <div id="container-gerente-relatorio-reclamacao">
                <h1>Relatório reclamações</h1>
            </div>
            
        </div>
    </body>
</html>
