package com.ganesh.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @PersistenceContext
    private EntityManager em;

    public List<User> getUsers(){
       return userRepository.findAll();
    }

    public void getEvenUser(){
        em.createNamedStoredProcedureQuery("copyEvenUserProducer").execute();
    }

    public void removeOddUser(){
       em.createNamedStoredProcedureQuery("deleteOddUserProducer").execute();
    }

    public void afterRemoveUser(){
        em.createNamedStoredProcedureQuery("afterRemoveUserProducer").execute();
    }
}
