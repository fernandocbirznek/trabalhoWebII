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
        <link rel='stylesheet' type='text/css' href="../indexCss.scss">
        <link rel='stylesheet' type='text/css' href="clienteCss.scss">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script type="text/javascript" src="clienteJS.js" defer></script>
        
        <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

    </head>
    <body class="imagem">
        
        <c:if test="${empty sessionScope.logado}" >
            <c:set var="msg" value="Precisa fazer o login" scope="request" />
            <jsp:forward page="index.jsp" />
        </c:if>
        
        <div class="container conteudo">
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
                    <form action="../index.jsp">
                        <button id="btn-criar" class="botao-cliente botao-cliente-deslogar">Deslogar</button>
                    </form>
                </div>
            </div>
            
            <div id="container-cliente-alterar">
                <h1>Alterar dados cliente</h1>
                <form class="container-alterar">
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <label for="nomeCompletoAlterar">Nome Completo</label>
                                <input class="form-control" type="text" placeholder="Nome completo" name="nomeCompletoAlterar">
                            </div>
                        </div>
                        <div class="form-group col-6">
                            <label for="telefoneAlterar">Telefone/Celular</label>
                            <input type="text" class="form-control" onkeypress="$(this).mask('(00) 0000-00009');" placeholder="(00) 0000-00000" name="telefoneAlterar">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <label for="senhaAlterar">Senha</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha" name="senhaAlterar">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-8">
                            <div class="form-group">
                                <label for="ruaAlterar">Rua</label>
                                <input class="form-control" type="text" placeholder="Nome completo" name="ruaAlterar">
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="form-group">
                                <label for="numeroAlterar">Número</label>
                                <input type="number" class="form-control" name="numeroAlterar">
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="form-group">
                                <label for="complementoAlterar">Complemento</label>
                                <input type="text" class="form-control" name="complementoAlterar">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <div class="form-group">
                                <label for="bairroAlterar">Bairro</label>
                                <input class="form-control" type="text" name="bairroAlterar">
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="cepAlterar">CEP</label>
                                <input type="text" class="form-control" onkeypress="$(this).mask('00.000-000')" placeholder="00.000-000" name="cepAlterar">
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="cidadeAlterar">Cidade</label>
                                <input type="text" class="form-control" name="cidadeAlterar">
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <label for="estadoAlterar">Estado</label>
                                <input type="text" class="form-control" name="estadoAlterar">
                            </div>
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
                                <tr>
                                    <th scope="row">Depilação</th>
                                    <td>Depilação a laser é uma técnica para a remoção definitiva dos pelos realizada com a utilização da energia luminosa 
                                        do laser. O procedimento é realizado com a utilização do laser diretamente nos pelos que serão eliminados.
                                    </td>
                                    <td></td>
                                    <td>Aberto</td>
                                    <td>25/09/2022</td>
                                    <td>
                                        <a data-toggle="modal" data-target="#detalhes" class="detalhes">
                                            Detalhes
                                        </a>
                                        <div class="modal fade bd-example-modal-lg" id="detalhes" tabindex="-1" role="dialog" aria-labelledby="detalhes" aria-hidden="true">
                                            <div class="modal-dialog modal-lg" role="document">
                                               <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="detalhes">Detalhes do Atendimento</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                       <div>
                                                            <h3>Aaaaaaaaaaaaaaaaaaaa</h3>
                                                        </div>
                                                    </div>
                                               </div>
                                            </div>
                                        </div>
                                        <button type="button" class="btn-remover-atendimento">Remover</button>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">Implante dentário</th>
                                    <td>O implante dentário é uma técnica de reabilitação oral que permite a fixação de uma prótese dentária de forma permanente. 
                                        Como traz mais segurança e as técnicas não param de evoluir, a preferência por esse modelo de tratamento aumenta a cada dia.
                                    </td>
                                    <td>dente de adamantium.</td>
                                    <td>Fechado</td>
                                    <td>15/02/2020</td>
                                    <td>
                                        <a data-toggle="modal" data-target="#detalhes-2" class="detalhes">
                                            Detalhes
                                        </a>
                                        <div class="modal fade bd-example-modal-lg" id="detalhes-2" tabindex="-1" role="dialog" aria-labelledby="detalhes-2" aria-hidden="true">
                                            <div class="modal-dialog modal-lg" role="document">
                                               <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="detalhes-2">Detalhes do Atendimento</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                       <div>
                                                            <h3>Bbbbbbbbbbbbbbbbbb</h3>
                                                        </div>
                                                    </div>
                                               </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">Tratamento de beleza</th>
                                    <td>Nosso tratamento de beleza visa um dia de spa com tratamento corporal completo, cremes, massagem, depilação, etc.
                                    </td>
                                    <td>Cremes, shampos, etc.</td>
                                    <td>Fechado</td>
                                    <td>04/010/2015</td>
                                    <td>
                                        <a data-toggle="modal" data-target="#detalhes-3" class="detalhes">
                                            Detalhes
                                        </a>
                                        <div class="modal fade bd-example-modal-lg" id="detalhes-3" tabindex="-1" role="dialog" aria-labelledby="detalhes-3" aria-hidden="true">
                                            <div class="modal-dialog modal-lg" role="document">
                                               <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="detalhes-3">Detalhes do Atendimento</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                       <div>
                                                            <h3>Cccccccccccccccccc</h3>
                                                        </div>
                                                    </div>
                                               </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            
            <div id="container-cliente-criar">
                <h1>Criar atendimento</h1>
                <form class="container-alterar">
                    <div class="row">
                        <div class="col-4 input-group">
                            <label>Escolha a data:</label>
                            <input id="datepicker" name="dataInserir"/>
                            <script>
                                $('#datepicker').datepicker({
                                    uiLibrary: 'bootstrap4'
                                });
                            </script>
                        </div>
                        <div class="col-4">
                            <div class="form-group">
                                <label>Tipo Atendimento</label>
                                <select name="tipoInserir">
                                    <option selected value="0">Qual atendimento?</option>
                                    <option value="depilacao">Depilação</option>
                                    <option value="implanteDentario">Implante dentário</option>
                                    <option value="tratamentoBeleza">Tratamento de beleza</option>
                                 </select>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-group">
                                <label>Produto</label>
                                <select name="produtoInserir">
                                    <option selected value="0">Qual produto?</option>
                                    <option value="1">shampo</option>
                                    <option value="2">Dente adamantium</option>
                                    <option value="3">Creme</option>
                                 </select>
                            </div>
                        </div>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Criar Atendimento</button>
                </form>
            </div>
        </div>
    </body>
</html>
