package com.assignment.personnel.personnelsystem.dao;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.assignment.personnel.personnelsystem.entity.User;
 
@Repository("userDao")
public class UserDao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public User selectUserById(long userId) {
        return entityManager.find(User.class, userId);
    }
 
    public void insertUser(User user) {
        entityManager.persist(user);
    }
 
    public void updateUser(User user) {
 
        User userToUpdate = selectUserById(user.getUserId());
 
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setUserEmail(user.getUserEmail());
        entityManager.flush();
    }
 
    public void deleteUser(long userId) {
        entityManager.remove(selectUserById(userId));
//        throw new RuntimeException("hahahahahaha");
    }
 
    public List<User> selectAllUser() {
        Query query = entityManager.createQuery("from User as usr order by usr.userId");
        return (List<User>) query.getResultList();
    }
 
}