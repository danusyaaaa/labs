package service;

import model.Ticket;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


@Stateless
public class ActionWithTicketImpl implements ActionWithTicket {

    private List<Ticket> listTicket;

    @PostConstruct
    public void initListTicket() {
        listTicket = new LinkedList<>();
        listTicket.add(new Ticket("Minsk", "12:01", 32.1, "econom"));
        listTicket.add(new Ticket("Brest", "125:01", 12.1, "econom"));
    }

    @Override
    public String deleteTicket(int count) {
        return listTicket.remove(count).toString();
    }

    @Override
    public List<Ticket> searchTicket(String classTicket) {
        return listTicket.stream().
                filter(ticket -> ticket.getClassTicket().equals(classTicket))
                .sorted(new TicketComparator())
                .limit(2)
                .collect(Collectors.toList());

    }

}

class TicketComparator implements Comparator<Ticket> {

    public int compare(Ticket a, Ticket b) {
        return a.getCost().compareTo(b.getCost());
    }

}