package persistence;

import model.City;

import javax.persistence.EntityManager;

import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryCity {

    EntityManager entityManager;

    public RepositoryCity() {
        entityManager = getEntityManager();
    }

    public void saveCity(City city) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(city);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public City getCityById(int cityId) {
        return entityManager.find(City.class, cityId);
    }

    public List<City> cityList() {
        return entityManager.createQuery("FROM City", City.class).getResultList();
    }
}
