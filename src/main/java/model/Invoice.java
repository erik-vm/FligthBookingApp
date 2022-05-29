package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Invoice {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int invoiceId;
    private Date dateIssued;
    @ManyToOne
    @JoinColumn (name = "clientId")
    private Client client;
    @ManyToOne
    @JoinColumn (name = "tripId")
    private Trip trip;
    private int totalPerson;
    private Date departureDate;
    private Date arrivalDate;
    private double totalPrice;
}
