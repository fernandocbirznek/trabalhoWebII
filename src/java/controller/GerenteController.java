package controller;

import beans.AtendimentoBeans;
import beans.EstadoBeans;
import beans.LoginBeans;
import beans.UsuarioBeans;
import exception.AdicionarUsuarioException;
import exception.AtualizarClienteException;
import exception.BuscarAtendimentosException;
import exception.BuscarEstadoException;
import exception.BuscarUsuarioException;
import exception.BuscarUsuariosException;
import exception.RemoverUsuarioException;
import facade.ClienteFacade;
import facade.GerenteFacade;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "GerenteController", urlPatterns = {"/GerenteController"})
public class GerenteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
           
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        LoginBeans logado = (LoginBeans)session.getAttribute("logado");
        
        if(logado.getCargo() == 3) {
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema");
            rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        
        String action = request.getParameter("action");
        String idClienteString = request.getParameter("id");
        int idUsuario = -1;
        try {
            idUsuario = Integer.parseInt(idClienteString);
        } catch (NumberFormatException e) {
            request.setAttribute("mensagem", "Id do cliente inválido " + idClienteString);
            RequestDispatcher rd3 = getServletContext().getRequestDispatcher("/erro.jsp");
            rd3.forward(request, response);
        }
        
        if(action == null) {
            action = "";
        }
        
        switch(action) {
            case "listarUsuarios":
                try {
                    List<UsuarioBeans> usuarios = GerenteFacade.buscarUsuarios();
                    request.setAttribute("usuarios", usuarios);
                    List<AtendimentoBeans> atendimentos = GerenteFacade.buscarAtendimentos();
                    request.setAttribute("atendimentos", atendimentos);
                    rd = getServletContext().getRequestDispatcher("/gerente/gerente.jsp");
                    rd.forward(request, response);
                } catch (BuscarUsuariosException e) {
                    request.setAttribute("mensagem", "Mostrar inválido!!!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentosException e) {
                    request.setAttribute("mensagem", "erro ao buscar os atendimentos!!!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            case "formAdicionarUsuario":
                try {
                    List<EstadoBeans> estados = GerenteFacade.buscarEstados();
                    request.setAttribute("estados", estados);
                    rd = getServletContext().getRequestDispatcher("/gerenteAdicionarUsuario.jsp");
                    rd.forward(request, response);
                } catch (BuscarEstadoException e) {
                    request.setAttribute("mensagem", "Erro ao buscar estado!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            case "adicionarUsuario":
                try {
                    
                    String id = request.getParameter("id");
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
                    String cidade = request.getParameter("cidadeAlterar");
                    String estado = request.getParameter("estadoAlterar");

                    UsuarioBeans usuario = new UsuarioBeans();
                    usuario.setIdUsuario(Integer.parseInt(id));
                    usuario.setNomeUsuario(nome);
                    usuario.setTelefoneUsuario(telefone);
                    usuario.setSenhaUsuario(senha);
                    usuario.setRuaUsuario(rua);
                    usuario.setNumeroUsuario(numero);
                    usuario.setComplementoUsuario(complemento);
                    usuario.setBairroUsuario(bairro);
                    usuario.setCepUsuario(cep);
                    usuario.setCidadeUsuario(Integer.parseInt(cidade));
                    usuario.setEstadoUsuario(Integer.parseInt(estado));
                    
                    
                    GerenteFacade.adicionarUsuario(usuario);
                    List<UsuarioBeans> usuarios = GerenteFacade.buscarUsuarios();
                    request.setAttribute("usuarios", usuarios);
                    List<AtendimentoBeans> atendimentos = GerenteFacade.buscarAtendimentos();
                    request.setAttribute("atendimentos", atendimentos);
                    request.setAttribute("mensagem", "Usuário adicionado com sucesso");
                    rd = getServletContext().getRequestDispatcher("/gerente/gerente.jsp");
                    rd.forward(request, response);
                } catch (AdicionarUsuarioException e) {
                    request.setAttribute("mensagem", "Erro ao atualizar cliente");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarUsuariosException e) {
                    request.setAttribute("mensagem", "Erro buscar usuarios!!!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentosException e) {
                    request.setAttribute("mensagem", "erro ao buscar os atendimentos!!!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            case "formAlterar":
                try {
                    UsuarioBeans usuario = GerenteFacade.buscarUsuario(idUsuario);
                    request.setAttribute("usuario", usuario);
                    rd = getServletContext().getRequestDispatcher("/gerenteFormAlterarUsuario.jsp");
                    rd.forward(request, response);
                } catch (BuscarUsuarioException e) {
                    request.setAttribute("mensagem", "Erro ao buscar usuario id!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break; 
            case "alterarUsuario":
                try {
                    
                    String id = request.getParameter("id");
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
                    String cidade = request.getParameter("cidadeAlterar");
                    String estado = request.getParameter("estadoAlterar");

                    UsuarioBeans usuario = new UsuarioBeans();
                    usuario.setIdUsuario(Integer.parseInt(id));
                    usuario.setNomeUsuario(nome);
                    usuario.setTelefoneUsuario(telefone);
                    usuario.setSenhaUsuario(senha);
                    usuario.setRuaUsuario(rua);
                    usuario.setNumeroUsuario(numero);
                    usuario.setComplementoUsuario(complemento);
                    usuario.setBairroUsuario(bairro);
                    usuario.setCepUsuario(cep);
                    usuario.setCidadeUsuario(Integer.parseInt(cidade));
                    usuario.setEstadoUsuario(Integer.parseInt(estado));
                    
                    ClienteFacade.atualizarCliente(usuario);
                    List<UsuarioBeans> usuarios = GerenteFacade.buscarUsuarios();
                    request.setAttribute("usuarios", usuarios);
                    List<AtendimentoBeans> atendimentos = GerenteFacade.buscarAtendimentos();
                    request.setAttribute("atendimentos", atendimentos);
                    request.setAttribute("mensagem", "Usuário alterado com sucesso");
                    rd = getServletContext().getRequestDispatcher("/gerente/gerente.jsp");
                    rd.forward(request, response);
                } catch (AtualizarClienteException e) {
                    request.setAttribute("mensagem", "Erro ao atualizar cliente");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarUsuariosException e) {
                    request.setAttribute("mensagem", "Erro buscar usuarios!!!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentosException e) {
                    request.setAttribute("mensagem", "erro ao buscar os atendimentos!!!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            case "visualizarUsuario":
                try {
                    UsuarioBeans usuario = GerenteFacade.buscarUsuario(idUsuario);
                    request.setAttribute("usuario", usuario);
                    rd = getServletContext().getRequestDispatcher("/gerenteVisualizarUsuario.jsp");
                    rd.forward(request, response);
                } catch (BuscarUsuarioException e) {
                    request.setAttribute("mensagem", "Erro ao buscar usuario id!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            case "removerUsuario":
                try {
                    GerenteFacade.removerUsuario(idUsuario);
                    List<UsuarioBeans> usuarios = GerenteFacade.buscarUsuarios();
                    request.setAttribute("usuarios", usuarios);
                    List<AtendimentoBeans> atendimentos = GerenteFacade.buscarAtendimentos();
                    request.setAttribute("atendimentos", atendimentos);
                    request.setAttribute("mensagem", "Usuário removido com sucesso");
                    rd = getServletContext().getRequestDispatcher("/gerente/gerente.jsp");
                    rd.forward(request, response);
                } catch (BuscarUsuariosException | RemoverUsuarioException e) {
                    request.setAttribute("mensagem", "Erro ao buscar usuarios!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentosException e) {
                    request.setAttribute("mensagem", "erro ao buscar os atendimentos!!!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            default:
                try {
                    rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("mensagem", "Erro na escolha da opção gerente!!!");
                    rd = getServletContext().getRequestDispatcher("/erro.jsp");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
