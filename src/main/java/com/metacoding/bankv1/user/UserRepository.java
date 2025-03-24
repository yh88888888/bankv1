package com.metacoding.bankv1.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em; //final을 붙이면 무조건 값이 초기화 된다. DI용 RequiredArgs~  필요

    public User findByUsername(String username) {
        Query query = em.createNativeQuery("select * from user_tb where username=?", User.class);
        query.setParameter(1, username);

        try {
            return (User) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public void save(String username, String password, String fullname) {
        Query query = em.createNativeQuery("insert into user_tb(username, password, fullname, createdAt) values(?,?,?,now())");
        query.setParameter(1, username);
        query.setParameter(2, password);
        query.setParameter(3, fullname);
        query.executeUpdate();
    }
}