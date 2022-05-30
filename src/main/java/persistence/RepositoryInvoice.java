package persistence;

import model.Invoice;

import javax.persistence.EntityManager;

import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryInvoice {

    EntityManager entityManager;

    public RepositoryInvoice() {
        entityManager = getEntityManager();
    }

    public void saveInvoice(Invoice invoice){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(invoice);
            entityManager.getTransaction();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
    public Invoice getInvoiceById(int invoiceId){
        return entityManager.find(Invoice.class, invoiceId);
    }
    public List<Invoice> invoiceList(){
        return entityManager.createQuery("FROM Invoice", Invoice.class).getResultList();
    }
}
