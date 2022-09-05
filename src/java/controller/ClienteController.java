package controller;

import beans.AtendimentoBeans;
import beans.LoginBeans;
import exception.AtualizarClienteException;
import exception.BuscarAtendimentoClienteException;
import exception.BuscarAtendimentoIdException;
import exception.InserirAtendimentoException;
import exception.RemoverAtendimentoException;
import facade.ClienteFacade;
import java.io.IOException;
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
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        LoginBeans logado = (LoginBeans)session.getAttribute("logado");
        
        /*if(logado.getLogado().equals("cliente")) {
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }*/
        
        String action = request.getParameter("action");
        String idClienteString = request.getParameter("id");
        int idCliente = -1;
        try {
            idCliente = Integer.parseInt(idClienteString);
        } catch (NumberFormatException e) {
            request.setAttribute("mensagem", "Id do cliente inválido " + idClienteString);
            RequestDispatcher rd3 = getServletContext().getRequestDispatcher("/erro.jsp");
            rd3.forward(request, response);
        }
        
        if(action == null) {
            action = "";
        }
        
        switch(action) {
            case "listarAtendimentosCliente":
                try {
                    List<AtendimentoBeans> listaAtendimento = ClienteFacade.buscarAtendimentosCliente(idCliente);
                    request.setAttribute("clientes", listaAtendimento);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cliente/cliente.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentoClienteException e) {
                    request.setAttribute("mensagem", "Mostrar inválido ");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            case "detalharAtendimentosCliente":
                String idDetalhar = request.getParameter("idDetalhar");
                try {
                    int id = Integer.parseInt(idDetalhar);
                    AtendimentoBeans atendimento = ClienteFacade.buscarAtendimentoId(id);
                    request.setAttribute("atendimentoId", atendimento);
                    //TODO, criar tela de visualizar atendimento, usar na modal vai ser mais complexo
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cliente/clienteAtendimentoDetalhado.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentoIdException e) {
                    request.setAttribute("mensagem", "Mostrar inválido ");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (NumberFormatException e) {
                    request.setAttribute("mensagem", "Id para remoção inválido " + idDetalhar);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            case "atualizarCliente":
                try {
                    ClienteFacade.atualizarCliente(request);
                    List<AtendimentoBeans> listaAtendimento = ClienteFacade.buscarAtendimentosCliente(idCliente);
                    request.setAttribute("clientes", listaAtendimento);
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
                }
                break;
            case "inserirAtendimento":
                try {
                    ClienteFacade.inserirAtendimento(request);
                    List<AtendimentoBeans> listaAtendimento = ClienteFacade.buscarAtendimentosCliente(idCliente);
                    request.setAttribute("clientes", listaAtendimento);
                    request.setAttribute("mensagem", "Atendimento criado com sucesso");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cliente/cliente.jsp");
                    rd.forward(request, response);
                } catch (InserirAtendimentoException e) {
                    request.setAttribute("mensagem", "Mostrar inválido ");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentoClienteException e) {
                    request.setAttribute("mensagem", "Erro id Cliente!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            case "removerAtendimentoCliente":
                String idRemover = request.getParameter("idRemover");
                try {
                    int id = Integer.parseInt(idRemover);
                    ClienteFacade.removerAtendimentoCliente(id);
                    List<AtendimentoBeans> listaAtendimento = ClienteFacade.buscarAtendimentosCliente(idCliente);
                    request.setAttribute("clientes", listaAtendimento);
                    request.setAttribute("mensagem", "Dados removido com sucesso");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cliente/cliente.jsp");
                    rd.forward(request, response);
                } catch (RemoverAtendimentoException e) {
                    request.setAttribute("mensagem", "Mostrar inválido ");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (NumberFormatException e) {
                    request.setAttribute("mensagem", "Id para remoção inválido " + idRemover);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                } catch (BuscarAtendimentoClienteException e) {
                    request.setAttribute("mensagem", "Erro id Atendimento remover!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            default:
                try {
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
