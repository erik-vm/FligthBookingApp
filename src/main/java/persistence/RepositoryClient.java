package persistence;

import model.Client;

import javax.persistence.EntityManager;

import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryClient {

    EntityManager entityManager;

    public RepositoryClient() {
        entityManager = getEntityManager();
    }

public void saveClient(Client client){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
}
public List<Client> listAllClients(){

return  entityManager.createQuery("FROM Client", Client.class).getResultList();
}

public Client searchById(int clientId){
return entityManager.find(Client.class, clientId);
}
public void updatePhoneNumber(int clientId, String phoneNumber){
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            entityManager.createQuery("UPDATE Client SET phoneNumber = :phoneNumber WHERE clientId = :id")
                    .setParameter("id", clientId)
                    .setParameter("phoneNumber", phoneNumber)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
}
}
