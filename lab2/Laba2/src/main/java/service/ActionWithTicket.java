package service;

import model.Ticket;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ActionWithTicket {

    String deleteTicket(int count);

    List<Ticket> searchTicket(String classTicket);

}
