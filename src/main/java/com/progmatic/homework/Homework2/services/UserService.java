package com.progmatic.homework.Homework2.services;

import com.progmatic.homework.Homework2.models.ProfileType;
import com.progmatic.homework.Homework2.models.UserAuthority;
import com.progmatic.homework.Homework2.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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


    private PasswordEncoder encoder;

    @Autowired
    public UserService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }



    @Transactional
    public List<UserProfile> getAllUsers() {
        return em.createQuery(
                "SELECT user FROM UserProfile user", UserProfile.class)
                .getResultList();
    }



    @Transactional
    public UserDetails loadUserByUserId(int userId) throws UsernameNotFoundException {

        return em.createQuery(
                "SELECT user FROM UserProfile user WHERE user.userId= :id", UserProfile.class)
                .setParameter("id", userId)
                .getSingleResult();
    }

    public UserProfile getOneUser(int userId) {
        try {
            return (UserProfile) loadUserByUserId(userId);
        } catch (Exception e) {
            return null;
        }
    }



    @Transactional
    public UserProfile getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof UserProfile) {
                return (UserProfile) principal;
            }
        }
        return null;
    }

    @Transactional
    public boolean registerUsers() {
        try {
            String userPword = encoder.encode("user");
            String adminPword = encoder.encode("admin");

            UserProfile user = new UserProfile(
                    1, "anita", userPword, "Koszegi Anita",
                    ProfileType.user, UserAuthority.read, "anita.k85@gmail.com" );
            UserProfile admin = new UserProfile(
                    2, "sanyi", adminPword, "Nagy Sándor",
                    ProfileType.admin, UserAuthority.delete, "sanyi564@gamil.com");

            em.persist(user);
            em.persist(admin);

            return true;

        } catch (Exception e) {
            return false;
        }

    }









    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
