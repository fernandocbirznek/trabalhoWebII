package controller;

import beans.LoginBeans;
import beans.UsuarioBeans;
import exception.BuscarUsuarioLoginException;
import facade.LoginFacade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        
        UsuarioBeans usuario = new UsuarioBeans();
        String login = request.getParameter("emailLogin");
        String senha = request.getParameter("senhaLogin");
        LoginBeans loginBean = new LoginBeans();
        
        if(login != null && senha != null) {
            try {
                usuario = LoginFacade.buscarUsuarioLogin(login, senha);
                loginBean.setCpf(usuario.getCepUsuario());
                loginBean.setNome(usuario.getNomeUsuario());
                loginBean.setId(usuario.getIdUsuario());
                loginBean.setCargo(usuario.getCargoUsuario());
                HttpSession session = request.getSession();
                session.setAttribute("logado", loginBean);
                session.setAttribute("usuario", usuario);
            } catch (BuscarUsuarioLoginException e) {
                request.setAttribute("mensagem", "Erro ao buscar usuário!!!");
                rd = getServletContext().getRequestDispatcher("/erro.jsp");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("mensagem", "Senha ou login vazio");
            rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        
        switch(usuario.getCargoUsuario()) {
            case 1:
                request.setAttribute("action", "listarAtendimentosCliente");
                rd = getServletContext().getRequestDispatcher("/ClienteController");
                rd.forward(request, response);
                break;
            case 2:
                //request.setAttribute("action", "listarAtendimentosCliente");
                rd = getServletContext().getRequestDispatcher("/FuncionarioController");
                rd.forward(request, response);
                break;
            case 3:
                //request.setAttribute("action", "listarAtendimentosCliente");
                rd = getServletContext().getRequestDispatcher("/GerenteController");
                rd.forward(request, response);
                break;
            default:
                request.setAttribute("mensagem", "Usuário/senha inválido ou não cadastrado!!!");
                rd = getServletContext().getRequestDispatcher("/erro.jsp");
                rd.forward(request, response);
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
