package com.progmatic.homework.Homework2.services;

import com.progmatic.homework.Homework2.models.BlogContent;
import com.progmatic.homework.Homework2.models.UserProfile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogContentService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<BlogContent> getAllBlogs() {
        return em.createQuery(
                "SELECT blogContent FROM BlogContent blogContent", BlogContent.class)
                .getResultList();
    }




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
