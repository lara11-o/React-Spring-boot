package com.example.project.DAO.Opportunity;

import com.example.project.DAO.Repository.OpportunityRepo;
import com.example.project.Entity.Opportunity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OpportunityDAOImp implements OpportunityDAO{
    EntityManager entityManager;
    private OpportunityRepo opportunityRepo;

    @Autowired
    OpportunityDAOImp(EntityManager entityMng) {
        entityManager = entityMng;
    }

    @Override
    @Transactional
    public void save(Opportunity opportunity) {

        entityManager.persist(opportunity);
}

     @Override
    public Opportunity getDetailsById(int id){
         TypedQuery<Opportunity> theQuery = entityManager.createQuery("From Opportunity Where id=:keyname", Opportunity.class);
         theQuery.setParameter("keyname", id);
         return theQuery.getSingleResult();
     }

    @Override
    public List<Opportunity> getAllOpportunitiesOfUser(int userId) {
        TypedQuery<Opportunity> theQuery = entityManager.createQuery(
                "SELECT o FROM Opportunity o JOIN o.user u WHERE u.id = :userId", Opportunity.class);
        theQuery.setParameter("userId", userId);
        return theQuery.getResultList();
    }

    @Override
    public List<Opportunity> searchByCategory(String category){
        TypedQuery<Opportunity> theQuery = entityManager.createQuery(
                "FROM Opportunity WHERE field_of_study = :category", Opportunity.class);
        theQuery.setParameter("category", category);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public int deleteOppOfUser(int id) {
        Opportunity o = entityManager.find(Opportunity.class, id);
        if (o != null) {
            entityManager.remove(o);
            return o.getId();
        } else {
            return -1; // Indicates user with given id was not found
        }
    }



}
