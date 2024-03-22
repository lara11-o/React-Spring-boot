package com.example.project.DAO.User;

import com.example.project.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    EntityManager entityManager;

    @Autowired
    UserDAOImp(EntityManager entityMng) {
        entityManager = entityMng;
    }

    @Override
    @Transactional
    public void save(User user) {

        entityManager.persist(user);


    }

    @Override
    public User findById(int id) {
        User u = entityManager.find(User.class, id);
        return u;
    }

//    @Override
//    public List<User> getAll() {
//        TypedQuery<User> theQuery = entityManager.createQuery("From User order by name desc", User.class);
//        return theQuery.getResultList();
//    }

    @Override
    public List<User> findAllUsers(){
        TypedQuery<User> theQuery = entityManager.createQuery("From User", User.class);
        return theQuery.getResultList();
    }

    @Override
    public User getByEmail(String email) {
        TypedQuery<User> theQuery = entityManager.createQuery("From User Where email=:keyname", User.class);
        theQuery.setParameter("keyname", email);
        return theQuery.getSingleResult();
    }

    @Override
    public User findByNameOrEmail(String name, String email) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name OR u.email = :email");
        query.setParameter("name", name);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }
    @Override
    @Transactional
    public int deleteUser(int id) {
        User u = entityManager.find(User.class, id);
        if (u != null) {
            entityManager.remove(u);
            return u.getId();
        } else {
            return -1; // Indicates user with given id was not found
        }
    }



}
