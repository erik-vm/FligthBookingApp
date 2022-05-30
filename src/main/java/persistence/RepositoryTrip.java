package persistence;

import model.Trip;

import javax.persistence.EntityManager;

import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryTrip {
    EntityManager entityManager;

    public RepositoryTrip() {
        entityManager = getEntityManager();
    }

    public void saveTrip(Trip trip){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(trip);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
    public Trip getTripById(int tripId){
        return entityManager.find(Trip.class, tripId);
    }
    public List<Trip> tripList(){
        return entityManager.createQuery("FROM Trip", Trip.class).getResultList();
    }
}
