package persistence;

import model.Country;

import javax.persistence.EntityManager;

import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryCountry {
    EntityManager entityManager;

    public RepositoryCountry() {
        entityManager = getEntityManager();
    }

    public void saveCountry(Country country){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(country);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
    public List<Country> countryList(){
        return entityManager.createQuery("FROM Country", Country.class).getResultList();
    }

    public Country getCountryById(int countryId){
        return entityManager.find(Country.class, countryId);
    }
}
