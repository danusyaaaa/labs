import service.ActionWithTicketImpl;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete-ticket")
public class DeleteServlet extends HttpServlet {

    @EJB
    ActionWithTicketImpl actionWithTicket;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("delete-ticket.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("ticket",actionWithTicket.deleteTicket(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("result-delete-ticket.jsp").forward(request, response);

    }
}
