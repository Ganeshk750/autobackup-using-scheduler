package com.ganesh.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="test1")
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "copyEvenUserProducer", procedureName = "getEvenUser"),@NamedStoredProcedureQuery(name = "deleteOddUserProducer", procedureName = "removeOddUser")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String auth;
}
