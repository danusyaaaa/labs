package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    private String country;
    private String timeArrival;
    private Double cost;
    private String classTicket;

}
