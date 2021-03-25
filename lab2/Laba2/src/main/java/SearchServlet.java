import model.Ticket;
import service.ActionWithTicketImpl;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search-ticket")
public class SearchServlet  extends HttpServlet {

    @EJB
    ActionWithTicketImpl actionWithTicket;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("search-ticket.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="";
        List<Ticket> ticketList = actionWithTicket.searchTicket(request.getParameter("ticket"));

        for (Ticket ticket : ticketList) {
            result += ticket.toString() + "\n";
        }

        request.setAttribute("tickets",result);
        request.getRequestDispatcher("result-search-ticket.jsp").forward(request, response);
    }
}
