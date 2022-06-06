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
    private double totalPrice;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public int getTotalPerson() {
        return totalPerson;
    }

    public void setTotalPerson(int totalPerson) {
        this.totalPerson = totalPerson;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", dateIssued=" + dateIssued +
                ", client=" + client +
                ", trip=" + trip +
                ", totalPerson=" + totalPerson +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
