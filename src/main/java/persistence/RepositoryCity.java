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
    public City getCityByName(String name){
        return entityManager.createQuery("FROM City WHERE name = :name", City.class).setParameter("name", name).getSingleResult();
    }

    public List<City> cityList() {
        return entityManager.createQuery("FROM City", City.class).getResultList();
    }

public boolean doesCityExist(String name){
        boolean result = false;
        for (City city : cityList()){
            if (city.getName().equals(name)){
                result = true;
            }
        }
        return result;
}
}
