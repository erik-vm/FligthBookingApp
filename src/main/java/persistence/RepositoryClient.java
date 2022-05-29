package persistence;

import model.Client;

import javax.persistence.EntityManager;

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

}
