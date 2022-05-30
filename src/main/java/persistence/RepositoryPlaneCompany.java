package persistence;

import model.PlaneCompany;

import javax.persistence.EntityManager;

import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryPlaneCompany {

    EntityManager entityManager;

    public RepositoryPlaneCompany() {
        entityManager= getEntityManager();
    }

    public void savePlaneCompany(PlaneCompany planeCompany){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(planeCompany);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
    public PlaneCompany getPlaneCompanyById(int planeCompanyId){
        return entityManager.find(PlaneCompany.class, planeCompanyId);
    }
    public List<PlaneCompany> planeCompanyList(){
        return entityManager.createQuery("FROM PlaneCompany", PlaneCompany.class).getResultList();
    }
}
