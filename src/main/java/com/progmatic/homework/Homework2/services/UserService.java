package com.progmatic.homework.Homework2.services;

import com.progmatic.homework.Homework2.models.UserProfile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
@Transactional
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile user = em.createQuery(
                "SELECT user FROM UserProfile user WHERE user.username=:name", UserProfile.class)
                .setParameter("name", username)
                .getSingleResult();
        return user;
    }

    @Transactional
    public List<UserProfile> listAllUsers() {
        List<UserProfile> users = em.createQuery(
                "SELECT user FROM UserProfile user", UserProfile.class)
                .getResultList();

        return users;
    }

    @Transactional
    public void saveUser(UserProfile user) {
        em.persist(user);
    }

    @Transactional
    public void registerUser(UserProfile user) {
        em.persist(user);
    }

    @Transactional
    public void changePassword(UserProfile user) {
        UserProfile userFromDb = (UserProfile) loadUserByUsername(user.getUsername());
        userFromDb.setUserPassword(user.getUserPassword());
    }

}
