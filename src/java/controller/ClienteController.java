package controller;

import beans.AtendimentoBeans;
import beans.EstadoBeans;
import beans.LoginBeans;
import beans.TipoAtendimentoBeans;
import beans.UsuarioBeans;
import exception.AtualizarClienteException;
import exception.BuscarAtendimentoClienteException;
import exception.BuscarAtendimentoIdException;
import exception.BuscarEstadoException;
import exception.BuscarTipoAtendimentoException;
import exception.InserirAtendimentoException;
import exception.RemoverAtendimentoException;
import facade.ClienteFacade;
import facade.EstadoCidadeFacade;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
        HttpSession session = request.getSession();
        
        LoginBeans logado = (LoginBeans)session.getAttribute("logado");
        UsuarioBeans usuario = (UsuarioBeans)session.getAttribute("usuario");
        
        if(logado.getCargo() != 1) {
            request.setAttribute("mensagem", "Usuário deve se autenticar para acessar o sistema");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
        }
        
        String action = request.getParameter("action");
        String idClienteString = request.getParameter("id");
        int idCliente = 9999;
        if(idClienteString == null)
            idClienteString = "9999";
        try {
            idCliente = Integer.parseInt(idClienteString);
        } catch (NumberFormatException e) {
            request.setAttribute("mensagem", "Id do cliente inválido ");
            RequestDispatcher rd3 = getServletContext().getRequestDispatcher("/erro.jsp");
            rd3.forward(request, response);
        }
        
        if(action == null) {
            action = "listarAtendimentosCliente";
        }
        
        switch(action) {
            case "listarAtendimentosCliente":
                try {
                    List<AtendimentoBeans> listaAtendimento = ClienteFacade.buscarAtendimentosCliente(logado.getId());
                    request.setAttribute("atendimentos", listaAtendimento);
                    request.setAttribute("usuario", usuario);
                    List<EstadoBeans> listaEstados = EstadoCidadeFacade.buscarEstado();
                    request.setAttribute("estados", listaEstados);
                    List<TipoAtendimentoBeans> listaTipoAtendimentos = ClienteFacade.buscarTipoAtendimento();
                    for(TipoAtendimentoBeans tipoAtendimento: listaTipoAtendimentos) {
                        for(AtendimentoBeans atendimento: listaAtendimento) {
                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            String dataString = format.format(atendimento.getDataAtendimento());
                            atendimento.setDataAtendimentoString(dataString);
                            if(atendimento.getTipoAtendimento() == tipoAtendimento.getIdTipoAtendimento())
                                atendimento.setTipoAtendimentoString(tipoAtendimento.getNomeTipoAtendimento());
                        }
                    }
                    request.setAttribute("tipoAtendimentos", listaTipoAtendimentos);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cliente/cliente.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentoClienteException e) {
                    request.setAttribute("mensagem", "Mostrar inválido ");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarEstadoException e) {
                    request.setAttribute("mensagem", "Erro ao acessar estados");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarTipoAtendimentoException e) {
                    request.setAttribute("mensagem", "Erro ao buscar tipo atendimentos");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            case "detalharAtendimentosCliente":
                try {
                    AtendimentoBeans atendimento = ClienteFacade.buscarAtendimentoId(idCliente);
                    List<TipoAtendimentoBeans> listaTipoAtendimentos = ClienteFacade.buscarTipoAtendimento();
                    for(TipoAtendimentoBeans tipoAtendimento: listaTipoAtendimentos) {
                        if(atendimento.getTipoAtendimento() == tipoAtendimento.getIdTipoAtendimento())
                            atendimento.setTipoAtendimentoString(tipoAtendimento.getNomeTipoAtendimento());
                    }
                    List<EstadoBeans> listaEstados = EstadoCidadeFacade.buscarEstado();
                    request.setAttribute("estados", listaEstados);
                    request.setAttribute("atendimento", atendimento);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cliente/clienteAtendimentoDetalhado.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentoIdException e) {
                    request.setAttribute("mensagem", "Buscar atendimento erro!!!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarTipoAtendimentoException e) {
                    request.setAttribute("mensagem", "Erro ao buscar tipo atendimentos");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarEstadoException e) {
                    request.setAttribute("mensagem", "Erro ao acessar estados");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } 
                break;
            case "atualizarCliente":
                try {
                    String nome = request.getParameter("nomeCompletoAlterar");
                    String telefone = request.getParameter("telefoneAlterar");
                    telefone = telefone.replace("(", "");
                    telefone = telefone.replace(")", "");
                    telefone = telefone.replace("-", "");
                    String senha = request.getParameter("senhaAlterar");
                    String rua = request.getParameter("ruaAlterar");
                    String numero = request.getParameter("numeroAlterar");
                    String complemento = request.getParameter("complementoAlterar");
                    String bairro = request.getParameter("bairroAlterar");
                    String cep = request.getParameter("cepAlterar");
                    cep = cep.replace(".", "");
                    cep = cep.replace("-", "");
                    String cidade = request.getParameter("cidade");
                    String estado = request.getParameter("estado");

                    UsuarioBeans cliente = new UsuarioBeans();
                    cliente.setIdUsuario(logado.getId());
                    cliente.setNomeUsuario(nome);
                    cliente.setTelefoneUsuario(telefone);
                    cliente.setSenhaUsuario(senha);
                    cliente.setRuaUsuario(rua);
                    cliente.setNumeroUsuario(numero);
                    cliente.setComplementoUsuario(complemento);
                    cliente.setBairroUsuario(bairro);
                    cliente.setCepUsuario(cep);
                    cliente.setCidadeUsuario(Integer.parseInt(cidade));
                    cliente.setEstadoUsuario(Integer.parseInt(estado));
                    
                    ClienteFacade.atualizarCliente(cliente);
                    List<AtendimentoBeans> listaAtendimento = ClienteFacade.buscarAtendimentosCliente(logado.getId());
                    List<TipoAtendimentoBeans> listaTipoAtendimentos = ClienteFacade.buscarTipoAtendimento();
                    for(TipoAtendimentoBeans tipoAtendimentos: listaTipoAtendimentos) {
                        for(AtendimentoBeans atendimentos: listaAtendimento) {
                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                            String dataString = formato.format(atendimentos.getDataAtendimento());
                            atendimentos.setDataAtendimentoString(dataString);
                            if(atendimentos.getTipoAtendimento() == tipoAtendimentos.getIdTipoAtendimento())
                                atendimentos.setTipoAtendimentoString(tipoAtendimentos.getNomeTipoAtendimento());
                        }
                    }
                    List<EstadoBeans> listaEstados = EstadoCidadeFacade.buscarEstado();
                    request.setAttribute("estados", listaEstados);
                    request.setAttribute("tipoAtendimentos", listaTipoAtendimentos);
                    request.setAttribute("atendimentos", listaAtendimento);
                    request.setAttribute("mensagem", "Dados alterados com sucesso");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cliente/cliente.jsp");
                    rd.forward(request, response);
                } catch (AtualizarClienteException e) {
                    request.setAttribute("mensagem", "Erro ao atualizar cliente");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentoClienteException e) {
                    request.setAttribute("mensagem", "Erro id Cliente!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarTipoAtendimentoException e) {
                    request.setAttribute("mensagem", "Erro ao buscar tipo atendimentos");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarEstadoException e) {
                    request.setAttribute("mensagem", "Erro ao acessar estados");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } 
                break;
            case "inserirAtendimento":
                try {
                    
                    String data = request.getParameter("dataAtendimento");
                    
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataFormatada = null;
                    try {
                        dataFormatada = format.parse(data); 
                    } 
                    catch (ParseException e) {
                        System.out.println("Data no formato errado");
                        e.printStackTrace();
                    }

                    String tipoAtendimento = request.getParameter("tipoAtendimento");
                    String descricaoAtendimento = request.getParameter("descricaoAtendimento");
                    String solucaoAtendimento = request.getParameter("solucaoAtendimento");
                    
                    AtendimentoBeans atendimento = new AtendimentoBeans();
                    atendimento.setDataAtendimento(dataFormatada);
                    atendimento.setDescricaoAtendimento(descricaoAtendimento);
                    atendimento.setSolucaoAtendimento(solucaoAtendimento);
                    atendimento.setSituacaoAtendimento(false);
                    atendimento.setTipoAtendimento(Integer.parseInt(tipoAtendimento));
                    atendimento.setUsuarioAtendimento(logado.getId());
                    
                    ClienteFacade.inserirAtendimento(atendimento);
                    List<AtendimentoBeans> listaAtendimento = ClienteFacade.buscarAtendimentosCliente(logado.getId());
                    List<TipoAtendimentoBeans> listaTipoAtendimentos = ClienteFacade.buscarTipoAtendimento();
                    for(TipoAtendimentoBeans tipoAtendimentos: listaTipoAtendimentos) {
                        for(AtendimentoBeans atendimentos: listaAtendimento) {
                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                            String dataString = formato.format(atendimentos.getDataAtendimento());
                            atendimentos.setDataAtendimentoString(dataString);
                            if(atendimentos.getTipoAtendimento() == tipoAtendimentos.getIdTipoAtendimento())
                                atendimentos.setTipoAtendimentoString(tipoAtendimentos.getNomeTipoAtendimento());
                        }
                    }
                    List<EstadoBeans> listaEstados = EstadoCidadeFacade.buscarEstado();
                    request.setAttribute("estados", listaEstados);
                    request.setAttribute("tipoAtendimentos", listaTipoAtendimentos);
                    
                    request.setAttribute("atendimentos", listaAtendimento);
                    request.setAttribute("mensagem", "Atendimento criado com sucesso");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cliente/cliente.jsp");
                    rd.forward(request, response);
                } catch (InserirAtendimentoException e) {
                    request.setAttribute("mensagem", "Erro ao cadastrar um atendimento ");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentoClienteException e) {
                    request.setAttribute("mensagem", "Erro id Cliente!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarTipoAtendimentoException e) {
                    request.setAttribute("mensagem", "Erro ao buscar tipo atendimentos");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarEstadoException e) {
                    request.setAttribute("mensagem", "Erro ao acessar estados");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } 
                break;
            case "removerAtendimentoCliente":
                try {
                    ClienteFacade.removerAtendimentoCliente(idCliente);
                    List<AtendimentoBeans> listaAtendimento = ClienteFacade.buscarAtendimentosCliente(logado.getId());
                    request.setAttribute("atendimentos", listaAtendimento);
                    request.setAttribute("usuario", usuario);
                    List<EstadoBeans> listaEstados = EstadoCidadeFacade.buscarEstado();
                    request.setAttribute("estados", listaEstados);
                    List<TipoAtendimentoBeans> listaTipoAtendimentos = ClienteFacade.buscarTipoAtendimento();
                    request.setAttribute("tipoAtendimentos", listaTipoAtendimentos);
                    request.setAttribute("mensagem", "Dados removido com sucesso");
                    
                    for(TipoAtendimentoBeans tipoAtendimentos: listaTipoAtendimentos) {
                        for(AtendimentoBeans atendimentos: listaAtendimento) {
                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                            String dataString = formato.format(atendimentos.getDataAtendimento());
                            atendimentos.setDataAtendimentoString(dataString);
                            if(atendimentos.getTipoAtendimento() == tipoAtendimentos.getIdTipoAtendimento())
                                atendimentos.setTipoAtendimentoString(tipoAtendimentos.getNomeTipoAtendimento());
                        }
                    }
                    request.setAttribute("tipoAtendimentos", listaTipoAtendimentos);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cliente/cliente.jsp");
                    rd.forward(request, response);
                } catch (RemoverAtendimentoException e) {
                    request.setAttribute("mensagem", "Mostrar inválido ");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }  catch (BuscarAtendimentoClienteException e) {
                    request.setAttribute("mensagem", "Erro id Atendimento remover!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }  catch (BuscarEstadoException e) {
                    request.setAttribute("mensagem", "Erro ao acessar estados");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }   catch (BuscarTipoAtendimentoException e) {
                    request.setAttribute("mensagem", "Erro ao buscar tipo atendimentos");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            default:
                try {
                    request.setAttribute("mensagem", "Erro na escolha da opção clienteController!!!");
                    request.setAttribute("action", action);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("mensagem", "Erro na escolha da opção cliente!!!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
