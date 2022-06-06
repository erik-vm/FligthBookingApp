package persistence;

import model.City;
import model.Trip;

import javax.persistence.EntityManager;

import java.sql.Time;
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

    public void updateTripDurationById(int id, Time newDuration){
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            entityManager.createQuery("UPDATE Trip SET duration = :newDuration WHERE tripId = :id")
                    .setParameter("id", id)
                    .setParameter("newDuration", newDuration)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public List<Trip> tripListFromCity(City city){
        return entityManager.createQuery("FROM Trip WHERE departureCity = :city", Trip.class).setParameter("city", city).getResultList();
    }

    public Long countTripsPerCity(City city){
      return (Long) entityManager.createQuery("SELECT count(*) FROM Trip WHERE departureCity = :city").setParameter("city", city).getSingleResult();
    }
}
