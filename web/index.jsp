<%-- 
    Document   : index
    Created on : 01/08/2022, 16:04:15
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>BEIBE estética</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel='stylesheet' type='text/css' href="indexCss.scss">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <style>
            .mensagem {
                color: red;
            }
        </style>
        
    </head>
    <body class="imagem">
        <div class="container conteudo">
            <div class="header">
                <div class="mensagem">${mensagem}</div>
                <div class="titulo">
                    BEIBE<br>
                    Beauty Embuste Indústria de Beleza e Estética <br>
                    <span class="endereco">Rua do Embuste, 1313 </span>
                    <span class="endereco">Curitiba, PR, 13131-313 </span>
                    <span class="endereco">(41) 9 1313-1313 </span>
                </div>
                <div class="botoes">
                    <a class="botao botao-acessar" href="CriarContaController?action=formCriarConta">
                        Criar Conta
                    </a>
                    
                    <button type="button" data-toggle="modal" data-target="#acessarSistema" class="botao botao-criar">
                        Acessar sistema
                    </button>
                    
                    <div class="modal fade bd-example-modal-lg" id="acessarSistema" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog modal-lg" role="document">
                           <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Acessar Sistema</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                 
                                    <form action="LoginServlet" method="POST">
                                        <div class="form-group">
                                            <label for="emailLogin">Email</label>
                                            <input type="email" class="form-control" id="loginEmail" aria-describedby="emailHelp" placeholder="Enter email" name="emailLogin">
                                        </div>

                                        <div class="form-group">
                                            <label for="senhaLogin">Password</label>
                                            <input type="password" class="form-control" id="loginPassword" placeholder="Password" name="senhaLogin">
                                        </div>

                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                        <button type="submit" class="btn btn-primary">Logar</button>
                                    </form>                             
                                </div>
                           </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <div class="informacao">
                <p class="texto">
                    A BEIBE é uma empresa de Embelezamento Artificial, voltada ao público jovem e adulto que
                    quer fazer a diferença no mundo.
                </p>
                <p class="texto">
                    A Embuste é a marca de beleza preferida dos brasileiros (Fonte: Embuste Estatística, 2018).
                    Todos os nossos produtos tocam sua beleza. É assim que a marca transforma momentos simples
                    em momentos embusteiros há menos de 0 anos.
                </p>
                <div class="row">
                    <div class="col-8">
                        <p>Nossos procedimentos são os mais avançados no mercado e estão por valores excelentes. 
                           Confira ao lado algumas imagens de nossos procedimentos e abaixo os preços:
                        </p>
                        
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">código</th>
                                    <th scope="col">Procedimento</th>
                                    <th scope="col">Custo (R$)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1234</th>
                                    <td>Tratamento virar miss</td>
                                    <td>450.000,00</td>
                                </tr>
                                <tr>
                                    <th scope="row">4422</th>
                                    <td>Implante dentário</td>
                                    <td>30.000,00</td>
                                </tr>
                                <tr>
                                    <th scope="row">2222</th>
                                    <td>Silicone</td>
                                    <td>60.000,00</td>
                                </tr>
                                <tr>
                                    <th scope="row">1111</th>
                                    <td>Implante cabelo</td>
                                    <td>2.000,00</td>
                                </tr>
                                <tr>
                                    <th scope="row">7863</th>
                                    <td>Tratamento beleza</td>
                                    <td>500,00</td>
                                </tr>
                            </tbody>
                        </table>
                        
                    </div>
                    <div class="col-3">
                        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="./imagens/img-1.png" alt="First slide">
                                </div>
                                <div class="carousel-item">
                                  <img src="./imagens/img-2.png" alt="Third slide">
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                    
                </div>
            </div>
            <div class="footer">
                <p class="titulo">BEIBE</p>
                <div class="endereco-footer">
                    <span class="endereco">Rua do Embuste, 1313 </span>
                    <span class="endereco">Curitiba, PR, 13131-313 </span>
                    <span class="endereco">(41) 9 1313-1313 </span>
                </div>
            </div>
        </div>
    </body>
</html>
